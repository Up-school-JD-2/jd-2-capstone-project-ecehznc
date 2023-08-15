package io.upschool.service;

import org.springframework.stereotype.Service;

import io.upschool.entity.CreditCard;
import io.upschool.repository.CreditCardRepository;

@Service
public class CreditCardService {
	
	
	private CreditCardRepository creditCardRepository;
	public CreditCard saveCreditCard(CreditCard creditCard) {
        // Kredi kartı numarasını maskeli bir şekilde işleyerek kaydetme
        String maskedCardNumber = maskCreditCardNumber(creditCard.getCardNumber());
        creditCard.setCardNumber(maskedCardNumber);

        return creditCardRepository.save(creditCard);
    }
	
	
	
	public static String maskCreditCardNumber(String cardNumber) {
        
        String cleanedCardNumber = cardNumber.replaceAll("[^\\d]", "");

      
        if (cleanedCardNumber.isEmpty()) {
            return "";
        }

        
        StringBuilder maskedCardNumber = new StringBuilder();
        maskedCardNumber.append(cleanedCardNumber, 0, 6);
        for (int i = 6; i < cleanedCardNumber.length() - 4; i++) {
            maskedCardNumber.append("*");
        }
        maskedCardNumber.append(cleanedCardNumber, cleanedCardNumber.length() - 4, cleanedCardNumber.length());

        return maskedCardNumber.toString();
    }

}


