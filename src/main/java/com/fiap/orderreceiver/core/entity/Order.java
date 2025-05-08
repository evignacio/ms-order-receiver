package com.fiap.orderreceiver.core.entity;

import java.util.Set;

public class Order {
    private Customer customer;
    private Set<OrderItem> irderItems;
    private CreditCard credtCard;

    public Order(Customer customer, Set<OrderItem> irderItems, CreditCard credtCard) {
        setCustomer(customer);
        setIrderItems(irderItems);
        setCredtCard(credtCard);
    }

    public Set<OrderItem> getIrderItems() {
        return irderItems;
    }

    private void setIrderItems(Set<OrderItem> irderItems) {
        if (irderItems == null || irderItems.isEmpty())
            throw new IllegalArgumentException("Order items cannot be null or empty");

        this.irderItems = irderItems;
    }

    public CreditCard getCredtCard() {
        return credtCard;
    }

    private void setCredtCard(CreditCard credtCard) {
        if (credtCard == null)
            throw new IllegalArgumentException("Credit card cannot be null");

        this.credtCard = credtCard;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    private void setCustomer(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null");

        this.customer = customer;
    }
}
