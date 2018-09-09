package com.guilherme.projetodisciplina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String continente = "Todos";
    public static final String KEY_CONTINENTE = "txtContinente";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.continentes);
        spinner.setOnItemSelectedListener(paisSelecionado);
    }

    PaisSelecionado paisSelecionado = new PaisSelecionado(continente);

    public void listarPaises(View view){
        Intent intent = new Intent(this,ListaPaises.class);
        intent.putExtra(KEY_CONTINENTE,continente);
        startActivity(intent);
    }

}
