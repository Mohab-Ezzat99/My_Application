package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.database.AppDB;
import com.example.myapplication.database.AppDao;
import com.example.myapplication.model.MessageModel;

import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Repository {
    private final AppDao appDao;

    public Repository(Application application) {
        this.appDao = AppDB.getInstance(application).appDao();
    }

    public void insertMessage(MessageModel product) {
        appDao.insertMessage(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<MessageModel>> getAllMessages() {
        return appDao.getAllMessages();
    }

    public void deleteAllMessages() {
        appDao.deleteAllMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
