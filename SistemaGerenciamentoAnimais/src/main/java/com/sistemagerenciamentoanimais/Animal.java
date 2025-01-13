package com.sistemagerenciamentoanimais;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String genero;
    private LocalDate dataNascimento;
    private float peso;
    private String porte;
    private FichaMedica fichaMedica;
    private Adocao adocao;
    private int id;
    private int idade;
    private String local;

    public Animal(Adocao adocao, LocalDate dataNascimento, String especie, FichaMedica fichaMedica, String genero, int id, int idade, String local, String nome, float peso, String porte, String raca) {
        this.adocao = adocao;
        this.dataNascimento = dataNascimento;
        this.especie = especie;
        this.fichaMedica = fichaMedica;
        this.genero = genero;
        this.id = id;
        this.idade = idade;
        this.local = local;
        this.nome = nome;
        this.peso = peso;
        this.porte = porte;
        this.raca = raca;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public int calcularIdade() {
        return Period.between(this.getDataNascimento(), LocalDate.now()).getYears();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

