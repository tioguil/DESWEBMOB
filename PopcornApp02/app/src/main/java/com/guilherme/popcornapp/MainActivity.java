package com.guilherme.popcornapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHAVE_GENERO = "textGenero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listaFilme(View v){
        Intent intent = new Intent(MainActivity.this, List_filme.class);
        startActivity(intent);
    }

}
