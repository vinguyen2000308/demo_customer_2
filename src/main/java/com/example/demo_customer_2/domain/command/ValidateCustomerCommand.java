package com.example.demo_customer_2.domain.command;


import com.example.demo_customer_2.domain.Command;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ValidateCustomerCommand implements Command {
    private Long customerId;
    private Long orderId;

}
