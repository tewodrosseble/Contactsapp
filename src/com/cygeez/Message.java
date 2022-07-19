package com.cygeez;

public class Message {
    private String message;
    private String recipient;
    private int id;

    public Message(String message, String recipient, int id) {
        this.message = message;
        this.recipient = recipient;
        this.id = id;
    }
    public void getDetails (){
        System.out.println("Contact : " + recipient+ "\n Message : " + message + "\n id: " + id);
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setId(int id) {
        this.id = id;
    }
}
