package com.example.demo_order_2.handler;

import com.example.demo_order_2.common.KafkaProducer;
import com.example.demo_order_2.domain.Data;
import com.example.demo_order_2.domain.command.ChangeCustomerInfo;
import com.example.demo_order_2.domain.command.ValidateCustomerCommand;
import com.example.demo_order_2.domain.reply.ValidateCustomerReply;
import com.example.demo_order_2.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.example.demo_order_2.common.MessageUtil.checkCommandType;

@Component
public class CustomerHandler {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerService customerService;


    @KafkaListener(topics = "customer-service", groupId = "group1")
    public void customerServiceHandler(String message) throws JsonProcessingException {
        Data data = objectMapper.readValue(message, Data.class);
        if (Objects.nonNull(data)) {
            handleMessage(data);
        }
    }

    private void handleMessage(Data data) throws JsonProcessingException {
        String type = data.getHeader().get("command_type");
        if (checkCommandType(ValidateCustomerCommand.class, type)) {
            handleValidateCustomerCommand(data);
        }
        if (checkCommandType(ChangeCustomerInfo.class, type)) {
            handleChangeCustomerInfo(data);
        }

    }

    private void handleValidateCustomerCommand(Data data) throws JsonProcessingException {
        ValidateCustomerCommand validateCustomerCommand = objectMapper.readValue(data.getPayload(), ValidateCustomerCommand.class);
        ValidateCustomerReply validateCustomerReply = customerService.checkCustomerInfo(validateCustomerCommand.getCustomerId());
        kafkaProducer.sendMessage(ValidateCustomerReply.class, data, validateCustomerReply);
    }

    private void handleChangeCustomerInfo(Data data) {

    }


}
