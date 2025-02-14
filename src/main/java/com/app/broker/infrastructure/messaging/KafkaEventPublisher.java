package com.app.broker.infrastructure.messaging;

import com.app.broker.intefaces.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaEventPublisher(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishEvent(String topic, String key, Object payload) {

        try {
            String message = objectMapper.writeValueAsString(payload);
            CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(topic, key, message);
            completableFuture.whenComplete((stringStringSendResult, throwable) -> {
                if (throwable==null){
                    log.info("SendMessage completed");
                }else {
                    log.error("SendMessage failed!");
                }
            });
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize payload for topic: {}, key: {}. Payload: {}", topic, key, payload, e);
            throw new RuntimeException("Failed to serialize/send message payload", e);
        }
    }
}
