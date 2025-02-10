package com.joao.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa um Adotante.
 */
public class Adotante extends Pessoa {

    /**
     * ID do adotante.
     */
    private String id;

    /**
     * Lista de animais adotados pelo adotante.
     */
    private ArrayList<Adocao> animaisAdotados;

    /**
     * Endereço do adotante.
     */
    private String endereco;

    /**
     * CEP do adotante.
     */
    private String cep;

    /**
     * Construtor da classe Adotante.
     *
     * @param cpf CPF do adotante.
     * @param dataNascimento Data de nascimento do adotante.
     * @param email Email do adotante.
     * @param nome Nome do adotante.
     * @param telefone Telefone do adotante.
     * @param endereco Endereço do adotante.
     */
    public Adotante(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String endereco) {
        super(cpf, dataNascimento, email, nome, telefone);
        this.endereco = endereco;
        this.animaisAdotados = new ArrayList<Adocao>();
    }

    /**
     * Construtor vazio da classe Adotante.
     */
    public Adotante() {
        this.animaisAdotados = new ArrayList<Adocao>();
    }

    /**
     * Obtém o ID do adotante.
     *
     * @return ID do adotante.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID do adotante.
     *
     * @param id ID do adotante.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Adiciona um animal adotado à lista de animais adotados.
     *
     * @param adocao Adoção a ser adicionada.
     */
    public void addAnimalAdotado(Adocao adocao) {
        animaisAdotados.add(adocao);
    }

    /**
     * Obtém a lista de animais adotados.
     *
     * @return Lista de animais adotados.
     */
    public ArrayList<Adocao> getAnimaisAdotados() {
        return this.animaisAdotados;
    }

    /**
     * Define a lista de animais adotados.
     *
     * @param animaisAdotados Lista de animais adotados.
     */
    public void setAnimaisAdotados(ArrayList<Adocao> animaisAdotados) {
        this.animaisAdotados = animaisAdotados;
    }

    /**
     * Obtém o endereço do adotante.
     *
     * @return Endereço do adotante.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do adotante.
     *
     * @param endereco Endereço do adotante.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o CEP do adotante.
     *
     * @return CEP do adotante.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do adotante.
     *
     * @param cep CEP do adotante.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna uma representação em string do adotante.
     *
     * @return String representando o adotante.
     */
    @Override
    public String toString() {
        return super.toString() + "animaisAdotados=" + animaisAdotados + ", endereco=" + endereco + ", cep=" + cep + '}';
    }
}