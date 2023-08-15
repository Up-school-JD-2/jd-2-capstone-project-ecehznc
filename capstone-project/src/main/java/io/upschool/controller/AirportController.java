package io.upschool.controller;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.upschool.dto.AirportSaveRequest;
import io.upschool.dto.AirportSaveResponse;
import io.upschool.dto.AirportUpdateRequest;
import io.upschool.entity.Airport;
import io.upschool.service.AirportService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class AirportController {
	private final AirportService airportService;



    @GetMapping("/airports")
    public ResponseEntity<List<Airport>> getAirports() {
        var airports = airportService.getAllAirports();
        HttpHeaders headers = new HttpHeaders();
        headers.add("ESENBOGA", "Header value esenboga");
        return ResponseEntity.status(HttpStatus.OK)
        		.headers(headers)
        		.body(airports);
    }

    @PostMapping("/airports")
    public ResponseEntity<AirportSaveResponse> createAirport(@Valid @RequestBody AirportSaveRequest airportSaveRequest) {     
        var response = airportService.save(airportSaveRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/airports")
    public ResponseEntity<AirportSaveResponse> updateAirport(@RequestBody AirportUpdateRequest request) {
        return ResponseEntity.ok(airportService.update(request));
    }
    
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable("id") Long id) {
        airportService.delete(id);
    }

    

}
