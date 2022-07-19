package com.cygeez;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String phoneNo;
    private String email;
    private ArrayList<Message> message;

    public Contact(String name, String phoneNo, String email, ArrayList<Message> message){
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.message = message;
    }

    public Contact (String name, String phoneNo, String email){
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.message = new ArrayList<>();
    }

    public void getDetails () {
        System.out.println("Name : " + name + "\nPhone No: " + phoneNo + "\n Email: " + email+"\nMessage : " + message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<Message> message) {
        this.message = message;
    }
}
