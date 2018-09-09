package com.guilherme.projetodisciplina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.guilherme.projetodisciplina.model.Pais;


/**
   Guilherme Brito dos Santos - RA 81617569
 */

public class DetalhePais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        TextView txtPais = (TextView)findViewById(R.id.txtPais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(ListaPaises.PAIS);
        txtPais.setText(pais.toString());
    }
}
