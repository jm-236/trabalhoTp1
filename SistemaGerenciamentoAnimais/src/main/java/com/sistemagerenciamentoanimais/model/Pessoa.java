package com.sistemagerenciamentoanimais.model;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date dataNascimento;

    public Pessoa(String cpf, Date dataNascimento, String email, String nome, String telefone) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public boolean validaCpf (String cpf) {

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(validaCpf(cpf)) {
            this.cpf = cpf;
        }
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
