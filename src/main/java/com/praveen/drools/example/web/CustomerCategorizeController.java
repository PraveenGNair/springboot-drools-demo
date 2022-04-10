package com.praveen.drools.example.web;

import com.praveen.drools.example.model.CustomerRequest;
import com.praveen.drools.example.model.CustomerType;
import com.praveen.drools.example.service.CustomerCategorizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getCustomerType")
public class CustomerCategorizeController {

    private final CustomerCategorizeService customerCategorizeService;

    public CustomerCategorizeController(
            CustomerCategorizeService customerCategorizeService) {
        this.customerCategorizeService = customerCategorizeService;
    }

    @PostMapping
    public ResponseEntity<CustomerType> getCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerType customerType = customerCategorizeService.getCustomerType(customerRequest);
        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }

}
