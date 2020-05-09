package com.example.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityDataBindingLiveDataBinding;
import com.example.mvvm.utils.User;
import com.example.mvvm.viewmodel.DBLDViewModel;

public class DataBindingLiveDataActivity extends AppCompatActivity {

    private DBLDViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding_live_data);
        ActivityDataBindingLiveDataBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_data_binding_live_data);
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(this).get(DBLDViewModel.class);
        binding.setViewModel(viewModel);

        User user = new User("Santiago", "28");
        viewModel.setUser(user);
    }
}
