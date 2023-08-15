package io.upschool.exception;

import java.io.Serializable;

public class AirlineAlreadySavedException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
	
	 public AirlineAlreadySavedException(String message) {
	        super(message);
	    }

	    public AirlineAlreadySavedException(String message, Throwable cause) {
	        super(message, cause);
	    }

}