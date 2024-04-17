package org.example.rmqdemo1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.rmqdemo1.dto.MessageDto;
import org.example.rmqdemo1.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createOrder(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
