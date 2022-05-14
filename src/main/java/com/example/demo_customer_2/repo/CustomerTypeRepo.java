package com.example.demo_customer_2.repo;

import com.example.demo_customer_2.domain.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepo extends JpaRepository<CustomerType, String> {
    CustomerType getCustomerTypeByCustomerType(String customerType);

}
