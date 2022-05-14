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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "group_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupType {

    @Id
    @Column(name = "group_type_code")
    private String groupTypeCode;

    @Column(name = "group_type_name")
    private String groupTypeName;

    @Column(name = "status")
    private Long status;

    @Column(name = "order_index")
    private Long orderIndex;

}
