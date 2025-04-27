package com.app.broker.dto;

public record DataRequestDTO(

     String action,
     String customerId,
     String brokerId,
     String orderCategory,
     String orderType,
     int totalQuantity,
     String assetId,
     String exchange
){}
