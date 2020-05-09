package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm.ui.DataBindingActivity;
import com.example.mvvm.ui.DataBindingLiveDataActivity;
import com.example.mvvm.ui.LiveDataActivity;
import com.example.mvvm.ui.UserViewModelActivity;
import com.example.mvvm.ui.ViewModelActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_sum_view_model, btn_user_view_model, btn_live_data,
            btn_data_binding, btn_dbla_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sum_view_model = findViewById(R.id.btn_sum_view_model);
        btn_sum_view_model.setOnClickListener(this);
        btn_user_view_model = findViewById(R.id.btn_user_view_model);
        btn_user_view_model.setOnClickListener(this);
        btn_live_data = findViewById(R.id.btn_live_data);
        btn_live_data.setOnClickListener(this);
        btn_data_binding = findViewById(R.id.btn_data_binding);
        btn_data_binding.setOnClickListener(this);
        btn_dbla_binding = findViewById(R.id.btn_dbla_binding);
        btn_dbla_binding.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sum_view_model:
                startActivity(new Intent(getApplicationContext(), ViewModelActivity.class));
                break;
            case R.id.btn_user_view_model:
                startActivity(new Intent(getApplicationContext(), UserViewModelActivity.class));
                break;
            case R.id.btn_live_data:
               startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
                break;
            case R.id.btn_data_binding:
                startActivity(new Intent(getApplicationContext(), DataBindingActivity.class));
                break;
            case R.id.btn_dbla_binding:
                startActivity(new Intent(getApplicationContext(), DataBindingLiveDataActivity.class));
                break;
        }
    }

}
