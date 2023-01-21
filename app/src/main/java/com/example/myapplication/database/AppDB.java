package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.myapplication.model.MessageModel;
import com.example.myapplication.model.ProductModel;

@Database(
        entities = {MessageModel.class,ProductModel.class},
        version = 1,
        exportSchema = false
)
@TypeConverters(Converters.class)
public abstract class AppDB extends RoomDatabase {
    private static AppDB instance;

    public abstract AppDao appDao();

    public static synchronized AppDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDB.class, "App_DB")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
