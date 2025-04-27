package com.app.broker.application.command;

import com.app.broker.dto.SubOrderDTO;
import com.app.broker.entities.SubOrder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Component
public class BuildSubOrderCommand implements GeneralCommand<SubOrder, SubOrderDTO> {
    @Override
    public SubOrder execute(SubOrderDTO subOrderDTO) {
        SubOrder subOrder=new SubOrder();
        subOrder.setParentOrderId(subOrderDTO.parentOrder().getParentOrderId());
        subOrder.setCustomerId(subOrderDTO.parentOrder().getCustomerId());
        subOrder.setBrokerId(subOrderDTO.parentOrder().getBrokerId());
        subOrder.setSubOrderId(String.valueOf(UUID.randomUUID()));
        subOrder.setOrderQuantity(subOrderDTO.quantity());
        subOrder.setOrderStatus("COMPLETED");
        subOrder.setFees(BigDecimal.valueOf(subOrderDTO.quantity()*0.0005));
        subOrder.setCommission(BigDecimal.valueOf(subOrderDTO.quantity()*0.0009));
        subOrder.setPrice(subOrderDTO.price().add(BigDecimal.valueOf(new Random().nextInt(2))));
        subOrder.setExecutedAt(LocalDateTime.now());
        subOrder.setSlippage(subOrder.getPrice().subtract(subOrderDTO.price()));
        subOrder.setOrderQuantity(subOrder.getOrderQuantity());
        return subOrder;
    }
}
