package com.example.consultants.week2_daily2.Model;

public class UserMessage {

    String message;
    String ID;
    static int counter;

    public UserMessage(String message, String ID) {
        this.message = message;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public UserMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
//        return "UserMessage{" +
//                "message='" + message + '\'' +
//                '}';
        return this.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
