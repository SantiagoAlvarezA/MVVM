package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.utils.User;

import java.util.Objects;

public class DBLDViewModel extends ViewModel {

    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> visible;
    private MutableLiveData<Float> size;

    public DBLDViewModel() {
        user = new MutableLiveData<>();
        visible = new MutableLiveData<>();
        visible.setValue(true);

        size = new MutableLiveData<>();
        size.setValue(12f);
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public void updateUser() {
        User user = new User("Santiago", "27");
        this.user.setValue(user);
    }

    public MutableLiveData<Boolean> getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible.setValue(visible);
    }

    public void changeVisibility() {
        if (Objects.requireNonNull(visible.getValue())) {
            this.visible.setValue(false);
        } else {
            this.visible.setValue(true);
        }
        size.setValue(size.getValue().floatValue() + 5f);
    }

    public LiveData<Float> getSize() {
        return size;
    }


}
