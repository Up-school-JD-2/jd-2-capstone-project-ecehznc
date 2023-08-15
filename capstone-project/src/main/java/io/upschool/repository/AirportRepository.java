package io.upschool.repository;

import io.upschool.entity.Airport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	@Query("SELECT a FROM Airport a WHERE a.name = :name")
	List<Airport> findAllByName(String name);

	@Query("SELECT a FROM Airport a WHERE a.id = :id")
	List<Airport> findAllById(@Param("id") Airport airport);
	
	Airport findByName (String name);
	
	@Query("SELECT a FROM Airport a WHERE a.code = :code")
	Airport findByCode(@Param("code") Airport airport);
	
	
	
	



}
