package com.app.broker.application.exception.custom;

import org.springframework.http.HttpStatus;

public class InvalidTotalQuantityException extends RuntimeException{

    private String errorCode;
    private HttpStatus httpStatus;

    public InvalidTotalQuantityException(String message,String errorCode,HttpStatus httpStatus){
        super(message);
        this.errorCode=errorCode;
        this.httpStatus=httpStatus;
    }
}
