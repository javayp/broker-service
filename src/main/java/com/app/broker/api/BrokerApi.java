package com.app.broker.api;

import com.app.broker.application.TransactionService;
import com.app.broker.dto.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerApi {

    private final TransactionService transactionService;

    @Autowired
    public BrokerApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/buy")
    public void buy(@RequestBody DataRequest dataRequest){
        transactionService.initiateAction(dataRequest);
    }
}
