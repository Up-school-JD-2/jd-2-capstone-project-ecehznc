package io.upschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.upschool.entity.Passenger;
import io.upschool.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	
	List<CreditCard> findByPassenger(Passenger passenger);

}
