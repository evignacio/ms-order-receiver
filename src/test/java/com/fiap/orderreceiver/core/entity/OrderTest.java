package com.fiap.orderreceiver.core.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class OrderTest {

    @Test
    void shouldCreateOrderSuccessfully() {
        Customer customer = new Customer("customer1", "address1");
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));
        CreditCard creditCard = new CreditCard("abc123", "123");

        Order order = new Order(customer, orderItems, creditCard);

        assertThat(order.getCustomer()).isEqualTo(customer);
        assertThat(order.getIrderItems()).isEqualTo(orderItems);
        assertThat(order.getCredtCard()).isEqualTo(creditCard);
    }

    @Test
    void shouldThrowExceptionWhenCustomerIsNull() {
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));
        CreditCard creditCard = new CreditCard("abc123", "123");

        Exception thrown = catchException(() -> new Order(null, orderItems, creditCard));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Customer cannot be null");
    }

    @Test
    void shouldThrowExceptionWhenOrderItemsIsNull() {
        Customer customer = new Customer("customer1", "address1");
        CreditCard creditCard = new CreditCard("abc123", "123");

        Exception thrown = catchException(() -> new Order(customer, null, creditCard));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order items cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenOrderItemsIsEmpty() {
        Customer customer = new Customer("customer1", "address1");
        CreditCard creditCard = new CreditCard("abc123", "123");

        Exception thrown = catchException(() -> new Order(customer, Set.of(), creditCard));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order items cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreditCardIsNull() {
        Customer customer = new Customer("customer1", "address1");
        Set<OrderItem> orderItems = Set.of(new OrderItem("SKU123", 2));

        Exception thrown = catchException(() -> new Order(customer, orderItems, null));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Credit card cannot be null");
    }
}