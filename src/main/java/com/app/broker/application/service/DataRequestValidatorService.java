package com.app.broker.application.service;

import com.app.broker.application.validation.ActionValidator;
import com.app.broker.application.validation.CustomerAndBrokerIdValidator;
import com.app.broker.application.validation.DataRequestValidatorHandler;
import com.app.broker.application.validation.TotalQuantityValidator;
import com.app.broker.dto.DataRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class DataRequestValidatorService {

    private final DataRequestValidatorHandler dataRequestValidatorHandler;

    public DataRequestValidatorService(ActionValidator actionValidator, CustomerAndBrokerIdValidator customerAndBrokerIdValidator, TotalQuantityValidator totalQuantityValidator){
       this.dataRequestValidatorHandler=actionValidator;
        actionValidator.setNextHandler(customerAndBrokerIdValidator);
        customerAndBrokerIdValidator.setNextHandler(totalQuantityValidator);
    }

    public void validateDataRequestDTO(DataRequestDTO dataRequestDTO){
        dataRequestValidatorHandler.validate(dataRequestDTO);
    }
}
