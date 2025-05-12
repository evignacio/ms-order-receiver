package com.fiap.orderreceiver.core.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class CustomerTest {

    @Test
    void shouldCreateCustomerSuccessfully() {
        String id = "1";
        String addressId = "10";

        Customer customer = new Customer(id, addressId);

        assertThat(customer.getCustomerId()).isEqualTo(id);
        assertThat(customer.getAddressId()).isEqualTo(addressId);
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        Exception thrown = catchException(() -> new Customer(null, "10"));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Id cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenIdIsEmpty() {
        Exception thrown = catchException(() -> new Customer("", "10"));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Id cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenAddressIdIsNull() {
        Exception thrown = catchException(() -> new Customer("1", null));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("AddressId cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenAddressIdIsEmpty() {
        Exception thrown = catchException(() -> new Customer("1", ""));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("AddressId cannot be null or empty");
    }
}