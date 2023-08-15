package io.upschool.service;

import org.springframework.stereotype.Service;

import io.upschool.dto.passenger.PassengerSaveRequest;
import io.upschool.dto.passenger.PassengerSaveResponse;
import io.upschool.entity.Passenger;
import io.upschool.exception.PassengerAlreadySavedException;
import io.upschool.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.upschool.entity.Flight;

@Service
@RequiredArgsConstructor

public class PassengerService {
	private final PassengerRepository passengerRepository;
    private final FlightService flightService;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Transactional
    public PassengerSaveResponse save(PassengerSaveRequest request) {
        checkIsPassengerAlreadySaved(request);
        Passenger passengerResponse = buildPassengerAndSave(request);
        return PassengerSaveResponse.builder()
                .id(passengerResponse.getId())
                .firstName(passengerResponse.getFirstName())
                .lastName(passengerResponse.getLastName())
                .email(passengerResponse.getEmail())
                .phoneNumber(passengerResponse.getPhoneNumber())
                .flightId(passengerResponse.getFlight().getId())
                .build();
    }

    private Passenger buildPassengerAndSave(PassengerSaveRequest request) {
        Flight flightByReference = flightService.getReferenceById(request.getFlightId());
        Passenger newPassenger = Passenger.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .flight(flightByReference)
                .build();
        return passengerRepository.save(newPassenger);
    }

    private void checkIsPassengerAlreadySaved(PassengerSaveRequest request) {
        int passengerCountByEmail = passengerRepository.findPassengerCountByEmail(request.getEmail());
        if (passengerCountByEmail > 0) {
            throw new PassengerAlreadySavedException("Bu yolcu aynı uçuşa daha önce eklenmiş");
        }
    }

}
