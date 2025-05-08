package com.fiap.orderreceiver.core.gateway;

import com.fiap.orderreceiver.core.entity.Order;

public interface OrderGateway {
    void registerOrderRequest(Order order);
}
