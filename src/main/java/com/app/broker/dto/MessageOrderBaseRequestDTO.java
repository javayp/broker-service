package com.app.broker.dto;

import com.app.broker.entities.OrderBase;

public record MessageOrderBaseRequestDTO(String topicName, OrderBase data) {
}
