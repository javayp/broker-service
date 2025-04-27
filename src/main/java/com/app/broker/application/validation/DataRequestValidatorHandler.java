package com.app.broker.application.validation;

import com.app.broker.dto.DataRequestDTO;

public interface DataRequestValidatorHandler {

    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler);
    public void validate(DataRequestDTO dataRequestDTO);
}
