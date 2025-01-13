package com.sistemagerenciamentoanimais;

import java.time.LocalDate;
import java.util.ArrayList;

public class Historico {

    private int idHistorico;
    private LocalDate dataGeracao;
    private ArrayList<Animal> animaisCadastrados;
    private ArrayList<Adocao> adocoesRealizadas;
    private ArrayList<FichaMedica> fichasMedicas;

    public Historico(int idHistorico) {
        this.idHistorico = idHistorico;
        this.dataGeracao = LocalDate.now();
        this.animaisCadastrados = new ArrayList<Animal>();
        this.adocoesRealizadas = new ArrayList<Adocao>();
        this.fichasMedicas = new ArrayList<FichaMedica>();
    }

    public ArrayList<Adocao> getAdocoesRealizadas() {
        return adocoesRealizadas;
    }

    public void setAdocoesRealizadas(ArrayList<Adocao> adocoesRealizadas) {
        this.adocoesRealizadas = adocoesRealizadas;
    }

    public ArrayList<Animal> getAnimaisCadastrados() {
        return animaisCadastrados;
    }

    public void setAnimaisCadastrados(ArrayList<Animal> animaisCadastrados) {
        this.animaisCadastrados = animaisCadastrados;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public ArrayList<FichaMedica> getFichasMedicas() {
        return fichasMedicas;
    }

    public void setFichasMedicas(ArrayList<FichaMedica> fichasMedicas) {
        this.fichasMedicas = fichasMedicas;
    }

    public int getIdHistorico() {
        return idHistorico;
    }
}
