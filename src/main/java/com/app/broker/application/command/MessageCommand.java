package com.app.broker.application.command;


import com.app.broker.entities.ParentOrder;
import com.app.broker.intefaces.EventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MessageCommand {

    private final EventPublisher eventPublisher;

    public MessageCommand(EventPublisher eventPublisher){
        this.eventPublisher=eventPublisher;
    }

    public void sendMessage(ParentOrder parentOrder){
        eventPublisher.publishEvent("parent-order-topic",parentOrder.getParentOrderId(),parentOrder);
    }
}
