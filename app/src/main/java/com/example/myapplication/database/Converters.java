package com.example.myapplication.database;

import androidx.room.TypeConverter;

import com.example.myapplication.model.MessageModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {

    @TypeConverter
    public String convertToMessageString(List<MessageModel> messageModels){
        return new Gson().toJson(messageModels);
    }

    @TypeConverter
    public List<MessageModel> convertToMessageList(String stringList){
        Type listType = new TypeToken<List<MessageModel>>(){}.getType();
        return new Gson().fromJson(stringList,listType);
    }
}
