package com.exemple.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText nome, altura, peso;
    Button botalOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nome = (EditText) findViewById(R.id.editTextTextName);
        nome = (EditText) findViewById(R.id.editTextTextAltura);
        nome = (EditText) findViewById(R.id.editTextTextPeso);
        botalOk = (Button) findViewById(R.id.buttonOk);

        botalOk.setOnClickListener(v -> mostrarTelaResultado());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void mostrarTelaResultado(){

        if(TextUtils.isEmpty(nome.getText().toString())){
            nome.setError("Campo obrigatório");
            return;
        }

        if(TextUtils.isEmpty(altura.getText().toString())){
            altura.setError("Campo obrigatório");
            return;
        }

        if(TextUtils.isEmpty(peso.getText().toString())){
            peso.setError("Campo obrigatório");
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("nome",nome.getText().toString());
        intent.putExtra("altura",altura.getText().toString());
        intent.putExtra("peso",peso.getText().toString());
        startActivity(intent);
    }

}