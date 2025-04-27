package com.app.broker.application.validation;

import com.app.broker.application.exception.custom.InvalidCustomerAndBrokerIDException;
import com.app.broker.dto.DataRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerAndBrokerIdValidator implements DataRequestValidatorHandler {

    private DataRequestValidatorHandler dataRequestValidatorHandler;

    @Override
    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler) {
        this.dataRequestValidatorHandler=dataRequestValidatorHandler;
    }

    @Override
    public void validate(DataRequestDTO dataRequestDTO) {
        if (dataRequestDTO.brokerId().length()!=5 && !dataRequestDTO.brokerId().startsWith("B-")
                && !dataRequestDTO.customerId().startsWith("C") && dataRequestDTO.customerId().length()!=5){
            log.error("Error in CustomerAndBrokerIdValidator");
            throw new InvalidCustomerAndBrokerIDException(
                    "Invalid customer or/and  BrokerId: min length requires is 5 " + dataRequestDTO.customerId()+":"+ dataRequestDTO.brokerId(),
                    "INVALID_ID",
                    HttpStatus.BAD_REQUEST);

        }

        if (dataRequestValidatorHandler!=null){
            dataRequestValidatorHandler.validate(dataRequestDTO);
        }
    }
}
