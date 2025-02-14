package com.app.broker.dto;

import lombok.Data;

public record AssetTransactionRequest(
        String userId,
        String assetType,
        String action,
        int quantity,
        Double price
) {
    public AssetTransactionRequest {
        // Add validation logic if required
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
