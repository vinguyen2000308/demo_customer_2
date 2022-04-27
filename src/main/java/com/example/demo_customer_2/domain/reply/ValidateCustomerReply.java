package com.example.demo_customer_2.domain.reply;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class ValidateCustomerReply implements ReplyMessage {
    private String code;
    private String message;
    private Long customerId;

}
