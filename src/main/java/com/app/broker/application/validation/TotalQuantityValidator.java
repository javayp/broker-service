package com.app.broker.application.validation;

import com.app.broker.application.exception.custom.InvalidTotalQuantityException;
import com.app.broker.dto.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public void validate(DataRequest dataRequest) {

        if (dataRequest.getTotalQuantity()%2!=0){
            log.error("OrderQuantity cannot be odd");
            throw new InvalidTotalQuantityException("Quantity has to be even","INTERNAL_SERVER_ERROR", HttpStatus.BAD_REQUEST);
        }

        if (dataRequestValidatorHandler!=null){
            dataRequestValidatorHandler.validate(dataRequest);
        }
    }
}
