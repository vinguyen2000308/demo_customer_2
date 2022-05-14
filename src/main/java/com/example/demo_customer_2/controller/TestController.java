package com.example.demo_customer_2.controller;


import com.example.demo_customer_2.domain.entity.Customer;
import com.example.demo_customer_2.domain.entity.CustomerType;
import com.example.demo_customer_2.domain.entity.GroupType;
import com.example.demo_customer_2.repo.CustomerRepository;
import com.example.demo_customer_2.repo.CustomerTypeRepo;
import com.example.demo_customer_2.repo.GroupTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class TestController {

    @Autowired
    private CustomerTypeRepo customerTypeRepo;

    @Autowired
    private GroupTypeRepo groupTypeRepo;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @PostMapping("/test")
    public void testSave() {
        GroupType ind = GroupType.builder()
                .groupTypeCode("IDV")
                .groupTypeName("INDIVIDUAL")
                .status(1l)
                .orderIndex(0l)
                .build();

        GroupType org = GroupType.builder()
                .groupTypeCode("ORG")
                .groupTypeName("ORGANIZATION")
                .status(1l)
                .orderIndex(1l)
                .build();
        groupTypeRepo.saveAll(List.of(ind, org));

        CustomerType company = CustomerType.builder()
                .groupTypeId("ORG")
                .customerType("COMPANY")
                .createdUser("Nguyen Vi")
                .createdDateTime(LocalDateTime.now())
                .status(1l)
                .tax(12.0)
                .description("This is for company")
                .build();

        CustomerType university = CustomerType.builder()
                .groupTypeId("ORG")
                .customerType("UNS")
                .createdUser("Nguyen Vi")
                .createdDateTime(LocalDateTime.now())
                .status(1l)
                .tax(10.0)
                .description("This is for university")
                .build();
        customerTypeRepo.saveAll(List.of(company, university));

        Optional<Customer> customerOptional = customerRepository.findById(1l);
        Customer customer = customerOptional.get();
        customer.setCustomerType(company.getCustomerType());
        customerRepository.save(customer);

    }
}
