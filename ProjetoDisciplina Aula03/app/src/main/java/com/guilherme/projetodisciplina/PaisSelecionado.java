package com.guilherme.projetodisciplina;

import android.view.View;
import android.widget.AdapterView;

public class PaisSelecionado implements AdapterView.OnItemSelectedListener {
    private String continente;

    PaisSelecionado (String continente){
        this.continente = continente;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        this.continente = (String) parent.getItemAtPosition(position);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
}
