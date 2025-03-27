package com.app.broker.entities;

import com.app.broker.enums.TransactionStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ParentOrder {

    private String parentOrderId;
    private String customerId;
    private String placedBy;
    private String assetId;
    private int totalQuantity;
    private int split;
    private int executedQuantity = 0;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<SubOrder> subOrders = new ArrayList<>();

}
