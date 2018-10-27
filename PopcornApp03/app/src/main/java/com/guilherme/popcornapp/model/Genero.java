package com.guilherme.popcornapp.model;

import java.io.Serializable;
import java.util.List;

public class Genero implements Serializable {

    private int id;
    private String name;
    private List<Filme> filmes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Genero(int id, String nome) {
        this.id = id;
        this.name = nome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "-" +  name;
    }
}
