package io.upschool.service;

import org.springframework.stereotype.Service;

import io.upschool.dto.flight.FlightSaveRequest;
import io.upschool.dto.flight.FlightSaveResponse;
import io.upschool.entity.Flight;
import io.upschool.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import io.upschool.entity.Route;
import io.upschool.exception.FlightAlreadySavedException;
import io.upschool.entity.Airline;
import java.util.List;

@Service
@RequiredArgsConstructor

public class FlightService {
	
	private final FlightRepository flightRepository;
    private final AirlineService airlineService;
    private final RouteService routeService;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public FlightSaveResponse save(FlightSaveRequest request) {
        checkIsFlightAlreadySaved(request);
        Flight flightResponse = buildFlightAndSave(request);
        return FlightSaveResponse.builder()
                .id(flightResponse.getId())
                .airlineId(flightResponse.getAirline().getId())
                .routeId(flightResponse.getRoute().getId())
                .build();
    }
    
    @Transactional
    public Flight getReferenceById(Long id) {
        return flightRepository.getReferenceById(id);
    }

    private Flight buildFlightAndSave(FlightSaveRequest request) {
        Airline airlineByReference = airlineService.getReferenceById(request.getAirlineId());
        Route routeByReference = routeService.getReferenceById(request.getRouteId());

        Flight newFlight = Flight.builder()
                .airline(airlineByReference)
                .route(routeByReference)
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .build();

        return flightRepository.save(newFlight);
    }

    private void checkIsFlightAlreadySaved(FlightSaveRequest request) {
        int flightCountByAirlineAndRoute = flightRepository.countFlightsByAirlineIdAndRouteId(
                request.getAirlineId(),
                request.getRouteId()
        );

        if (flightCountByAirlineAndRoute > 0) {
            throw new FlightAlreadySavedException("Bu airline ve rotaya ait uçuş daha önce eklenmiş");
        }
    }

}
