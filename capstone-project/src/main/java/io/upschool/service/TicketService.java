package io.upschool.service;

import java.util.List;

import org.springframework.stereotype.Service;


import io.upschool.entity.Passenger;
import io.upschool.entity.Ticket;
import io.upschool.repository.TicketRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TicketService {
	private final TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getTicketsByPassenger(Passenger passenger) {
        return ticketRepository.findByPassenger(passenger);
    }

  
}
