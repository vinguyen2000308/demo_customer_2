package com.example.demo_customer_2.repo;

import com.example.demo_customer_2.domain.entity.GroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTypeRepo extends JpaRepository<GroupType, String> {
}
