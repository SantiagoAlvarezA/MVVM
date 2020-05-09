package com.example.mvvm.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.mvvm.utils.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {

    private List<User> users;

    public UserViewModel() {
        this.users = new ArrayList<>();
    }


    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
