package io.upschool.controller;


import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.upschool.dto.route.RouteSaveRequest;
import io.upschool.dto.route.RouteSaveResponse;
import io.upschool.entity.Route;
import io.upschool.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RouteController {

	private final RouteService routeService;

    @PostMapping("/route")
    public ResponseEntity<RouteSaveResponse> createRoute(@Valid @RequestBody RouteSaveRequest routeSaveRequest) {     
        var response = routeService.save(routeSaveRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/route")
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }
}

