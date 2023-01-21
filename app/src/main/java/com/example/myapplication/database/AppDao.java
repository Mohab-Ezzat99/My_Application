package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.MedicineModel;
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

    // Stock
    //============================================================================================//

    @Insert
    Completable insertCartMedicines(MedicineModel medicine);

    @Query("SELECT * FROM MedicineModel")
    LiveData<List<MedicineModel>> getAllCartMedicines();

    @Query("DELETE FROM MedicineModel")
    Completable deleteAllCartMedicines();

    @Delete
    Completable deleteMedicine(MedicineModel medicine);
}
