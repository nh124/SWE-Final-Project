package com.campus_connect.campus_connect.chatController;

import com.campus_connect.campus_connect.Model.Message;
import com.campus_connect.campus_connect.Model.responseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {
    @MessageMapping("/messages")
    @SendTo("/topic/messages")
    public responseMessage getMessage(Message message) throws InterruptedException{
        Thread.sleep(1000);
        return new responseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }
}

