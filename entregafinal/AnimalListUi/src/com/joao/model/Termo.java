/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.model;

/**
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

    public Termo() {
    }

    public boolean isTemOutrosAnimais() {
        return temOutrosAnimais;
    }

    public void setTemOutrosAnimais(boolean temOutrosAnimais) {
        this.temOutrosAnimais = temOutrosAnimais;
    }

    public String getOutrosAnimais() {
        return outrosAnimais;
    }

    public void setOutrosAnimais(String outrosAnimais) {
        this.outrosAnimais = outrosAnimais;
    }

    public boolean isPodeLevarAoVet() {
        return podeLevarAoVet;
    }

    public void setPodeLevarAoVet(boolean podeLevarAoVet) {
        this.podeLevarAoVet = podeLevarAoVet;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getLocalDuranteViagem() {
        return localDuranteViagem;
    }

    public void setLocalDuranteViagem(String localDuranteViagem) {
        this.localDuranteViagem = localDuranteViagem;
    }

    public String getAcaoSeFizerMudanca() {
        return acaoSeFizerMudanca;
    }

    public void setAcaoSeFizerMudanca(String acaoSeFizerMudanca) {
        this.acaoSeFizerMudanca = acaoSeFizerMudanca;
    }

    public boolean isConsciencia() {
        return consciencia;
    }

    public void setConsciencia(boolean consciencia) {
        this.consciencia = consciencia;
    }

    public boolean isJaEntregouParaAdocao() {
        return jaEntregouParaAdocao;
    }

    public void setJaEntregouParaAdocao(boolean jaEntregouParaAdocao) {
        this.jaEntregouParaAdocao = jaEntregouParaAdocao;
    }

    @Override
    public String toString() {
        return "Termo{" + "temOutrosAnimais=" + temOutrosAnimais + ", outrosAnimais=" + outrosAnimais + ", podeLevarAoVet=" + podeLevarAoVet + ", ambiente=" + ambiente + ", localDuranteViagem=" + localDuranteViagem + ", acaoSeFizerMudanca=" + acaoSeFizerMudanca + ", consciencia=" + consciencia + ", jaEntregouParaAdocao=" + jaEntregouParaAdocao + '}';
    }
    
    
    
}
