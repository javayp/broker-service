package com.app.broker.application;

import com.app.broker.dto.AssetTransactionRequest;
import com.app.broker.entities.Transaction;
import com.app.broker.enums.TransactionStatus;
import com.app.broker.infrastructure.messaging.KafkaEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class TransactionService {

    private KafkaEventPublisher kafkaEventPublisher;

    @Autowired
    public TransactionService(KafkaEventPublisher kafkaEventPublisher) {
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    public void initiateAction(AssetTransactionRequest assetTransactionRequest) {
        if (assetTransactionRequest.action().equals("BUY")){
            performBuyTransaction(assetTransactionRequest);
        }else {

        }
    }

    private void performBuyTransaction(AssetTransactionRequest assetTransactionRequest){
        // produce event transaction_initiated
        // simulate a call to external system & produce event transaction_validated
        //derive a logic to say transaction_successful or transaction_failure
        try {
            Transaction initialTransaction = Transaction.builder()
                    .transactionId(String.valueOf(UUID.randomUUID()))
                    .action(assetTransactionRequest.action())
                    .userId(assetTransactionRequest.userId())
                    .assetType(assetTransactionRequest.assetType())
                    .price(assetTransactionRequest.price())
                    .status(TransactionStatus.INITIATED)
                    .quantity(assetTransactionRequest.quantity())
                    .createdAt(LocalDateTime.now(ZoneId.of("UTC")))
                    .build();
            kafkaEventPublisher.publishEvent("single-broker-event-topic", assetTransactionRequest.userId(),initialTransaction);

            Thread.sleep(5000);
            initialTransaction.setStatus(TransactionStatus.VALIDATED);
            initialTransaction.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
            kafkaEventPublisher.publishEvent("single-broker-event-topic", assetTransactionRequest.userId(), initialTransaction);

            Thread.sleep(8000);
            initialTransaction.setStatus(TransactionStatus.EXECUTED);
            initialTransaction.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
            kafkaEventPublisher.publishEvent("single-broker-event-topic", assetTransactionRequest.userId(), initialTransaction);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
