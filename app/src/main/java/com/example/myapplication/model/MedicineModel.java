package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class MedicineModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int img;
    private String uses;
    private String purpose;
    private int price;

    public MedicineModel(String name, int img, String uses, String purpose, int price) {
        this.name = name;
        this.img = img;
        this.uses = uses;
        this.purpose = purpose;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
