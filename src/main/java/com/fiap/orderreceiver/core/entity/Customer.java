package com.fiap.orderreceiver.core.entity;

public class Customer {
    private String customerId;
    private String addressId;

    public Customer(String customerId, String addressId) {
        setCustomerId(customerId);
        setAddressId(addressId);
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty())
            throw new IllegalArgumentException("Id cannot be null or empty");

        this.customerId = customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    private void setAddressId(String addressId) {
        if (addressId == null || addressId.isEmpty())
            throw new IllegalArgumentException("AddressId cannot be null or empty");

        this.addressId = addressId;
    }
}
