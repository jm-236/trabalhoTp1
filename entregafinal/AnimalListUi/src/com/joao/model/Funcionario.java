package com.joao.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Funcionario extends Pessoa{

    private String id;
    private String senha;

    public Funcionario(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String senha) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.senha = senha;
    }

    public Funcionario() {
        super(null, null, null, null, null);
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
