package com.fiap.orderreceiver.core.entity;

public class CreditCard {
    private String token;
    private String cvv;

    public CreditCard(String token, String cvv) {
        setToken(token);
        setCvv(cvv);
    }

    public String getToken() {
        return token;
    }

    private void setToken(String token) {
        if (token == null || token.isEmpty())
            throw new IllegalArgumentException("Token cannot be null or empty");

        this.token = token;
    }

    public String getCvv() {
        return cvv;
    }

    private void setCvv(String cvv) {
        if (cvv == null || cvv.isEmpty())
            throw new IllegalArgumentException("CVV cannot be null or empty");

        this.cvv = cvv;
    }
}
