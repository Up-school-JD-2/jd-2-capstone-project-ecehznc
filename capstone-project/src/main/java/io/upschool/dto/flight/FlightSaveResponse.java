package io.upschool.dto.flight;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FlightSaveResponse {
	private Long id;
    private Long airlineId;
    private Long routeId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

}
