package com.app.broker.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class OrderBase {

    private String parentOrderId;           // Unique identifier for the order (common)
    private String orderStatus;            // Order status (common)
    private String brokerId;               // Broker identifier (common)
    private BigDecimal fees;               // Fee charged for the order/sub-order (common)
    private BigDecimal commission;         // Commission (common)
    private String executionVenue;         // Trading venue (common)
    private String customerId;               // Customer identifier (common)

}
