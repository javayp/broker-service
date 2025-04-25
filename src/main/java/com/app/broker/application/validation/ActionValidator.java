package com.app.broker.application.validation;

import com.app.broker.dto.DataRequest;
import org.springframework.stereotype.Component;

@Component
public class ActionValidator implements DataRequestValidatorHandler{

   private DataRequestValidatorHandler dataRequestValidatorHandler;

    @Override
    public void setNextHandler(DataRequestValidatorHandler dataRequestValidatorHandler) {
        this.dataRequestValidatorHandler=dataRequestValidatorHandler;
    }

    @Override
    public boolean validate(DataRequest dataRequest) {

        boolean isValid=true;
        isValid=dataRequest.getAction().equals("BUY");

        //linking the chain
        if (dataRequestValidatorHandler!=null){
            dataRequestValidatorHandler.validate(dataRequest);
        }
        return isValid;
    }
}
