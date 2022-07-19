package com.cygeez;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;
    public static void main(String ... args){
        contacts = new ArrayList<>();
        System.out.println("Welcome to Contacts and messages app");
        initialSelection();
    }
    private static void initialSelection(){
        System.out.println("Please Select one of the following "+
                "\n\t1. My Contacts List"+ "\n\t2. My Messages "+ "\n\t3. Exit");
        scanner = new Scanner(System.in);
        int selection =  scanner.nextInt();

        switch(selection) {
            case 1:
                myContacts();
                break;
            case 2:
                myMessages();
                break;
            default:
                break;
        }
    }
    private static void myContacts() {
        System.out.println("Please select one of the following: " +
                "\n\t1. Contact list" + "\n\t2. Add New Contact" +
                "\n\t3. Search" + "\n\t4. Delete Contact" + "\n\t5. Back");
        int selectionContact = scanner.nextInt();
        switch(selectionContact){
            case 1:
                contactList();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                initialSelection();
                break;
        }

    }
    private static void contactList() {
        for(Contact c : contacts){
            c.getDetails();
            System.out.println("******************");
        }
        initialSelection();
    }

    private static void addNewContact(){
        System.out.println("Please Enter the name ");
        String name = scanner.next();
        System.out.println("Please Enter the number ");
        String phoneNo = scanner.next();
        System.out.println("Please Enter the Email");
        String email  = scanner.next();

        if (name.equals("")||phoneNo.equals("")||email.equals("")){
            System.out.println("Please Enter all required values");
            addNewContact();
        }
        else {
            boolean doesExist = false;
            for (Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist=true;
                }
            }
            if(doesExist){
                System.out.println(name + " is already a contact");
                addNewContact();
            }
            else {
                Contact contact = new Contact(name, phoneNo, email );
                contacts.add(contact);
                System.out.println(name + " saved to contacts");
            }

        }
        initialSelection();
    }

    private static void searchContact(){
        System.out.println("Please Enter the contact Name");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please Enter a valid name");
            searchContact();
        }
        else {
            boolean doesExit = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExit = true;
                    c.getDetails();
                }
            }
            if(!doesExit){
                System.out.println("The contact doesn't exit");
            }
        }
        initialSelection();
    }

    private static void deleteContact(){
        System.out.println("Please Enter the name of the contact");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name correctly");
            deleteContact();
        }
        else {
            boolean doesExist = false;
            for (Contact c : contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist){
                System.out.println("There is no contact with this user name");
            }
        }
        initialSelection();
    }

    private static void myMessages(){
        System.out.println("Please, select one of the following \n" + "\n\t1. All Messages" +
                "\n\t2. Send Message" + "\n\t3. Go back");
        int messageSelect = scanner.nextInt();
        switch (messageSelect) {
            case 1:
                allMessages();
                break;
            case 2:
                sendMessage();
                break;
            default:
                initialSelection();
                break;

        }

    }

    private static void allMessages() {
        ArrayList<Message> allMessage = new ArrayList<>();
        for (Contact c: contacts){
            allMessage.addAll(c.getMessage());
        }
        if(allMessage.size()>0){
            for(Message m: allMessage){
                m.getDetails();
                System.out.println("********************");
            }
        }
        else {
            System.out.println("You don't have any messages");
        }
        initialSelection();
    }
    private static void sendMessage(){
        System.out.println("Enter the recipient");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please Enter valid value");
            sendMessage();
        }
        else{
            boolean doesExist = false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist =true;
                }
            }
            if(doesExist){
                System.out.println("Write Message");
                String text = scanner.next();
                if(text.equals("")){
                    System.out.println("Please Enter a valid message");
                    sendMessage();
                }
                else{
                    id ++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c:contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessage();
                            newMessages.add(newMessage);
                            Contact currentContact = c;
                            currentContact.setMessage(newMessages);
                            contacts.remove(c);
                            contacts.add(currentContact);
                        }
                    }
                }
            }
            else{
                System.out.println("There is no contact with specified name");
            }
        }
        initialSelection();
    }
}
