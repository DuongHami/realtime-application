package com.example.realtimeapplication.listener;

import com.example.realtimeapplication.entity.Message;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Date;

@Component
public class ChatEventListener {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatEventListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    public void handleSessionConected(SessionConnectedEvent event){
        System.out.println("CONNECTED");
        messagingTemplate.convertAndSend("/topic/chat", new Message("System", "Neuer User verbunden", null));

    }

    @EventListener
    public void handleSessionDisconnected(SessionDisconnectEvent event){
        System.out.println("DISCONNECTED");
        messagingTemplate.convertAndSend("/topic/chat", new Message("System", "User hat den Raum verlassen", null));
    }
}
