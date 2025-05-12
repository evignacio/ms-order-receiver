package com.fiap.orderreceiver.core.entity;

import java.util.Set;

public class Order {
    private Customer customer;
    private Set<OrderItem> orderItems;
    private CreditCard creditCard;

    public Order(Customer customer, Set<OrderItem> orderItems, CreditCard creditCard) {
        setCustomer(customer);
        setOrderItems(orderItems);
        setCreditCard(creditCard);
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    private void setOrderItems(Set<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty())
            throw new IllegalArgumentException("Order items cannot be null or empty");

        this.orderItems = orderItems;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    private void setCreditCard(CreditCard creditCard) {
        if (creditCard == null)
            throw new IllegalArgumentException("Credit card cannot be null");

        this.creditCard = creditCard;
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
