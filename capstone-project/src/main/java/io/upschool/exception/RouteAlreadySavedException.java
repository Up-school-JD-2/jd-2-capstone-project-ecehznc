package io.upschool.exception;

import java.io.Serializable;

public class RouteAlreadySavedException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public RouteAlreadySavedException(String message) {
        super(message);
    }

    public RouteAlreadySavedException(String message, Throwable cause) {
        super(message, cause);
    }
}
