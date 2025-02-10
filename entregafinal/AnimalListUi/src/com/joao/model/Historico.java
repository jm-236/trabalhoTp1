package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Classe que representa o histórico de eventos ocorridos no sistema.
 */
public class Historico {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String idAnimal;
    private String idEvento;
    private String nomeAnimal;
    private String evento; // Enum para tipos de dados
    private LocalDateTime dataHora;

    /**
     * Construtor da classe Historico para um novo animal.
     *
     * @param animal O objeto Animal relacionado ao histórico.
     * @param novo Indica se o animal é novo.
     */
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

    /**
     * Construtor da classe Historico para edição de um animal.
     *
     * @param animal O objeto Animal relacionado ao histórico.
     * @param novo Indica se o animal é novo.
     * @param edicao Indica se o animal está sendo editado.
     */
    public Historico(Animal animal, boolean novo, boolean edicao) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        if(edicao)
            this.evento = "Edição de Pet";
    }

    /**
     * Construtor da classe Historico para uma ficha médica.
     *
     * @param animal O objeto Animal relacionado ao histórico.
     * @param ficha O objeto FichaMedica relacionado ao histórico.
     */
    public Historico(Animal animal, FichaMedica ficha) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        this.idEvento = ficha.getFichaId();
        this.evento = "Ficha Médica";
    }

    /**
     * Construtor da classe Historico para edição de uma ficha médica.
     *
     * @param animal O objeto Animal relacionado ao histórico.
     * @param ficha O objeto FichaMedica relacionado ao histórico.
     * @param edicao Indica se a ficha médica está sendo editada.
     */
    public Historico(Animal animal, FichaMedica ficha, boolean edicao) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        this.idEvento = ficha.getFichaId();
        this.evento = "Ficha Médica (edição)";
    }

    /**
     * Construtor da classe Historico para adoção de um animal.
     *
     * @param animal O objeto Animal relacionado ao histórico.
     * @param adocao O objeto Adocao relacionado ao histórico.
     * @param edicao Indica se a adoção está sendo editada.
     * @param exclusao Indica se a adoção está sendo excluída.
     */
    public Historico(Animal animal, Adocao adocao, boolean edicao, boolean exclusao) {
        this.idAnimal = animal.getAnimalID();
        this.nomeAnimal = animal.getAnimalNome();
        this.dataHora = LocalDateTime.now();
        if (edicao){
            this.evento = "Adoção (alteração)";
        }
        else if (exclusao){
            this.evento = "Adoção (exclusão)";
        }
        else {
            this.evento = "Adoção (cadastro)";
        }
    }

    /**
     * Obtém o ID do animal.
     *
     * @return ID do animal.
     */
    public String getIdAnimal() {
        return idAnimal;
    }

    /**
     * Obtém o ID do evento.
     *
     * @return ID do evento.
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * Obtém o nome do animal.
     *
     * @return Nome do animal.
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    /**
     * Obtém o tipo de evento.
     *
     * @return Tipo de evento.
     */
    public String getEvento() {
        return evento;
    }

    /**
     * Obtém a data e hora do evento.
     *
     * @return Data e hora do evento.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Obtém a hora do evento.
     *
     * @return Hora do evento.
     */
    public LocalTime getHora() {
        return dataHora.toLocalTime();
    }

    /**
     * Obtém a data do evento.
     *
     * @return Data do evento.
     */
    public LocalDate getData(){
        return dataHora.toLocalDate();
    }

    /**
     * Retorna uma representação em string do objeto Historico.
     *
     * @return String representando o objeto Historico.
     */
    @Override
    public String toString() {
        return dataHora.toLocalDate().format(DATE_FORMATTER) + " - " + dataHora.toLocalTime().format(TIME_FORMATTER) + " :  { Nome do Animal = " + nomeAnimal + " , Evento = " + evento + ", Id do Animal = " + idAnimal + " , Id do Evento = " + idEvento + "}\n";
    }
}