package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.utils.User;

import java.util.ArrayList;
import java.util.List;

public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<List<User>> listMutableLiveData;
    private List<User> users;

    public LiveData<List<User>> getUserList() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            users = new ArrayList<>();
        }
        return listMutableLiveData;
    }

    public void addUser(User user) {
        users.add(user);
        listMutableLiveData.setValue(users);//thread principal
//        listMutableLiveData.postValue(users);//thread background
    }
}
