package com.app.broker.domainevents;

import java.time.LocalDateTime;

public record TransactionInitiatedEvent(
        String transactionId, String userId, String assetType, String action, LocalDateTime timestamp
) {}
