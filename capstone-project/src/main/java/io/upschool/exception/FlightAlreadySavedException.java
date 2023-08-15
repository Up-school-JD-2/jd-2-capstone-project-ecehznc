package io.upschool.exception;

import java.io.Serializable;

public class FlightAlreadySavedException extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 public FlightAlreadySavedException(String message) {
	        super(message);
	    }

	    public FlightAlreadySavedException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
