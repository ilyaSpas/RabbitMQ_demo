package org.example.rmqdemo2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createOrder(@RequestBody String message) {
        rabbitTemplate.convertAndSend(
                "exchange_demo_3",
                "routing_key_demo_3",
                message);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
