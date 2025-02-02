package com.sistemagerenciamentoanimais.model;

import java.util.ArrayList;
import java.util.Date;

public class Adotante extends Pessoa {

    private ArrayList<Adocao> animaisAdotados;
    private String endereco;

    public Adotante(String cpf, Date dataNascimento, String email, String nome, String telefone, String endereco) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.endereco = endereco;
    }

    public ArrayList<Adocao> getAnimaisAdotados() {
        return animaisAdotados;
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
}
