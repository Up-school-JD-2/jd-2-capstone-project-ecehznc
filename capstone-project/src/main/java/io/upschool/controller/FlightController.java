package io.upschool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.upschool.service.FlightService;
import io.upschool.dto.BaseResponse;
import io.upschool.dto.flight.FlightSaveRequest;
import io.upschool.dto.flight.FlightSaveResponse;
import io.upschool.entity.Flight;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/flight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.save(flight));
    }

    @PostMapping("/flights")
    public ResponseEntity<Object> createFlight(@RequestBody FlightSaveRequest request) {
        FlightSaveResponse flightSaveResponse = flightService.save(request);
        BaseResponse<FlightSaveResponse> response = BaseResponse.<FlightSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(flightSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }
}
