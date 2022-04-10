package com.praveen.drools.example.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * CustomerType Response model.
 * @author Praveen.Nair
 */
public class CustomerType {

    private CustomerCategory customerType;

    public CustomerCategory getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerCategory customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerType that = (CustomerType) o;
        return customerType == that.customerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerType.class.getSimpleName() + "[", "]")
                .add("customerType=" + customerType)
                .toString();
    }
}
