package com.fiap.orderreceiver.infrastructure.gateway;

import com.fiap.orderreceiver.core.entity.CreditCard;
import com.fiap.orderreceiver.core.entity.Customer;
import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.entity.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.lang.reflect.Field;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderGatewayImplTest {

    @Mock
    private KafkaTemplate<String, Order> kafkaTemplate;

    @InjectMocks
    private OrderGatewayImpl orderGateway;

    @Test
    void shouldRegisterOrderRequestSuccessfully() throws Exception {
        setPrivateField(orderGateway, "orderReceiverTopic", "order-receiver-topic");
        setPrivateField(orderGateway, "partition", 0);

        Customer customer = new Customer("customer1", "address1");
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));
        CreditCard creditCard = new CreditCard("abc123", "123");

        Order order = new Order(customer, orderItems, creditCard);

        orderGateway.registerOrderRequest(order);

        verify(kafkaTemplate, times(1)).send("order-receiver-topic", 0, null, order);
    }

    // Método utilitário para configurar campos privados
    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}