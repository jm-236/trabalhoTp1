package com.joao.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Adotante extends Pessoa{

    private String id;
    private transient ArrayList<Adocao> animaisAdotados;
    private String endereco;
    private String cep;

    public Adotante(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String endereco) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.endereco = endereco;
        this.animaisAdotados = new ArrayList<Adocao>();
    }

    public Adotante() {
        this.animaisAdotados = new ArrayList<Adocao>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void addAnimalAdotado(Adocao adocao){
        animaisAdotados.add(adocao);
    }

    public ArrayList<Adocao> getAnimaisAdotados() {
        return this.animaisAdotados;
    }

    public void setAnimaisAdotados(ArrayList<Adocao> animaisAdotados) {
        this.animaisAdotados = animaisAdotados;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return super.toString() + "animaisAdotados=" + animaisAdotados + ", endereco=" + endereco + ", cep=" + cep + '}';
    }

    
}
