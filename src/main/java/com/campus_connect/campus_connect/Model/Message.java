package com.campus_connect.campus_connect.Model;

public class Message {
    private String messageContent;

    public Message(){}
    public Message(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
