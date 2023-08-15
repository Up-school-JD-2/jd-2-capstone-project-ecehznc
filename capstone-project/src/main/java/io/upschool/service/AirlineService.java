package io.upschool.service;

import org.springframework.stereotype.Service;

import io.upschool.dto.AirlineSaveRequest;
import io.upschool.dto.AirlineSaveResponse;
import io.upschool.dto.AirlineUpdateRequest;
import io.upschool.entity.Airline;
import io.upschool.entity.Airport;
import io.upschool.exception.AirlineAlreadySavedException;
import io.upschool.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {

	private final AirlineRepository airlineRepository;
	private final AirportService airportService;

	 public List<Airline>findAirlineByName(String name){
	 return airlineRepository.findAllByNameIs(name);
	 }

	public List<Airline> getAllAirlines() {
		List<Airline> allAirlines = airlineRepository.findAll();
		return allAirlines;
	}
		
	public Airline save(Airline  airline) {
        var airport = airportService.save(airline.getAirport());
        airline.setAirport(airport);
        return airlineRepository.save(airline);
    }

	@Transactional
	public AirlineSaveResponse save(AirlineSaveRequest request) {
        checkIsAirlineAlreadySaved(request);
		Airline airlineResponse = buildAirlineAndSave(request);// yeni airport oluşturulup veritab kaydediliyo
		return AirlineSaveResponse.builder().id(airlineResponse.getId())
				.airportName(airlineResponse.getAirport().getName()).build();
	}

	@Transactional
    public Airline getReferenceById(Long id) {
        return airlineRepository.getReferenceById(id);
    }

	private Airline buildAirlineAndSave(AirlineSaveRequest request) {
		Airport airportByReference = airportService.getReferenceById(request.getAirportId());
		Airline newAirline = Airline.builder().name(request.getName()).airport(airportByReference).build();
		return airlineRepository.save(newAirline);
	}

	
	private void checkIsAirlineAlreadySaved(AirlineSaveRequest request) {
	    int airlineCountByName = airlineRepository.findAirlineCountByName(request.getName());
	    if (airlineCountByName > 0) {
	        List<Airline> existingAirlinesWithSameName = airlineRepository.findAllByNameIs(request.getName());

	        for (Airline existingAirline : existingAirlinesWithSameName) {
	            if (existingAirline.getAirport().getName().equals(request.getName())) {
	                throw new AirlineAlreadySavedException("Bu airline daha önce aynı airporta eklenmiş");
	            }
	        }
	    }
	}

	
	
}
