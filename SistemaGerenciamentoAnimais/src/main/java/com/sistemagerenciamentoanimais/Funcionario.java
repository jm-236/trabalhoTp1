package com.sistemagerenciamentoanimais;

import java.util.Date;

public class Funcionario extends Pessoa{

    private int id;
    private String senha;

    public Funcionario(String cpf, Date dataNascimento, String email, String nome, String telefone, int id, String senha) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.id = id;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
