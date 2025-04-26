package com.app.broker.application.validation;

import com.app.broker.dto.DataRequest;

public interface DataRequestValidatorHandler {

    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler);
    public void validate(DataRequest dataRequest);
}
