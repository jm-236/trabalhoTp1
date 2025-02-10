package com.joao.model;

import com.joao.interfaces.validaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Adocao implements validaData {

    private LocalDate dataAdocao;
    private Termo termoResponsabilidade;
    private Adotante adotante;
    private transient Animal animal;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Adocao(LocalDate dataAdocao, Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.dataAdocao = dataAdocao;
        this.termoResponsabilidade = termoResponsabilidade;
        this.adotante = adotante;
        this.animal = animal;
    }

    public Adocao(Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.termoResponsabilidade = termoResponsabilidade;
        this.adotante = adotante;
        this.animal = animal;
    }

    public Adocao() {
    }
    
    public String validarData(String dataAdocaoStr) {
        // Define o formato esperado da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Converte a String para LocalDate
            LocalDate dataAdocao = LocalDate.parse(dataAdocaoStr, formatter);

            // Obtém a data atual
            LocalDate dataAtual = LocalDate.now();

            // Verifica se a data de nascimento é anterior à data atual
            if (dataAdocao.isAfter(dataAtual)) {
                System.out.println();
                return "Data de nascimento no futuro.";
            }

            // Se passou por todas as verificações, a data é válida
            return "true";

        } catch (DateTimeParseException e) {
            
            return "Formato de data inválido. Use o formato dd/MM/yyyy.";
        }
    }
    
    public boolean adocaoNaoExiste() {
        return this.adotante == null && this.dataAdocao == null && 
                this.termoResponsabilidade == null;
    }
    
    public LocalDate getDataAdocao() {
        return dataAdocao;
    }
    
    public String getDataAdocao(boolean string) {
        return dataAdocao.format(DATE_FORMATTER);
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public Termo getTermoResponsabilidade() {
        return termoResponsabilidade;
    }

    public void setTermoResponsabilidade(Termo termoResponsabilidade) {
        this.termoResponsabilidade = termoResponsabilidade;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Adocao{" + "dataAdocao=" + dataAdocao + ", termoResponsabilidade=" + termoResponsabilidade + ", adotante=" + adotante.getNome() + ", animal=" + animal.getAnimalNome() + '}';
    }
    
    

}
