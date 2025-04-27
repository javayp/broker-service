package com.app.broker.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ParentOrder extends OrderBase{

    private String assetId;        // Asset for the order
    private String orderCategory;  // Category of the order (e.g., "EQUITY")
    private long totalQuantity;    // Total quantity of units
    private long executedQuantity; // Executed quantity of units
    private String orderType;      // Order type (e.g., "Market")
    private int expectedSplits;            // Planned number of sub-orders (slices)
    private int completedSplits;           // Number of sub-orders executed
    private String strategy;               // General execution strategy (e.g., "Order Slicing")
    private String executionStrategy;      // Specific algorithm used (e.g., "VWAP", "TWAP")
    private BigDecimal totalCommission;    // Aggregated commission from sub-orders
    private String exchange;               // Trading venue
    private LocalDateTime submissionTime;  // When the order was submitted
    private LocalDateTime acknowledgmentTime; // When the order was acknowledged
    private LocalDateTime executionStart;  // When execution started
    private LocalDateTime executionEnd;    // When execution ended
    private LocalDateTime lastUpdated;     // Last update timestamp

}


