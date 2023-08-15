package io.upschool.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.upschool.entity.Passenger;
import io.upschool.service.PassengerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getPassengers() {
        var passengers = passengerService.getAllPassengers();
        return ResponseEntity.ok(passengers);
    }

    @PostMapping("/passenger")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok(passengerService.save(passenger));
    }

   
}
