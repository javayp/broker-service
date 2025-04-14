package com.app.broker.application;

import com.app.broker.dto.DataRequest;
import com.app.broker.entities.ParentOrder;
import com.app.broker.infrastructure.messaging.KafkaEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class TransactionService {

    private KafkaEventPublisher kafkaEventPublisher;

    @Autowired
    public TransactionService(KafkaEventPublisher kafkaEventPublisher) {
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    public void initiateAction(DataRequest dataRequest) {
        if (dataRequest.getAction().equals("BUY")){
            performBuyTransaction(dataRequest);
        }else {

        }
    }

    private void performBuyTransaction(DataRequest dataRequest){

        int totalQuantity = dataRequest.getTotalQuantity();
        var parentOrder=ParentOrder.builder()
                .parentOrderId(String.valueOf(UUID.randomUUID()))
                .customerId( dataRequest.getCustomerId())
                .assetId(dataRequest.getAssetId())
                .orderCategory(dataRequest.getOrderCategory())
                    .totalQuantity(dataRequest.getTotalQuantity())
                .executedQuantity(0)
                .orderStatus("PARTIALLY_EXECUTED")
                .expectedSplits((int) Math.ceil((double) totalQuantity / 10000))
                .completedSplits(0)
                .orderType(dataRequest.getOrderType())
                .strategy("Order Slicing")
                .executionStrategy(new Random().nextBoolean() ? "Market" : "Limit")
                .submissionTime(LocalDateTime.now())
                .acknowledgmentTime(LocalDateTime.now())
                .executionStart(LocalDateTime.now())
                .fees(new BigDecimal(totalQuantity*0.002))
                .totalCommission(new BigDecimal(totalQuantity*0.001))
                .brokerId(dataRequest.getBrokerId())
                .exchange(dataRequest.getExchange())
                .lastUpdated(LocalDateTime.now())
                .build();

        kafkaEventPublisher.publishEvent("parent-order-topic",
                parentOrder.getParentOrderId(),parentOrder);
    }

}
