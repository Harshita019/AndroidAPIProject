package com.example.myapplication;

public class dataModel {

    private String Message;
    private String Status;
    // Getter Methods
    public String getMessage() {
        return Message;
    }

    public String getStatus() {
        return Status;
    }
    // Setter Methods

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "dataModel{" +
                "Message='" + Message + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
