package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public Historico(Animal animal, FichaMedica ficha) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        //this.idEvento = ficha.getId();
    }
    
    
}
