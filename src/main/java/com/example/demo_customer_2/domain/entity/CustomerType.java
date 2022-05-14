package com.example.demo_customer_2.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerType {
    @Id
    @Column(name = "cus_type")
    private String customerType;

    @Column(name = "group_type")
    private String groupTypeId;

    @Column(name = "status")
    private Long status;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "updated_date")
    private LocalDateTime updatedDateTime;


    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "updated_user")
    private String updatedUser;

}
