package com.app.broker.application.validation;

import com.app.broker.dto.DataRequest;
import lombok.extern.slf4j.Slf4j;
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
    public boolean validate(DataRequest dataRequest) {
        boolean isValid=true;
        if (dataRequest.getBrokerId().length()!=5 && !dataRequest.getBrokerId().startsWith("B-")
                && !dataRequest.getCustomerId().startsWith("C") && dataRequest.getCustomerId().length()!=5){
            log.error("Error in CustomerAndBrokerIdValidator");
            isValid=false;
        }

        if (dataRequestValidatorHandler!=null){
            dataRequestValidatorHandler.validate(dataRequest);
        }

        return isValid;
    }
}
