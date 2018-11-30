package carrentalsystem;

import java.util.Date;

public class Message {
    private int MessageID;
    private String MessageSubject;
    private int FromUser;
    private int ToUser;

    public Message() {
        this.MessageID = 0;
        this.MessageSubject = "";
        this.FromUser = 0;
        this.ToUser = 0;
    }

    public void setMessageID(int MessageID) {
        this.MessageID = MessageID;
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageSubject(String MessageSubject) {
        this.MessageSubject = MessageSubject;
    }

    public String getMessageSubject() {
        return MessageSubject;
    }

    public void setFromUser(int FromUser) {
        this.FromUser = FromUser;
    }

    public int getFromUser() {
        return FromUser;
    }

    public void setToUser(int ToUser) {
        this.ToUser = ToUser;
    }

    public int getToUser() {
        return ToUser;
    }
}
