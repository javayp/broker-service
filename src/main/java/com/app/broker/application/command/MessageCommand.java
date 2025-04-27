package com.app.broker.application.command;

import com.app.broker.dto.MessageOrderBaseRequestDTO;
import com.app.broker.intefaces.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageCommand implements GeneralCommand<Void, MessageOrderBaseRequestDTO> {

    private final EventPublisher eventPublisher;

    @Autowired
    public MessageCommand(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Void execute(MessageOrderBaseRequestDTO orderBase) {
        eventPublisher.publishEvent(orderBase.topicName(),orderBase.data().getParentOrderId(),orderBase);
        return null;
    }
}
