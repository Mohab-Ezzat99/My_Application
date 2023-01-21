package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MedicineModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int img;
    private String uses;
    private String purpose;
    private String price;

    public MedicineModel(int id, String name, int img, String uses, String purpose, String price) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
