package com.fiap.orderreceiver.core.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderItemTest {

    @Test
    void shouldCreateOrderItemSuccessfully() {
        String sku = "SKU123";
        int amount = 5;

        OrderItem orderItem = new OrderItem(sku, amount);

        assertThat(orderItem.getSku()).isEqualTo(sku);
        assertThat(orderItem.getAmount()).isEqualTo(amount);
    }

    @Test
    void shouldThrowExceptionWhenSkuIsNull() {
        Exception thrown = catchException(() -> new OrderItem(null, 5));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("SKU cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenSkuIsEmpty() {
        Exception thrown = catchException(() -> new OrderItem("", 5));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("SKU cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenAmountIsZero() {
        Exception thrown = catchException(() -> new OrderItem("SKU123", 0));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Amount must be greater than zero");
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNegative() {
        Exception thrown = catchException(() -> new OrderItem("SKU123", -1));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Amount must be greater than zero");
    }
}