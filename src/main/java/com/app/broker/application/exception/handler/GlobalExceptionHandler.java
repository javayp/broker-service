package com.app.broker.application.exception.handler;

import com.app.broker.application.exception.custom.CustomException;
import com.app.broker.application.exception.custom.ParentException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

// Error Response class to structure the error message
class ErrorResponse {
    private String errorCode;
    private String errorMessage;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // Handle other general exceptions not extending CustomException
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGeneralException(
            final Exception exception,
            final HttpServletRequest request) {
        // Fallback error response for generic exceptions
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
