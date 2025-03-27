package com.app.broker.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubOrder {
    private String subOrderId;
    private ParentOrder parentOrder;
    private String userId;
    private String assetId;
    private double price;
    private String status;
    private LocalDateTime executedAt;
}
