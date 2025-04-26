package com.app.broker.application.validation;

import com.app.broker.application.exception.custom.InvalidCustomerAndBrokerIDException;
import com.app.broker.dto.DataRequest;
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
    public void validate(DataRequest dataRequest) {
        if (dataRequest.getBrokerId().length()!=5 && !dataRequest.getBrokerId().startsWith("B-")
                && !dataRequest.getCustomerId().startsWith("C") && dataRequest.getCustomerId().length()!=5){
            log.error("Error in CustomerAndBrokerIdValidator");
            throw new InvalidCustomerAndBrokerIDException(
                    "Invalid customer or/and  BrokerId: min length requires is 5 " + dataRequest.getCustomerId()+":"+dataRequest.getBrokerId(),
                    "INVALID_ID",
                    HttpStatus.BAD_REQUEST);

        }

        if (dataRequestValidatorHandler!=null){
            dataRequestValidatorHandler.validate(dataRequest);
        }
    }
}
