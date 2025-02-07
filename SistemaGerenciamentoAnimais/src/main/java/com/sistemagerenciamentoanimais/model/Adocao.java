package com.sistemagerenciamentoanimais.model;

import java.time.LocalDate;

public class Adocao {

    private LocalDate dataAdocao;
    private String termoResponsabilidade;
    private String observacoes;
    private Adotante adotante;
    private Animal animal;

    public Adocao(Adotante adotante, Animal animal, LocalDate dataAdocao, String observacoes, String termoResponsabilidade) {
        this.adotante = adotante;
        this.animal = animal;
        this.dataAdocao = dataAdocao;
        this.observacoes = observacoes;
        this.termoResponsabilidade = termoResponsabilidade;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getTermoResponsabilidade() {
        return termoResponsabilidade;
    }

    public void setTermoResponsabilidade(String termoResponsabilidade) {
        this.termoResponsabilidade = termoResponsabilidade;
    }
}
