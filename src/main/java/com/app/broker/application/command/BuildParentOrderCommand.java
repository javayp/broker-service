package com.app.broker.application.command;

import com.app.broker.dto.DataRequestDTO;
import com.app.broker.entities.ParentOrder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Component
public class BuildParentOrderCommand implements GeneralCommand<ParentOrder, DataRequestDTO> {

    @Override
    public ParentOrder execute(DataRequestDTO dataRequestDTO) {
        int totalQuantity = dataRequestDTO.totalQuantity();
        ParentOrder parentOrder = new ParentOrder();

        // Manually set values for each field
        parentOrder.setParentOrderId(String.valueOf(UUID.randomUUID())); // parentOrderId
        parentOrder.setCustomerId(dataRequestDTO.customerId());          // customerId
        parentOrder.setAssetId(dataRequestDTO.assetId());                // assetId
        parentOrder.setOrderCategory(dataRequestDTO.orderCategory());    // orderCategory
        parentOrder.setTotalQuantity(dataRequestDTO.totalQuantity());    // totalQuantity
        parentOrder.setExecutedQuantity(0);                               // executedQuantity
        parentOrder.setOrderStatus("PARTIALLY_EXECUTED");                 // orderStatus

        parentOrder.setExpectedSplits((int) Math.ceil((double) totalQuantity / 10000));  // expectedSplits
        parentOrder.setCompletedSplits(0);                                 // completedSplits
        parentOrder.setOrderType(dataRequestDTO.orderType());             // orderType
        parentOrder.setStrategy("Order Slicing");                         // strategy
        parentOrder.setExecutionStrategy(new Random().nextBoolean() ? "Market" : "Limit"); // executionStrategy
        parentOrder.setSubmissionTime(LocalDateTime.now());               // submissionTime
        parentOrder.setAcknowledgmentTime(LocalDateTime.now());           // acknowledgmentTime
        parentOrder.setExecutionStart(LocalDateTime.now());               // executionStart
        parentOrder.setFees(new BigDecimal(totalQuantity * 0.002));      // fees
        parentOrder.setTotalCommission(new BigDecimal(totalQuantity * 0.001)); // totalCommission
        parentOrder.setBrokerId(dataRequestDTO.brokerId());              // brokerId
        parentOrder.setExchange(dataRequestDTO.exchange());              // exchange
        parentOrder.setLastUpdated(LocalDateTime.now());                  // lastUpdated

        // Return the manually built ParentOrder object
        return parentOrder;
    }
}
