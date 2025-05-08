package com.fiap.orderreceiver.core.entity;

public class Customer {
    private String id;
    private String addressId;

    public Customer(String id, String addressId) {
        setId(id);
        setAddressId(addressId);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Id cannot be null or empty");

        this.id = id;
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
