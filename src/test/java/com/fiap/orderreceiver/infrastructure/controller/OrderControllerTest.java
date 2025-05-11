package com.fiap.orderreceiver.infrastructure.controller;

import com.fiap.orderreceiver.core.entity.CreditCard;
import com.fiap.orderreceiver.core.entity.Customer;
import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.entity.OrderItem;
import com.fiap.orderreceiver.core.usecase.RegisterOrderRequestUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RegisterOrderRequestUseCase registerOrderRequestUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldRegisterOrderSuccessfully() throws Exception {
        Customer customer = new Customer("customer1", "address1");
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));
        CreditCard creditCard = new CreditCard("abc123", "123");
        Order order = new Order(customer, orderItems, creditCard);

        doNothing().when(registerOrderRequestUseCase).execute(order);

        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());

        verify(registerOrderRequestUseCase).execute(any(Order.class));
    }
}