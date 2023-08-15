package io.upschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	List<Ticket> findByPassenger(Passenger passenger);

    List<Ticket> findByFlight(Flight flight);

    List<Ticket> findAll();

    Optional<Ticket> findById(Long id);
	

}
