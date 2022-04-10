package com.praveen.drools.example.model;

/**
 * Customer Categories.
 */
public enum CustomerCategory {

    GENERAL, KIDS, SENIOR_CITIZEN, SUSPENDED;

    public String getValue() {
        return this.toString();
    }
}
