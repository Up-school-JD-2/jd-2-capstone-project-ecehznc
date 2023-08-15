package io.upschool.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.upschool.service.TicketService;
import lombok.RequiredArgsConstructor;
import io.upschool.entity.Ticket;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TicketController {
	
	private final TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }


    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

}
