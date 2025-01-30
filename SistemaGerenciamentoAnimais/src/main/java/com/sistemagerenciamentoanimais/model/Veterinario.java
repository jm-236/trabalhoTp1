package com.sistemagerenciamentoanimais.model;

import java.util.Date;

public class Veterinario extends Funcionario {

    private int crmv;

    public Veterinario(String cpf, Date dataNascimento, String email, String nome, String telefone, int id, String senha, int crmv) {
        super(cpf, dataNascimento, email, nome, telefone, id, senha);
        this.crmv = crmv;
    }

    public int getCrmv() {
        return crmv;
    }
}
