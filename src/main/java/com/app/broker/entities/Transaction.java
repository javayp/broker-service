package com.app.broker.entities;

import com.app.broker.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Transaction {
    private final String transactionId;
    private final String userId;
    private final String assetType;
    private final String action;
    private final int quantity;
    private final double price;
    private TransactionStatus status;
    private LocalDateTime createdAt;

}
