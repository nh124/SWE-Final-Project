package com.campus_connect.campus_connect.chatController;

import com.campus_connect.campus_connect.Model.Message;
import com.campus_connect.campus_connect.service.WSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

    @Autowired
    private WSservice service;

    @PostMapping("/send-Message")
    public void sendMessage(@RequestBody final Message message){
        service.notifyFrontend(message.getMessageContent());
    }
}
