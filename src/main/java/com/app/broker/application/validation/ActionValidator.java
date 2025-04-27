package com.app.broker.application.validation;

import com.app.broker.application.exception.custom.InvalidActionRequestException;
import com.app.broker.dto.DataRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ActionValidator implements DataRequestValidatorHandler{

   private DataRequestValidatorHandler dataRequestValidatorHandler;

    @Override
    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler) {
        this.dataRequestValidatorHandler=dataRequestValidatorHandler;
    }

    @Override
    public void validate(DataRequestDTO dataRequestDTO) {

        // Validate the action, if invalid throw custom exception
        if (!dataRequestDTO.action().equals("BUY")) {
            throw new InvalidActionRequestException(
                    "Invalid action: " + dataRequestDTO.action(),
                    "INVALID_ACTION",
                    HttpStatus.BAD_REQUEST);
        }

        // Link to the next handler if available
        if (dataRequestValidatorHandler != null) {
            dataRequestValidatorHandler.validate(dataRequestDTO);
        }
    }
}
