package com.joao.model;

import java.time.LocalDate;
import java.util.Date;

public class Veterinario extends Funcionario{

    private String crmv;
    
    public Veterinario(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String senha, String crmv) {
        super(cpf, dataNascimento, email, nome, telefone, senha);
        this.crmv = crmv;
    }

    public String getCrmv() {
        return crmv;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "crmv=" + crmv + '}';
    }
    
    
}
