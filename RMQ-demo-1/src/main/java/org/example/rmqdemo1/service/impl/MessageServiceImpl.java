package org.example.rmqdemo1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.rmqdemo1.dto.MessageDto;
import org.example.rmqdemo1.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MessageDto messageDto) {
        log.info("Send message {}", messageDto);
        rabbitTemplate.convertAndSend(
                "exchange_demo_2",
                "routing_key_demo_2",
                messageDto);
    }
}
