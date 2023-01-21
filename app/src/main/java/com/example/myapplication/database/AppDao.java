package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.myapplication.model.MessageModel;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;

@Dao
public interface AppDao {

    @Insert
    Completable insertMessage(MessageModel device);

    @Query("SELECT * FROM MessageModel")
    LiveData<List<MessageModel>> getAllMessages();

    @Query("DELETE FROM MessageModel")
    Completable deleteAllMessages();
}
