package com.example.myapplication;

import com.example.myapplication.model.MedicineModel;

import java.util.ArrayList;

public class Info {

    public static ArrayList<MedicineModel> getMedicines() {
        ArrayList<MedicineModel> medicines = new ArrayList<>();
        medicines.add(new MedicineModel("M1", R.drawable.pic_chat, "uses1", "purpose1", "price1"));
        medicines.add(new MedicineModel("M2", R.drawable.pic_chat, "uses2", "purpose2", "price2"));
        medicines.add(new MedicineModel("M3", R.drawable.pic_chat, "uses3", "purpose3", "price3"));
        medicines.add(new MedicineModel("M4", R.drawable.pic_chat, "uses4", "purpose4", "price4"));
        medicines.add(new MedicineModel("M5", R.drawable.pic_chat, "uses5", "purpose5", "price5"));
        medicines.add(new MedicineModel("M6", R.drawable.pic_chat, "uses6", "purpose6", "price6"));
        medicines.add(new MedicineModel("M7", R.drawable.pic_chat, "uses7", "purpose7", "price7"));
        medicines.add(new MedicineModel("M8", R.drawable.pic_chat, "uses8", "purpose8", "price8"));
        medicines.add(new MedicineModel("M9", R.drawable.pic_chat, "uses9", "purpose9", "price9"));
        medicines.add(new MedicineModel("M10", R.drawable.pic_chat, "uses10", "purpose10", "price10"));
        return medicines;
    }
}
