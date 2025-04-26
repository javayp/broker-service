package com.app.broker.entities;

import java.math.BigDecimal;

public abstract class OrderBase {

    private String parentOrderId;           // Unique identifier for the order (common)
    private String orderStatus;            // Order status (common)
    private String brokerId;               // Broker identifier (common)
    private BigDecimal fees;               // Fee charged for the order/sub-order (common)
    private BigDecimal commission;         // Commission (common)
    private String executionVenue;         // Trading venue (common)
    private String clientId;               // Customer identifier (common)

}
