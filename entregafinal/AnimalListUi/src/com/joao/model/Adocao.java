package com.joao.model;

import com.joao.interfaces.validaData;
import com.joao.jsonManager.AdotanteJsonHandler;
import com.joao.jsonManager.AnimalJsonHandler;
import com.joao.model.Adotante;
import com.joao.model.Animal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Adocao implements validaData {

    private LocalDate dataAdocao;
    private Termo termoResponsabilidade;
    private String cpfAdotante;
    private String nomeAdotante;
    private String idAnimal;
    private String nomeAnimal;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Adocao(LocalDate dataAdocao, Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.dataAdocao = dataAdocao;
        this.termoResponsabilidade = termoResponsabilidade;
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
    }

    public Adocao(Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.termoResponsabilidade = termoResponsabilidade;
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
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
        return getAdotante() == null && this.dataAdocao == null && 
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
        AdotanteJsonHandler jsonHandler = new AdotanteJsonHandler();
        List<Adotante> listaAdotante= jsonHandler.listarAdotantes();
        Optional<Adotante> adotante = listaAdotante.stream()
                .filter(procurado -> cpfAdotante.equals(procurado.getCpf()))
                .findFirst();
        return adotante.orElse(null);
    }

    public void setAdotante(Adotante adotante) {
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
    }

    public Animal getAnimal() {
        AnimalJsonHandler jsonHandler = new AnimalJsonHandler();
        ArrayList<Animal> listaAnimais= jsonHandler.carregarAnimaisDoArquivo();
        Optional<Animal> animal = listaAnimais.stream()
                .filter(procurado -> idAnimal.equals(procurado.getAnimalID()))
                .findFirst();
        return animal.orElse(null);
    }

    public void setAnimal(Animal animal) {
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
    }

    @Override
    public String toString() {
        return "Adocao{" + "dataAdocao=" + dataAdocao + ", termoResponsabilidade=" + termoResponsabilidade + ", adotante=" + nomeAdotante + ", animal=" + nomeAnimal + '}';
    }
    
    

}
