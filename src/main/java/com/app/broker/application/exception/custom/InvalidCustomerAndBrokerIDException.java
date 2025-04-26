package com.app.broker.application.exception.custom;

import org.springframework.http.HttpStatus;

public class InvalidCustomerAndBrokerIDException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus httpStatusCode;

    public InvalidCustomerAndBrokerIDException(String message, String errorCode, HttpStatus httpStatusCode) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
}
