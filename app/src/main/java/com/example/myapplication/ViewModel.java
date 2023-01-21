package com.example.myapplication;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.myapplication.model.MessageModel;
import java.util.List;

public class ViewModel extends AndroidViewModel {

    private final Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void insertMessage(MessageModel product) {
        repository.insertMessage(product);
    }

    public LiveData<List<MessageModel>> getAllMessages() {
        return repository.getAllMessages();
    }

    public void deleteAllMessages() {
        repository.deleteAllMessages();
    }

}
