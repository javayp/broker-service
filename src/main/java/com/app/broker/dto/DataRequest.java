package com.app.broker.dto;

import lombok.Data;

@Data
public class DataRequest {

    private String action;
    private String customerId;
    private String brokerId;
    private String orderCategory;
    private String orderType;
    private int totalQuantity;
    private String assetId;
    private String exchange;
}
