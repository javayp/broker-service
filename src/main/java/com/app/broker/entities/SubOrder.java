package com.app.broker.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public  class SubOrder extends OrderBase{
    private String subOrderId;             // Unique sub-order identifier
    private long orderQuantity;            // Quantity executed in this sub-order
    private LocalDateTime executedAt;      // Timestamp of execution
    private BigDecimal price;              // Execution price per unit
    private BigDecimal slippage;

    // Difference between expected and actual price
}

