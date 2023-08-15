package io.upschool.exception;

import java.io.Serializable;

public class PassengerAlreadySavedException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 public PassengerAlreadySavedException(String message) {
	        super(message);
	    }

	    public PassengerAlreadySavedException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
