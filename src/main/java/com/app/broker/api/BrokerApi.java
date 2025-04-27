package com.app.broker.api;

import com.app.broker.application.service.DataRequestValidatorService;
import com.app.broker.application.service.TransactionService;
import com.app.broker.dto.DataRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerApi {

    private final TransactionService transactionService;
    private final DataRequestValidatorService dataRequestValidatorService;

    @Autowired
    public BrokerApi(TransactionService transactionService, DataRequestValidatorService dataRequestValidatorService) {
        this.transactionService = transactionService;
        this.dataRequestValidatorService = dataRequestValidatorService;
    }

    @PostMapping("/buy")
    public void buy(@RequestBody DataRequestDTO dataRequestDTO){
        dataRequestValidatorService.validateDataRequestDTO(dataRequestDTO);
        transactionService.initiateTransaction(dataRequestDTO);
    }
}
