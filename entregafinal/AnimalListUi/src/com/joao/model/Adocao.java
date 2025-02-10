package com.joao.model;

import com.joao.interfaces.validaData;
import com.joao.jsonManager.AdotanteJsonHandler;
import com.joao.jsonManager.AnimalJsonHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe que representa uma Adoção.
 */
public class Adocao implements validaData {

    /**
     * Data da adoção.
     */
    private LocalDate dataAdocao;

    /**
     * Termo de responsabilidade da adoção.
     */
    private Termo termoResponsabilidade;

    /**
     * CPF do adotante.
     */
    private String cpfAdotante;

    /**
     * Nome do adotante.
     */
    private String nomeAdotante;

    /**
     * ID do animal adotado.
     */
    private String idAnimal;

    /**
     * Nome do animal adotado.
     */
    private String nomeAnimal;

    /**
     * Formatador de data.
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construtor da classe Adocao.
     *
     * @param dataAdocao Data da adoção.
     * @param termoResponsabilidade Termo de responsabilidade da adoção.
     * @param adotante Adotante.
     * @param animal Animal adotado.
     */
    public Adocao(LocalDate dataAdocao, Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.dataAdocao = dataAdocao;
        this.termoResponsabilidade = termoResponsabilidade;
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
    }

    /**
     * Construtor da classe Adocao.
     *
     * @param termoResponsabilidade Termo de responsabilidade da adoção.
     * @param adotante Adotante.
     * @param animal Animal adotado.
     */
    public Adocao(Termo termoResponsabilidade, Adotante adotante, Animal animal) {
        this.termoResponsabilidade = termoResponsabilidade;
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
    }

    /**
     * Construtor vazio da classe Adocao.
     */
    public Adocao() {
    }

    /**
     * Valida a data de adoção.
     *
     * @param dataAdocaoStr Data de adoção em formato de string.
     * @return "true" se a data for válida, caso contrário, uma mensagem de erro.
     */
    public String validarData(String dataAdocaoStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate dataAdocao = LocalDate.parse(dataAdocaoStr, formatter);
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

    /**
     * Obtém a data em que a adoção foi realizada.
     *
     * @return Data de realização da adoção.
     */
    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    /**
     * Obtém a data de adoção em formato de string.
     *
     * @param string Indica que a data deve ser retornada como string.
     * @return Data de adoção formatada.
     */
    public String getDataAdocao(boolean string) {
        return dataAdocao.format(DATE_FORMATTER);
    }

    /**
     * Define a data de adoção.
     *
     * @param dataAdocao Data de adoção.
     */
    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    /**
     * Obtém o termo de responsabilidade.
     *
     * @return Termo de responsabilidade.
     */
    public Termo getTermoResponsabilidade() {
        return termoResponsabilidade;
    }

    /**
     * Define o termo de responsabilidade.
     *
     * @param termoResponsabilidade Termo de responsabilidade.
     */
    public void setTermoResponsabilidade(Termo termoResponsabilidade) {
        this.termoResponsabilidade = termoResponsabilidade;
    }

    /**
     * Obtém o adotante.
     *
     * @return Adotante.
     */
    public Adotante getAdotante() {
        AdotanteJsonHandler jsonHandler = new AdotanteJsonHandler();
        List<Adotante> listaAdotante= jsonHandler.listarAdotantes();
        Optional<Adotante> adotante = listaAdotante.stream()
                .filter(procurado -> cpfAdotante.equals(procurado.getCpf()))
                .findFirst();
        return adotante.orElse(null);
    }

    /**
     * Define o adotante.
     *
     * @param adotante Adotante.
     */
    public void setAdotante(Adotante adotante) {
        cpfAdotante = adotante.getCpf();
        nomeAdotante = adotante.getNome();
    }

    /**
     * Obtém o animal adotado.
     *
     * @return Animal adotado.
     */
    public Animal getAnimal() {
        AnimalJsonHandler jsonHandler = new AnimalJsonHandler();
        ArrayList<Animal> listaAnimais= jsonHandler.carregarAnimaisDoArquivo();
        Optional<Animal> animal = listaAnimais.stream()
                .filter(procurado -> idAnimal.equals(procurado.getAnimalID()))
                .findFirst();
        return animal.orElse(null);
    }

    /**
     * Define o animal adotado.
     *
     * @param animal Animal adotado.
     */
    public void setAnimal(Animal animal) {
        idAnimal = animal.getAnimalID();
        nomeAnimal = animal.getAnimalNome();
    }

    /**
     * Retorna uma representação em string da adoção.
     *
     * @return String representando a adoção.
     */
    @Override
    public String toString() {
        return "Adocao{" + "dataAdocao=" + dataAdocao + ", termoResponsabilidade=" + termoResponsabilidade + ", adotante=" + nomeAdotante + ", animal=" + nomeAnimal + '}';
    }
}