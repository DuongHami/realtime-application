package com.example.realtimeapplication.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
@RequiredArgsConstructor
public class MessageSchedular {

    private final SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000)
    public void scheduleMessage() {
        this.template.convertAndSend("/topic/chat", "Message from Server");
        System.out.println("Message sent");
    }

}
