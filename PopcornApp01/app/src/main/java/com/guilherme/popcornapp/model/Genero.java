package com.guilherme.popcornapp.model;

import java.io.Serializable;
import java.util.List;

public class Genero implements Serializable {

    private int id;
    private String nome;
    private List<Filme> filmes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
