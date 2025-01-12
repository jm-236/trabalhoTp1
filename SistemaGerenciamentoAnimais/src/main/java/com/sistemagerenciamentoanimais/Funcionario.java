package com.sistemagerenciamentoanimais;

import java.util.Date;
import java.util.Objects;

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

    public boolean setSenha(String senha1, String senha2) {
        if (Objects.equals(senha1, senha2)){
            this.senha = senha1;
            return true;
        }
        return false;
    }
}
