package com.fiap.orderreceiver.core.usecase;

import com.fiap.orderreceiver.core.entity.CreditCard;
import com.fiap.orderreceiver.core.entity.Customer;
import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.entity.OrderItem;
import com.fiap.orderreceiver.core.gateway.OrderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterOrderRequestUseCaseTest {

    @InjectMocks
    private RegisterOrderRequestUseCase useCase;

    @Mock
    private OrderGateway orderGateway;

    @Test
    void shouldRegisterOrderSuccessfully() {
        Customer customer = new Customer("customer1", "address1");
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));
        CreditCard creditCard = new CreditCard("abc123", "123");

        Order order = new Order(customer, orderItems, creditCard);

        useCase.execute(order);

        verify(orderGateway, times(1)).registerOrderRequest(order);
    }
}