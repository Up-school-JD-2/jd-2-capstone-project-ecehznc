package io.upschool.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.upschool.dto.CreditCardSaveRequest;
import io.upschool.dto.CreditCardSaveResponse;
import io.upschool.entity.CreditCard;
import io.upschool.service.CreditCardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CreditCardController {

    
	private final CreditCardService creditCardService;

    @PostMapping("/save")
    public ResponseEntity<CreditCardSaveResponse> saveCreditCard(@RequestBody CreditCard request) {
        
        CreditCard savedCreditCard = creditCardService.saveCreditCard(request);

        CreditCardSaveResponse response = new CreditCardSaveResponse();
        response.setId(savedCreditCard.getId());
        response.setCardNumber(savedCreditCard.getCardNumber());
        response.setPassengerId(savedCreditCard.getPassenger().getId());

        return ResponseEntity.ok(response);
    }

    
}

