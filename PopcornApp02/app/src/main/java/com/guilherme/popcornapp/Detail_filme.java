package com.guilherme.popcornapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guilherme.popcornapp.model.Filme;

public class Detail_filme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);

        Intent intent = getIntent();
        Filme oCaraQueFoiTocado = (Filme) intent.getSerializableExtra("filmeSelecionado");

    }
}
