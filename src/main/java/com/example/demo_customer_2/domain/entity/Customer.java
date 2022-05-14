package com.example.demo_customer_2.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "status")
    private Integer status;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "national_id")
    private Integer nationalId;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "updated_date")
    private LocalDateTime updatedDateTime;

    @Column(name = "customer_type")
    private String customerType;

}
