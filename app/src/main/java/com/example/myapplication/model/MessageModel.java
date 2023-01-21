package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MessageModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int senderType;
    private String message;

    public MessageModel(int senderType, String message) {
        this.senderType = senderType;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderType() {
        return senderType;
    }

    public void setSenderType(int senderType) {
        this.senderType = senderType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
