package com.app.broker.application.exception.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// Custom Base Exception class that includes status code
@Getter
public class CustomException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus httpStatus;  // Add the HTTP status code field

    public CustomException(String message, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

}
