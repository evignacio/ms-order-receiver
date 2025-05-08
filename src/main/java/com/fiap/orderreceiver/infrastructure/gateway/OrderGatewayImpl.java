package com.fiap.orderreceiver.infrastructure.gateway;

import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.gateway.OrderGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderGatewayImpl implements OrderGateway {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${kafka.topic.order-receiver.name}")
    private String orderReceiverTopic;

    @Value("${kafka.topic.order-receiver.partition}")
    private int partition;

    public OrderGatewayImpl(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void registerOrderRequest(Order order) {
        log.info("Registering order request in kafka");
        kafkaTemplate.send(orderReceiverTopic, partition, null, order);
        log.info("Order request register in kafka successfully");
    }
}
