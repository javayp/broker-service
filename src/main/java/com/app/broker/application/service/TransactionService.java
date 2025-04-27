package com.app.broker.application.service;

import com.app.broker.application.command.GeneralCommand;
import com.app.broker.dto.DataRequestDTO;
import com.app.broker.dto.MessageOrderBaseRequestDTO;
import com.app.broker.dto.SubOrderDTO;
import com.app.broker.entities.ParentOrder;
import com.app.broker.entities.SubOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Slf4j
@Service
public class TransactionService {

    private final GeneralCommand<ParentOrder, DataRequestDTO> buildParentOrderCommand;
    private final GeneralCommand<SubOrder, SubOrderDTO> buildSubOrderOrderCommand;
    private final GeneralCommand<Void, MessageOrderBaseRequestDTO> messageOrderCommand;

    @Autowired
    public TransactionService(GeneralCommand<ParentOrder, DataRequestDTO> buildParentOrderCommand, GeneralCommand<SubOrder, SubOrderDTO> buildSubOrderOrderCommand, GeneralCommand<Void, MessageOrderBaseRequestDTO> messageOrderCommand) {
        this.buildParentOrderCommand = buildParentOrderCommand;
        this.buildSubOrderOrderCommand = buildSubOrderOrderCommand;
        this.messageOrderCommand = messageOrderCommand;
    }

    public void initiateTransaction(DataRequestDTO dataRequestDTO){
        ParentOrder parentOrder = buildParentOrderCommand.execute(dataRequestDTO);
        log.info(String.valueOf(parentOrder));
        triggerMessage(new MessageOrderBaseRequestDTO("parent-topic",parentOrder));
        triggerSubOrdersBasedOnParentOrder(parentOrder);
    }

    private void triggerSubOrdersBasedOnParentOrder(ParentOrder parentOrder)  {
        try {
            long totalQuantity = parentOrder.getTotalQuantity();
            int expectedSplits = parentOrder.getExpectedSplits();
            BigDecimal price = BigDecimal.valueOf(100 + new Random().nextInt(150));
            for (int i = 0; i < parentOrder.getExpectedSplits(); i++) {
                Thread.sleep(5000 + new Random().nextInt(15000));
                SubOrder subOrder = buildSubOrderOrderCommand.execute(new SubOrderDTO(totalQuantity / (expectedSplits - i), price,parentOrder));
                totalQuantity=totalQuantity-10000;
                messageOrderCommand.execute(new MessageOrderBaseRequestDTO("suborder-topic",subOrder));
            }
        }catch (Exception e){
            log.error("Error while producing suborders!!");
        }
    }

    private void triggerMessage(MessageOrderBaseRequestDTO messageOrderBaseRequestDTO){
        messageOrderCommand.execute(messageOrderBaseRequestDTO);
    }

}
