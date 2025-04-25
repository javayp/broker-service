package com.app.broker.application.validation;

import com.app.broker.dto.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TotalQuantityValidator implements DataRequestValidatorHandler{

    private DataRequestValidatorHandler dataRequestValidatorHandler;

    @Override
    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler) {
        this.dataRequestValidatorHandler=dataRequestValidatorHandler;
    }

    @Override
    public boolean validate(DataRequest dataRequest) {
        boolean isValid=true;

        if (dataRequest.getTotalQuantity()%2!=0){
            log.error("OrderQuantity cannot be odd");
            isValid=false;
        }
        return isValid;
    }
}
