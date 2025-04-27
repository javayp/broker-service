package com.app.broker.dto;

import com.app.broker.entities.ParentOrder;

import java.math.BigDecimal;

public record SubOrderDTO(long quantity, BigDecimal price,ParentOrder parentOrder){}
