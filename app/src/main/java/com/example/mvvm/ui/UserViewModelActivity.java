package com.example.mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.utils.User;
import com.example.mvvm.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModelActivity extends AppCompatActivity {

    private Button btn_guardar, btn_ver;
    private TextView tv_user, tv_user_view_model;
    private EditText edt_nombre, edt_edad;

    private List<User> users;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_model);
        setUpView();
    }

    private void setUpView() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        users = new ArrayList<>();
        tv_user = findViewById(R.id.tv_user);
        tv_user_view_model = findViewById(R.id.tv_user_view_model);
        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);

        btn_guardar = findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setNombre(edt_nombre.getText().toString());
                user.setEdad(edt_edad.getText().toString());
                users.add(user);
                userViewModel.addUser(user);

            }
        });
        btn_ver = findViewById(R.id.btn_ver);
        btn_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                for (User user : users) {
                    text += user.getNombre() + " " + user.getEdad() + "\n";
                }
                tv_user.setText(text);

                text = "";
                for (User user : userViewModel.getUsers()) {
                    text += user.getNombre() + " " + user.getEdad() + "\n";
                }
                tv_user_view_model.setText(text);
            }
        });

    }
}
