package io.upschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.upschool.entity.Airline;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
	
	List<Airline> findAllByNameIs(String name);
	
	@Query(value="select a from Airline a where a.airport.id = :id")
	List<Airline> findAllByNameIs2(@Param("id") Long sayi);
	
	 @Query(value = "select * from posts p inner join " +
	            "airports a on p.id = a.post_id  ",
	            nativeQuery = true)
	 List<Airline> findAllByNameIs();
	 
	 List<Airline> findByNameIs(String title);

	    @Query(value= "select count(a) from Airline a " +
	            "where a.name = :name")
	    int findAirlineCountByName(@Param("name") String name);
	

}
