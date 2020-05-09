package com.example.mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.utils.User;
import com.example.mvvm.viewmodel.LiveDataViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private TextView tvLiveData;
    private int numero = 0;
    private LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        setUpView();
    }

    private void setUpView() {
        liveDataViewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);
        btnSave = findViewById(R.id.btnSave);
        tvLiveData = findViewById(R.id.tvLiveData);
        btnSave.setOnClickListener(this);

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                String text = "";
                for (User user : users) {
                    text += user.toString() + "\n";
                }
                tvLiveData.setText(text);
            }
        };

        liveDataViewModel.getUserList().observe(this, listObserver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                if (numero == 0) {
                    User user = new User();
                    user.setNombre("Santiago");
                    user.setEdad("27");
                    liveDataViewModel.addUser(user);
                }
                if (numero == 1) {
                    User user = new User();
                    user.setNombre("Santiago 1");
                    user.setEdad("28");
                    liveDataViewModel.addUser(user);
                }
                if (numero == 2) {
                    User user = new User();
                    user.setNombre("Santiago 2");
                    user.setEdad("29");
                    liveDataViewModel.addUser(user);
                }
                numero++;
                if (numero > 2) numero = 0;
                break;
        }
    }
}
