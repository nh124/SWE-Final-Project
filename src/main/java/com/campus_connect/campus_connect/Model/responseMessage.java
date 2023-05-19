package com.campus_connect.campus_connect.Model;

public class responseMessage {

    public responseMessage(String responseMessageContent) {
        this.responseMessageContent = responseMessageContent;
    }

    public String getResponseMessageContent() {
        return responseMessageContent;
    }

    public void setResponseMessageContent(String responseMessageContent) {
        this.responseMessageContent = responseMessageContent;
    }

    private String responseMessageContent;
}
