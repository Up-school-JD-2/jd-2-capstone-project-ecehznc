package io.upschool.dto;

import io.upschool.dto.route.RouteSaveRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardSaveRequest {
	private String cardNumber;
    private Long passengerId;

}
