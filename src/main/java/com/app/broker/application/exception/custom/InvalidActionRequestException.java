package com.app.broker.application.exception.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidActionRequestException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus httpStatus;

    public InvalidActionRequestException(String message, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

}
