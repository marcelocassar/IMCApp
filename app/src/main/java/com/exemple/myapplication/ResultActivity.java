package com.exemple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView resultado;
    String strnome;
    Float fltAltura, fltPeso, fltResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        resultado = (TextView) findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        strnome = intent.getStringExtra("nome");
        fltAltura = Float.parseFloat(intent.getStringExtra("altura"));
        fltPeso = Float.parseFloat(intent.getStringExtra("peso"));
        fltResult = fltPeso/(fltAltura*fltAltura);
        String strResult = "Olá " + strnome + "!";
        strResult = strResult + "\n" + "IMC = " + fltResult.toString();



        if (fltResult < 17){
            strResult = strResult + "\n" + "IMC = " + fltResult.toString() +". Muito abaixo do normal";
        } else if(fltResult>30){
            strResult = strResult + "\n" + "IMC = " + fltResult.toString() +". Muito acima do normal";
        }

        resultado.setText(strResult);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}