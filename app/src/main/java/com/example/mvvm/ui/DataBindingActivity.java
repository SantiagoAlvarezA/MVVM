package com.example.mvvm.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityDataBindingBinding;
import com.example.mvvm.utils.User;

public class DataBindingActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        ActivityDataBindingBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_data_binding);
        user = new User("Santiago","27");
        binding.setUser(user);

    }

}
