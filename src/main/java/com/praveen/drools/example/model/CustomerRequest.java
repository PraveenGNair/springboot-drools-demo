package com.praveen.drools.example.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Customer request POJO.
 * @author Praveen.Nair
 */
public final class CustomerRequest {

    private final long id;
    private final Integer age;
    private final String gender;
    private final Integer numberOfOrders;

    public CustomerRequest(long id, Integer age, String gender, Integer numberOfOrders) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.numberOfOrders = numberOfOrders;
    }

    public long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerRequest that = (CustomerRequest) o;
        return id == that.id &&
                Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(numberOfOrders, that.numberOfOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, gender, numberOfOrders);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerRequest.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("age=" + age)
                .add("gender=" + gender)
                .add("numberOfOrders='" + numberOfOrders + "'")
                .toString();
    }
}
