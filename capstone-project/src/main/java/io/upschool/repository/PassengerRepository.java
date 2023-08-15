package io.upschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.upschool.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    List<Passenger> findAllByFirstNameAndLastName(String firstName, String lastName);
    
    @Query(value = "SELECT p FROM Passenger p WHERE p.flight.id = :flightId")
    List<Passenger> findAllByFlightId(@Param("flightId") Long flightId);

    int countPassengersByFlightId(Long flightId);
    
    @Query(value= "SELECT COUNT(p) FROM Passenger p WHERE p.email = :email")
    int findPassengerCountByEmail(@Param("email") String email);
}
