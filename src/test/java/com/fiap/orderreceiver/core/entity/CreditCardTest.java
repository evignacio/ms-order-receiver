package com.fiap.orderreceiver.core.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class CreditCardTest {

    @Test
    void shouldCreateCreditCardSuccessfully() {
        String token = "abc123";
        String cvv = "123";

        CreditCard creditCard = new CreditCard(token, cvv);

        assertThat(creditCard.getToken()).isEqualTo(token);
        assertThat(creditCard.getCvv()).isEqualTo(cvv);
    }

    @Test
    void shouldThrowExceptionWhenTokenIsNull() {
        Exception thrown = catchException(() -> new CreditCard(null, "123"));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Token cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenTokenIsEmpty() {
        Exception thrown = catchException(() -> new CreditCard("", "123"));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Token cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCvvIsNull() {
        Exception thrown = catchException(() -> new CreditCard("abc123", null));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CVV cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCvvIsEmpty() {
        Exception thrown = catchException(() -> new CreditCard("abc123", ""));
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CVV cannot be null or empty");
    }
}