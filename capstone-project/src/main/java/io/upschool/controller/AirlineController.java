package io.upschool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.upschool.dto.AirlineSaveRequest;
import io.upschool.dto.AirlineSaveResponse;
import io.upschool.dto.BaseResponse;
import io.upschool.entity.Airline;
import io.upschool.service.AirlineService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AirlineController {
     
    private final AirlineService airlineService;

    @GetMapping("/airline")
    public ResponseEntity<List<Airline>> getAirlines(){
    	var airlines = airlineService.getAllAirlines();
    	return ResponseEntity.ok(airlines);
    }

    @PostMapping("/airline")
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline){
    	return ResponseEntity.ok(airlineService.save(airline));
    }
        
    @PostMapping("/airlines")
    public ResponseEntity<Object> createAirline(@RequestBody AirlineSaveRequest request){
    	var airlineSaveResponse = airlineService.save(request);
    	var response =  BaseResponse.<AirlineSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(airlineSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }
    
}

	


