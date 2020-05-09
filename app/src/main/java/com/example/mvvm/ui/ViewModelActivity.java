package com.example.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.Sumar;
import com.example.mvvm.viewmodel.SumarViewModel;

public class ViewModelActivity extends AppCompatActivity {

    private TextView tv_sumar, tv_sumar_VM;
    private Button btn_sumar;
    private int resultado;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        setUpView();
    }

    private void setUpView() {
        sumarViewModel = new ViewModelProvider(this).get(SumarViewModel.class);
        tv_sumar = findViewById(R.id.tv_sumar);
        tv_sumar_VM = findViewById(R.id.tv_sumar_VM);
        btn_sumar = findViewById(R.id.btn_sumar);
        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado = Sumar.sumar(resultado);
                tv_sumar.setText("" + resultado);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tv_sumar_VM.setText("" + sumarViewModel.getResultado());
            }
        });
    }

}
