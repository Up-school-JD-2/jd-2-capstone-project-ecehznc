package io.upschool.service;

import org.springframework.stereotype.Service;
import io.upschool.dto.AirportSaveRequest;
import io.upschool.dto.AirportSaveResponse;
import io.upschool.dto.AirportUpdateRequest;
import io.upschool.entity.Airport;
import io.upschool.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AirportService {
    
	private final AirportRepository airportRepository;
    public AirportSaveResponse save(AirportSaveRequest airportSaveRequest) {
    	var newAirport =Airport
    			.builder()
    			.name(airportSaveRequest.getName())
    			.code(airportSaveRequest.getCode())
    			.build();
    	Airport savedAirport = airportRepository.save(newAirport);
        return AirportSaveResponse
            .builder()
            .id(savedAirport.getId())
            .nameCode(savedAirport.getName() + " " + savedAirport.getCode())
            .build();
    }

    
   public Airport save(Airport airport) {
	   return airportRepository.save(airport);
   }
    
    @Transactional
    public Airport getReferenceById(Long id) {
        return airportRepository.getReferenceById(id);
    }
    
    public AirportSaveResponse update(AirportUpdateRequest request) {
    	var optionalAirport = airportRepository.findById(request.getId());
    	if(optionalAirport.isPresent()) {
    		var airport = optionalAirport.get();
    		airport.setName(request.getName());
    		airport.setCode(request.getCode());
    		airport = airportRepository.save(airport);
    		return AirportSaveResponse.builder()
    				.nameCode(airport.getName()+" "+airport.getCode())
    				.id(airport.getId())
    				.build();
    	}
    	throw new RuntimeException("Airport not found");
    }
        
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
    
    public Airport findAirportById(Long id) {
    	return airportRepository.findById(id).orElse(null);
    }
   
    public Airport findAirportByName(String name) {
    	return airportRepository.findByName(name);
    }
    
    public void delete(Long id) {
        var airport = airportRepository.findById(id).get();
        airport.setActive(false);
        airportRepository.save(airport);
        airportRepository.deleteById(id);
    }


}

