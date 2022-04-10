package com.praveen.drools.example.service;

import com.praveen.drools.example.model.CustomerRequest;
import com.praveen.drools.example.model.CustomerType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Customer Categorization service.
 * @author Praveen.Nair
 */
public class CustomerCategorizeService {

    private final KieContainer kieContainer;

    public CustomerCategorizeService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public CustomerType getCustomerType(CustomerRequest customerRequest) {
        CustomerType customerType = new CustomerType();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("customerType", customerType);
        kieSession.insert(customerRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return customerType;
    }
}
