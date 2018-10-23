package com.guilherme.popcornapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.guilherme.popcornapp.model.Filme;
import com.guilherme.popcornapp.model.Genero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class List_filme extends AppCompatActivity {

    public static final String FILME = "filme";
    List<Filme> filmesList;
    private FilmeItemAdapter adapter;
    private ListView filmeListView;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filme);

        atividade = this;
        Intent intent = getIntent();
        String genero = intent.getStringExtra(MainActivity.CHAVE_GENERO);
        filmesList = listFilme();
        filmeListView = findViewById(R.id.listFilmeListView);
        System.out.println(filmesList);
        adapter = new FilmeItemAdapter(this,filmesList);
        filmeListView.setAdapter(adapter);

        filmeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                Intent intent = new Intent(atividade,Detail_filme.class);
                intent.putExtra(FILME,filmesList.get(position));
                startActivity(intent);
            }
        });
    }


    public List<Filme> listFilme(){
        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme(0,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Terror")));
        filmes.add(new Filme(1,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Ação")));
        filmes.add(new Filme(2,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Ficção")));
        filmes.add(new Filme(3,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Suspense")));
        filmes.add(new Filme(4,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Comédia")));
        filmes.add(new Filme(5,"Todos contra todos", "bla bla bla bla bla", 22.5, new Date(),"Nem tem", "Jorge Santos", new Genero(1, "Drama")));
        return filmes;
    }
}
