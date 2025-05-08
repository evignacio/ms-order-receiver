package com.fiap.orderreceiver.core.entity;

public class OrderItem {
    private String sku;
    private int amount;

    public OrderItem(String sku, int amount) {
        setSku(sku);
        setAmount(amount);
    }

    public String getSku() {
        return sku;
    }

    private void setSku(String sku) {
        if (sku == null || sku.isEmpty())
            throw new IllegalArgumentException("SKU cannot be null or empty");

        this.sku = sku;
    }

    public int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than zero");

        this.amount = amount;
    }
}
