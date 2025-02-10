/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.model;

/**
 * Classe que representa um Termo de adoção.
 * Contém informações sobre a adoção de um animal.
 *
 * @author joao
 */
public class Termo {

    private boolean temOutrosAnimais;
    private String outrosAnimais;
    private boolean podeLevarAoVet;
    private String ambiente;
    private String localDuranteViagem;
    private String acaoSeFizerMudanca;
    private boolean consciencia;
    private boolean jaEntregouParaAdocao;

    /**
     * Construtor completo da classe Termo.
     *
     * @param temOutrosAnimais Indica se o adotante tem outros animais.
     * @param outrosAnimais Descrição dos outros animais que o adotante possui.
     * @param podeLevarAoVet Indica se o adotante pode levar o animal ao veterinário.
     * @param ambiente Descrição do ambiente onde o animal ficará.
     * @param localDuranteViagem Local onde o animal ficará durante viagens.
     * @param acaoSeFizerMudanca Ação a ser tomada se o adotante mudar de residência.
     * @param consciencia Indica se o adotante tem consciência das responsabilidades.
     * @param jaEntregouParaAdocao Indica se o adotante já entregou um animal para adoção anteriormente.
     */
    public Termo(boolean temOutrosAnimais, String outrosAnimais, boolean podeLevarAoVet, String ambiente, String localDuranteViagem, String acaoSeFizerMudanca, boolean consciencia, boolean jaEntregouParaAdocao) {
        this.temOutrosAnimais = temOutrosAnimais;
        this.outrosAnimais = outrosAnimais;
        this.podeLevarAoVet = podeLevarAoVet;
        this.ambiente = ambiente;
        this.localDuranteViagem = localDuranteViagem;
        this.acaoSeFizerMudanca = acaoSeFizerMudanca;
        this.consciencia = consciencia;
        this.jaEntregouParaAdocao = jaEntregouParaAdocao;
    }

    /**
     * Construtor vazio da classe Termo.
     */
    public Termo() {
    }

    /**
     * Verifica se o adotante tem outros animais.
     *
     * @return true se o adotante tem outros animais, false caso contrário.
     */
    public boolean isTemOutrosAnimais() {
        return temOutrosAnimais;
    }

    /**
     * Define se o adotante tem outros animais.
     *
     * @param temOutrosAnimais true se o adotante tem outros animais, false caso contrário.
     */
    public void setTemOutrosAnimais(boolean temOutrosAnimais) {
        this.temOutrosAnimais = temOutrosAnimais;
    }

    /**
     * Obtém a descrição dos outros animais que o adotante possui.
     *
     * @return Descrição dos outros animais.
     */
    public String getOutrosAnimais() {
        return outrosAnimais;
    }

    /**
     * Define a descrição dos outros animais que o adotante possui.
     *
     * @param outrosAnimais Descrição dos outros animais.
     */
    public void setOutrosAnimais(String outrosAnimais) {
        this.outrosAnimais = outrosAnimais;
    }

    /**
     * Verifica se o adotante pode levar o animal ao veterinário.
     *
     * @return true se o adotante pode levar o animal ao veterinário, false caso contrário.
     */
    public boolean isPodeLevarAoVet() {
        return podeLevarAoVet;
    }

    /**
     * Define se o adotante pode levar o animal ao veterinário.
     *
     * @param podeLevarAoVet true se o adotante pode levar o animal ao veterinário, false caso contrário.
     */
    public void setPodeLevarAoVet(boolean podeLevarAoVet) {
        this.podeLevarAoVet = podeLevarAoVet;
    }

    /**
     * Obtém a descrição do ambiente onde o animal ficará.
     *
     * @return Descrição do ambiente.
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * Define a descrição do ambiente onde o animal ficará.
     *
     * @param ambiente Descrição do ambiente.
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * Obtém o local onde o animal ficará durante viagens.
     *
     * @return Local durante viagens.
     */
    public String getLocalDuranteViagem() {
        return localDuranteViagem;
    }

    /**
     * Define o local onde o animal ficará durante viagens.
     *
     * @param localDuranteViagem Local durante viagens.
     */
    public void setLocalDuranteViagem(String localDuranteViagem) {
        this.localDuranteViagem = localDuranteViagem;
    }

    /**
     * Obtém a ação a ser tomada se o adotante mudar de residência.
     *
     * @return Ação a ser tomada.
     */
    public String getAcaoSeFizerMudanca() {
        return acaoSeFizerMudanca;
    }

    /**
     * Define a ação a ser tomada se o adotante mudar de residência.
     *
     * @param acaoSeFizerMudanca Ação a ser tomada.
     */
    public void setAcaoSeFizerMudanca(String acaoSeFizerMudanca) {
        this.acaoSeFizerMudanca = acaoSeFizerMudanca;
    }

    /**
     * Verifica se o adotante tem consciência das responsabilidades.
     *
     * @return true se o adotante tem consciência, false caso contrário.
     */
    public boolean isConsciencia() {
        return consciencia;
    }

    /**
     * Define se o adotante tem consciência das responsabilidades.
     *
     * @param consciencia true se o adotante tem consciência, false caso contrário.
     */
    public void setConsciencia(boolean consciencia) {
        this.consciencia = consciencia;
    }

    /**
     * Verifica se o adotante já entregou um animal para adoção anteriormente.
     *
     * @return true se o adotante já entregou um animal para adoção, false caso contrário.
     */
    public boolean isJaEntregouParaAdocao() {
        return jaEntregouParaAdocao;
    }

    /**
     * Define se o adotante já entregou um animal para adoção anteriormente.
     *
     * @param jaEntregouParaAdocao true se o adotante já entregou um animal para adoção, false caso contrário.
     */
    public void setJaEntregouParaAdocao(boolean jaEntregouParaAdocao) {
        this.jaEntregouParaAdocao = jaEntregouParaAdocao;
    }

    /**
     * Retorna uma representação em string do objeto Termo.
     *
     * @return String representando o objeto Termo.
     */
    @Override
    public String toString() {
        return "Termo{" + "temOutrosAnimais=" + temOutrosAnimais + ", outrosAnimais=" + outrosAnimais + ", podeLevarAoVet=" + podeLevarAoVet + ", ambiente=" + ambiente + ", localDuranteViagem=" + localDuranteViagem + ", acaoSeFizerMudanca=" + acaoSeFizerMudanca + ", consciencia=" + consciencia + ", jaEntregouParaAdocao=" + jaEntregouParaAdocao + '}';
    }
}