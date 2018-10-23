package com.guilherme.popcornapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.guilherme.popcornapp.model.Filme;
import com.guilherme.popcornapp.model.Genero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class List_filme extends AppCompatActivity {

    private ListView listView;
    private List<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filme);

        listView = findViewById(R.id.listFilmeListView);
        filmes = new ArrayList<>();
        filmes = listFilme();

        ArrayAdapter<Filme> adapter = new ArrayAdapter<Filme>(this,
                android.R.layout.simple_list_item_1, filmes);
        listView.setAdapter(adapter);

        ListView.OnItemClickListener itemClickListener =
                (parent, view, position, id) -> {
                    Filme filme = filmes.get(position);
//                    Toast.makeText(ListaChamadosActivity.this, oCaraQueFoiTocado, Toast.LENGTH_SHORT).show();

                    Intent detalhesIntent = new Intent(this, Detail_filme.class);
                    detalhesIntent.putExtra("filmeSelecionado", filme);
                    startActivity(detalhesIntent);
                };

        listView.setOnItemClickListener(itemClickListener);
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
