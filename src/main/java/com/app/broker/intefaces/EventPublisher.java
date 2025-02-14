package com.app.broker.intefaces;

public interface EventPublisher {
    void publishEvent(String topic, String key, Object payload);
}
