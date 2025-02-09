package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Historico {
    private String idAnimal;
    private String idEvento;
    private String nomeAnimal;
    private String evento; // Enum para tipos de dados
    private LocalDateTime dataHora;

    public Historico(Animal animal, boolean novo) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        if(novo){
            this.evento = "Novo Pet";
            this.idEvento = animal.getAnimalID();
        }
        else{
            this.evento = "Exclusão de Pet";
        }
    }
    public Historico(Animal animal, boolean novo, boolean edicao) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        if(edicao)
            this.evento = "Edição de Pet";
    }
    
    public Historico(Animal animal, FichaMedica ficha) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        this.idEvento = ficha.getFichaId();
        this.evento = "Ficha Médica";
    }
    
    public Historico(Animal animal, Adocao adocao) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        this.evento = "Adoção";
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getEvento() {
        return evento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    public LocalTime getHora() {
        return dataHora.toLocalTime();
    }
    
    public LocalDate getData(){
        return dataHora.toLocalDate();
    }

    @Override
    public String toString() {
        return dataHora.toLocalDate() + " - " + dataHora.toLocalTime().format(DateTimeFormatter.ISO_DATE) + " :  { Nome do Animal = " + nomeAnimal + " , Evento = " + evento + ", Id do Animal = " + idAnimal + " , Id do Evento = " + idEvento + "}\n";
    }
    
}
