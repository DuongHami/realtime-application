package com.example.realtimeapplication.controller;

import com.example.realtimeapplication.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/chat")
    public Message sendMessage(@Payload Message message) {
        message.setDate(new Date());
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/chat")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("user", message.getUser());
        return message;
    }
}
