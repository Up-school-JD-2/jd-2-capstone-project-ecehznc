package io.upschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import io.upschool.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository <Route, Long> {
	
	@Query("SELECT r FROM Route r WHERE r.sourceAirportCode = :sourceAirportCode AND r.destinationAirportCode = :destinationAirportCode")
    List<Route> findBySourceAirportCodeAndDestinationAirportCode(
            @Param("sourceAirportCode") String sourceAirportCode,
            @Param("destinationAirportCode") String destinationAirportCode
    );

	 
	

}
