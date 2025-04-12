package com.app.broker.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class SubOrder {
    private String subOrderId;             // Unique sub-order identifier
    private String parentOrderId;          // Reference to the parent order
    private long orderQuantity;            // Quantity executed in this sub-order
    private String orderStatus;            // e.g., "EXECUTED"
    private LocalDateTime executedAt;      // Timestamp of execution
    private String executionVenue;         // Trading venue (e.g., "NASDAQ", "NYSE")
    private BigDecimal price;              // Execution price per unit
    private BigDecimal fee;                // Fee charged for this sub-order
    private BigDecimal commission;         // Commission for this sub-order
    private BigDecimal slippage;           // Difference between expected and actual price
    private String brokerId;               // Broker for this sub-order
    private String clientId;               // Customer identifier (if needed)

    // Constructors, getters, setters, equals, hashCode, and toString methods can be generated.
}

