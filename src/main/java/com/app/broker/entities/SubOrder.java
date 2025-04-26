package com.app.broker.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public  class SubOrder extends OrderBase{
    private String subOrderId;             // Unique sub-order identifier
    private long orderQuantity;            // Quantity executed in this sub-order
    private LocalDateTime executedAt;      // Timestamp of execution
    private BigDecimal price;              // Execution price per unit
    private BigDecimal fee;                // Fee charged for this sub-order
    private BigDecimal slippage;           // Difference between expected and actual price

    // Constructors, getters, setters, equals, hashCode, and toString methods can be generated.
}

