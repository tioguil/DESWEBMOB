package com.guilherme.popcornapp.model;

import java.io.Serializable;
import java.util.Date;

public class Filme implements Serializable {

    private int id;
    private String titulo;
    private String descricao;
    private double popularidade;
    private Date dataLancamento;
    private String posterPath;
    private String diretor;
    private Genero genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(double popularidade) {
        this.popularidade = popularidade;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Filme(int id, String titulo, String descricao, double popularidade, Date dataLancamento, String posterPath, String diretor, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.dataLancamento = dataLancamento;
        this.posterPath = posterPath;
        this.diretor = diretor;
        this.genero = genero;
    }

    public Filme(){

    }

    @Override
    public String toString() {
        return "Filme: " + this.titulo + " Descrição: " +
                this.descricao + " Diretor: " + this.diretor;
    }
}
