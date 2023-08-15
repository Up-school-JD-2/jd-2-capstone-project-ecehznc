package io.upschool.dto;

import io.upschool.dto.route.RouteSaveResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardSaveResponse {
	private Long id;
    private String cardNumber;
    private Long passengerId;

}
