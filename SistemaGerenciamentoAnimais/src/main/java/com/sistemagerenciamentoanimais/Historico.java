package com.sistemagerenciamentoanimais;

import java.time.LocalDate;
import java.util.ArrayList;

public class Historico {

    private int idRelatorio;
    private LocalDate dataGeracao;
    private ArrayList<Animal> animaisCadastrados;
    private ArrayList<Adocao> adocoesRealizadas;
    private ArrayList<FichaMedica> fichasMedicas;
}
