package com.joao.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Classe Funcionario que herda de Pessoa.
 * Representa um funcionário com ID e senha.
 */
public class Funcionario extends Pessoa {

    private String id;
    private String senha;

    /**
     * Construtor da classe Funcionario.
     *
     * @param cpf            CPF do funcionário.
     * @param dataNascimento Data de nascimento do funcionário.
     * @param email          Email do funcionário.
     * @param nome           Nome do funcionário.
     * @param telefone       Telefone do funcionário.
     * @param senha          Senha do funcionário.
     */
    public Funcionario(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String senha) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.senha = senha;
    }

    /**
     * Construtor vazio da classe Funcionario.
     */
    public Funcionario() {
    }

    /**
     * Obtém o ID do funcionário.
     *
     * @return ID do funcionário.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID do funcionário.
     *
     * @param id ID a ser definido.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém a senha do funcionário.
     *
     * @return Senha do funcionário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do funcionário se as duas senhas fornecidas forem iguais.
     *
     * @param senha1 Primeira senha fornecida.
     * @param senha2 Segunda senha fornecida.
     * @return true se as senhas forem iguais e a senha for definida, false caso contrário.
     */
    public boolean setSenha(String senha1, String senha2) {
        if (Objects.equals(senha1, senha2)) {
            this.senha = senha1;
            return true;
        }
        return false;
    }

    /**
     * Retorna a assinatura do funcionário.
     *
     * @return String representando a assinatura do funcionário.
     */
    public String assinatura() {
        return String.format("%s (%s)", super.getNome(), id);
    }
}