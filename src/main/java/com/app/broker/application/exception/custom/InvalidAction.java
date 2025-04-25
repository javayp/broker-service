package com.app.broker.application.exception.custom;

public class InvalidAction extends ParentException{

    public InvalidAction(String message) {
        super(message);
    }

    public InvalidAction(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAction(String message, String code) {
        super(message, code);
    }
}
