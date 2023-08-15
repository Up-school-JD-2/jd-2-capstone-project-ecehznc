package io.upschool.dto.ticket;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class TicketSaveRequest {
	private String ticketNumber;
    private Long flightId;
    private Long passengerId;

}
