package com.app.broker.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ParentOrder extends OrderBase{

    private String assetId;        // Asset for the order
    private String orderCategory;  // Category of the order (e.g., "EQUITY")
    private long totalQuantity;    // Total quantity of units
    private long executedQuantity; // Executed quantity of units
    private String orderType;      // Order type (e.g., "Market")

    private int expectedSplits;            // Planned number of sub-orders (slices)
    private int completedSplits;           // Number of sub-orders executed
    //Market Order: an instruction to buy or sell immediately at the best available current price
    //Limit Order: an instruction to buy or sell only at (or better than) a specified price.
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
