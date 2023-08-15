package io.upschool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.upschool.dto.route.RouteSaveRequest;
import io.upschool.dto.route.RouteSaveResponse;
import io.upschool.entity.Route;
import io.upschool.repository.RouteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


import java.util.List;


@Service
@RequiredArgsConstructor
public class RouteService {

	private final RouteRepository routeRepository;

    public RouteSaveResponse save(RouteSaveRequest request) {
        Route newRoute = Route.builder()
            .sourceAirportCode(request.getSourceAirportCode())
            .destinationAirportCode(request.getDestinationAirportCode())
            .build();

        Route savedRoute = routeRepository.save(newRoute);

        return RouteSaveResponse.builder()
            .id(savedRoute.getId())
            .sourceAirportCode(savedRoute.getSourceAirportCode())
            .destinationAirportCode(savedRoute.getDestinationAirportCode())
            .build();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    
    @Transactional
    public Route getReferenceById(Long id) {
        return routeRepository.getReferenceById(id);
    }
}
