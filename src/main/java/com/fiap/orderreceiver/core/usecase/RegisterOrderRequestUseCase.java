package com.fiap.orderreceiver.core.usecase;

import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.gateway.OrderGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterOrderRequestUseCase {
    private final OrderGateway orderGateway;

    public RegisterOrderRequestUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public void execute(Order order) {
        log.info("Registering order request for user, id {}", order.getCustomer().getCustomerId());
        orderGateway.registerOrderRequest(order);
        log.info("Order request completed successfully ");
    }
}
