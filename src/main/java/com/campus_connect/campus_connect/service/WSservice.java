package com.campus_connect.campus_connect.service;
import com.campus_connect.campus_connect.Model.responseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSservice {

    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    public WSservice(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    public void notifyFrontend(final String message){
        responseMessage responce =  new responseMessage(message);
        messagingTemplate.convertAndSend("/topic/message", responce);
    }
}
