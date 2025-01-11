package com.sistemagerenciamentoanimais;

import java.util.Date;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String genero;
    private Date dataNascimento;
    private float peso;
    private String porte;
    private FichaMedica fichaMedica;
    private Adocao adocao;

    public Animal(Date dataNascimento, String especie, String genero, String nome, float peso, String porte, String raca) {
        this.dataNascimento = dataNascimento;
        this.especie = especie;
        this.genero = genero;
        this.nome = nome;
        this.peso = peso;
        this.porte = porte;
        this.raca = raca;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public FichaMedica getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }
}

