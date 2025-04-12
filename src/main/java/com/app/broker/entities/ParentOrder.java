package com.app.broker.entities;

import com.app.broker.enums.TransactionStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ParentOrder {

    private String parentOrderId;          // Unique identifier for the order
    private String customerId;             // Customer who placed the order
    private String assetId;                // Identifier for the asset (e.g., "AAPL", "NVDA")
    private String orderCategory;          // e.g., "EQUITY", "OPTION", "BOND", "MUTUAL_FUND", "IPO"
    private long totalQuantity;            // Total units (shares, contracts, etc.) intended
    private long executedQuantity;         // Cumulative quantity executed across sub-orders
    private String orderStatus;            // e.g., "PENDING", "PARTIALLY_EXECUTED", "FULLY_EXECUTED"
    private int expectedSplits;            // Planned number of sub-orders (slices)
    private int completedSplits;           // Number of sub-orders executed
    private String orderType;              // e.g., "Market", "Limit"
    private String strategy;               // General execution strategy (e.g., "Order Slicing")
    private String executionStrategy;      // Specific algorithm used (e.g., "VWAP", "TWAP")
    private LocalDateTime submissionTime;  // When the order was submitted
    private LocalDateTime acknowledgmentTime; // When the order was acknowledged
    private LocalDateTime executionStart;  // When execution started
    private LocalDateTime executionEnd;    // When execution ended
    private BigDecimal fees;               // Additional fees charged
    private BigDecimal totalCommission;    // Aggregated commission from sub-orders
    private String brokerId;               // Broker identifier
    private String exchange;               // Trading venue
    private LocalDateTime lastUpdated;     // Last update timestamp

}
