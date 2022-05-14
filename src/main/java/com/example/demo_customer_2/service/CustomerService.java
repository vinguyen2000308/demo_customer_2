package com.example.demo_customer_2.service;

import com.example.demo_customer_2.common.Const;
import com.example.demo_customer_2.domain.entity.Customer;
import com.example.demo_customer_2.domain.reply.ValidateCustomerReply;
import com.example.demo_customer_2.repo.CustomerRepository;
import com.example.demo_customer_2.repo.CustomerTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerTypeRepo customerTypeRepo;


    public ValidateCustomerReply checkCustomerInfo(Long customerId) {
        ValidateCustomerReply validateCustomerReply = new ValidateCustomerReply();
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer;
        try {
            customer = optionalCustomer.get();
        } catch (Exception e) {
            validateCustomerReply.setMessage("Could Not Found Customer with ID " + customerId);
            validateCustomerReply.setCode("400");
            validateCustomerReply.setCustomerId(customerId);
            return validateCustomerReply;
        }


        if (Const.CUSTOMER_STATUS != customer.getStatus()) {
            validateCustomerReply.setMessage("Could Not Found Customer with ID " + customerId);
            validateCustomerReply.setCode("400");
            validateCustomerReply.setCustomerId(customerId);
            return validateCustomerReply;
        }

        if (customer.getBalance() <= 0) {
            validateCustomerReply.setMessage("Customer do not have enough money, current in account " + customer.getBalance());
            validateCustomerReply.setCode("400");
            validateCustomerReply.setCustomerId(customerId);
            return validateCustomerReply;
        }
        Double tax = null;
        if (Objects.nonNull(customer.getCustomerType())) {
            tax = customerTypeRepo.getCustomerTypeByCustomerType(customer.getCustomerType()).getTax();
        }

        return ValidateCustomerReply.builder().customerId(customerId)
                .tax(tax)
                .code("200")
                .message("CUSTOMER VALIDATED").build();

    }
}