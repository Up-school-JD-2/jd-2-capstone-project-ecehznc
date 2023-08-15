package io.upschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.upschool.entity.Airline;
import io.upschool.entity.Flight;
public interface FlightRepository extends JpaRepository <Flight, Long> {
	List <Flight> findAllByAirline(Airline airline);
	
	@Query("SELECT f FROM Flight f WHERE f.route.sourceAirportCode = :airportCode")
	List<Flight> findFlightsByDepartureAirport(@Param("airportCode") String airportCode);
	
	@Query("SELECT COUNT(f) FROM Flight f WHERE f.airline.id = :airlineId AND f.route.id = :routeId")
	int countFlightsByAirlineIdAndRouteId(
	        @Param("airlineId") Long airlineId,
	        @Param("routeId") Long routeId
	);




	
	//@Query("select f  from Flight where f.departureAirport = :airport")
    //List<Flight> findFlightsByDepartureAirport(@Param("airport") Airport airport);
	
	

}
