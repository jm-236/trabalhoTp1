package com.joao.model;

import com.joao.model.Adocao;
import com.joao.model.FichaMedica;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Classe que representa um Animal.
 */
public class Animal {
    /**
     * ID do animal.
     */
    private String animalID;

    /**
     * Data de resgate do animal.
     */
    private LocalDate animalData;

    /**
     * Local do animal.
     */
    private String animalLocal;

    /**
     * Nome do animal.
     */
    private String animalNome;

    /**
     * Gênero do animal.
     */
    private String animalGenero;

    /**
     * Espécie do animal.
     */
    private String animalEspecie;

    /**
     * Peso do animal.
     */
    private float animalPeso;

    /**
     * Porte do animal.
     */
    private String animalPorte;

    /**
     * Imagem do animal.
     */
    private ImageIcon animalImage;

    /**
     * Raça do animal.
     */
    private String animalRaca;

    /**
     * Data de nascimento do animal.
     */
    private LocalDate animalDataNascimento;

    /**
     * Histórico de fichas médicas do animal.
     */
    private ArrayList<FichaMedica> histFichaMedica;

    /**
     * Adoção do animal.
     */
    private Adocao animalAdocao;

    /**
     * Formatador de data.
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construtor da classe Animal.
     *
     * @param animalDataNascimento Data de nascimento do animal.
     * @param animalLocal Local do animal.
     * @param animalNome Nome do animal.
     * @param animalGenero Gênero do animal.
     * @param animalEspecie Espécie do animal.
     * @param animalPeso Peso do animal.
     * @param animalPorte Porte do animal.
     * @param animalImage Imagem do animal.
     * @param animalRaca Raça do animal.
     * @param animalData Data do animal.
     * @param animalAdocao Adoção do animal.
     */
    public Animal(LocalDate animalDataNascimento, String animalLocal, String animalNome, String animalGenero, String animalEspecie, float animalPeso, String animalPorte, ImageIcon animalImage, String animalRaca, LocalDate animalData, Adocao animalAdocao) {
        this.animalID = UUID.randomUUID().toString();
        this.animalData = animalData;
        this.animalLocal = animalLocal;
        this.animalNome = animalNome;
        this.animalGenero = animalGenero;
        this.animalEspecie = animalEspecie;
        this.animalPeso = animalPeso;
        this.animalPorte = animalPorte;
        this.animalImage = animalImage;
        this.animalRaca = animalRaca;
        this.animalDataNascimento = animalDataNascimento;
        this.histFichaMedica = new ArrayList();
        this.animalAdocao = animalAdocao;
    }

    /**
     * Construtor da classe Animal sem o atributo adoção.
     *
     * @param animalDataNascimento Data de nascimento do animal.
     * @param animalLocal Local do animal.
     * @param animalNome Nome do animal.
     * @param animalGenero Gênero do animal.
     * @param animalEspecie Espécie do animal.
     * @param animalPeso Peso do animal.
     * @param animalPorte Porte do animal.
     * @param animalRaca Raça do animal.
     * @param animalData Data do animal.
     */
    public Animal(LocalDate animalDataNascimento, String animalLocal, String animalNome, String animalGenero, String animalEspecie, float animalPeso, String animalPorte, String animalRaca, LocalDate animalData) {
        this.animalID = UUID.randomUUID().toString();
        this.animalData = animalData;
        this.animalLocal = animalLocal;
        this.animalNome = animalNome;
        this.animalGenero = animalGenero;
        this.animalEspecie = animalEspecie;
        this.animalPeso = animalPeso;
        this.animalPorte = animalPorte;
        this.animalRaca = animalRaca;
        this.animalDataNascimento = animalDataNascimento;
        this.histFichaMedica = new ArrayList();
    }

    /**
     * Construtor vazio da classe Animal.
     */
    public Animal() {
    }

    /**
     * Converte uma string para uma data.
     *
     * @param sdata String representando a data.
     * @return Data convertida ou null se a conversão falhar.
     */
    public LocalDate convertStringToDate(String sdata){
        try {
            LocalDate data = LocalDate.parse(sdata, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return data;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    /**
     * Verifica se o animal foi adotado.
     *
     * @return true se o animal foi adotado, false caso contrário.
     */
    public boolean isAdotado() {
        Optional<Adocao> adocaoOptional = Optional.ofNullable(this.animalAdocao);
        return adocaoOptional.isPresent() ? true : false;
    }

    /**
     * Obtém a raça do animal.
     *
     * @return Raça do animal.
     */
    public String getAnimalRaca() {
        return animalRaca;
    }

    /**
     * Define a raça do animal.
     *
     * @param animalRaca Raça do animal.
     */
    public void setAnimalRaca(String animalRaca) {
        this.animalRaca = animalRaca;
    }

    /**
     * Obtém a data de nascimento do animal.
     *
     * @return Data de nascimento do animal.
     */
    public LocalDate getAnimalDataNascimento() {
        return animalDataNascimento;
    }

    /**
     * Define a data de nascimento do animal.
     *
     * @param animalDataNascimento Data de nascimento do animal.
     */
    public void setAnimalDataNascimento(LocalDate animalDataNascimento) {
        this.animalDataNascimento = animalDataNascimento;
    }

    /**
     * Define a data de nascimento do animal a partir de uma string.
     *
     * @param animalDataNascimento String representando a data de nascimento do animal.
     * @return true se a data foi definida com sucesso, false caso contrário.
     */
    public boolean setAnimalDataNascimento(String animalDataNascimento) {
        LocalDate data = convertStringToDate(animalDataNascimento);
        if(data == null) return false;
        this.animalData = data;
        return true;
    }

    /**
     * Obtém o histórico de fichas médicas do animal.
     *
     * @return Histórico de fichas médicas do animal.
     */
    public ArrayList<FichaMedica> getAnimalFichasMedicas() {
        return histFichaMedica;
    }

    /**
     * Adiciona uma ficha médica ao histórico do animal.
     *
     * @param animalFichaMedica Ficha médica a ser adicionada.
     */
    public void addAnimalFichaMedica(FichaMedica animalFichaMedica) {
        histFichaMedica.add(animalFichaMedica);
    }

    /**
     * Obtém a adoção do animal.
     *
     * @return Adoção do animal.
     */
    public Adocao getAnimalAdocao() {
        return animalAdocao;
    }

    /**
     * Define a adoção do animal.
     *
     * @param animalAdocao Adoção do animal.
     */
    public void setAnimalAdocao(Adocao animalAdocao) {
        this.animalAdocao = animalAdocao;
    }

    /**
     * Obtém o ID do animal.
     *
     * @return ID do animal.
     */
    public String getAnimalID() {
        return animalID;
    }

    /**
     * Obtém a data do animal.
     *
     * @return Data do animal.
     */
    public LocalDate getAnimalData() {
        return animalData;
    }

    /**
     * Define a data do animal.
     *
     * @param animalData Data do animal.
     */
    public void setAnimalData(LocalDate animalData) {
        this.animalData = animalData;
    }

    /**
     * Define a data de resgate do animal a partir de uma string.
     *
     * @param animalData String representando a data de resgate do animal.
     * @return true se a data foi definida com sucesso, false caso contrário.
     */
    public boolean setAnimalData(String animalData) {
        LocalDate data = convertStringToDate(animalData);
        if(data == null) return false;
        this.animalData = data;
        return true;
    }

    /**
     * Obtém o local de resgate do animal.
     *
     * @return Local de resgate do animal.
     */
    public String getAnimalLocal() {
        return animalLocal;
    }

    /**
     * Define o local de resgate do animal.
     *
     * @param animalLocal Local de resgate do animal.
     */
    public void setAnimalLocal(String animalLocal) {
        this.animalLocal = animalLocal;
    }

    /**
     * Obtém o nome do animal.
     *
     * @return Nome do animal.
     */
    public String getAnimalNome() {
        return animalNome;
    }

    /**
     * Define o nome do animal.
     *
     * @param animalNome Nome do animal.
     */
    public void setAnimalNome(String animalNome) {
        this.animalNome = animalNome;
    }

    /**
     * Obtém o gênero do animal.
     *
     * @return Gênero do animal.
     */
    public String getAnimalGenero() {
        return animalGenero;
    }

    /**
     * Define o gênero do animal.
     *
     * @param animalGenero Gênero do animal.
     */
    public void setAnimalGenero(String animalGenero) {
        this.animalGenero = animalGenero;
    }

    /**
     * Obtém a espécie do animal.
     *
     * @return Espécie do animal.
     */
    public String getAnimalEspecie() {
        return animalEspecie;
    }

    /**
     * Define a espécie do animal.
     *
     * @param animalEspecie Espécie do animal.
     */
    public void setAnimalEspecie(String animalEspecie) {
        this.animalEspecie = animalEspecie;
    }

    /**
     * Obtém o peso do animal.
     *
     * @return Peso do animal.
     */
    public float getAnimalPeso() {
        return animalPeso;
    }

    /**
     * Define o peso do animal.
     *
     * @param animalPeso Peso do animal.
     */
    public void setAnimalPeso(float animalPeso) {
        this.animalPeso = animalPeso;
    }

    /**
     * Obtém o porte do animal.
     *
     * @return Porte do animal.
     */
    public String getAnimalPorte() {
        return animalPorte;
    }

    /**
     * Define o porte do animal.
     *
     * @param animalPorte Porte do animal.
     */
    public void setAnimalPorte(String animalPorte) {
        this.animalPorte = animalPorte;
    }

    /**
     * Obtém a imagem do animal.
     *
     * @return Imagem do animal.
     */
    public ImageIcon getAnimalImage() {
        return animalImage;
    }

    /**
     * Define a imagem do animal.
     *
     * @param animalImage Imagem do animal.
     */
    public void setAnimalImage(ImageIcon animalImage) {
        this.animalImage = animalImage;
    }

    /**
     * Calcula a idade do animal a partir de sua data de nascimento.
     *
     * @return Idade do animal em anos.
     */
    public int calcularIdade() {
        return Period.between(this.getAnimalDataNascimento(), LocalDate.now()).getYears();
    }

    /**
     * Retorna uma string representando o animal.
     *
     * @return String representando o animal.
     */
    @Override
    public String toString() {
        String sanimal =  String.format("Nome : %s\nId : %s\nEspécie : %s\nRaça : %s\nGênero : %s\nPorte : %s\nPeso : %.2f\nData de Nascimento : %s\nIdade : %d anos\n", animalNome, animalID, animalEspecie, animalRaca, animalGenero, animalPorte, animalPeso, animalDataNascimento.format(DATE_FORMATTER), this.calcularIdade());
        return sanimal;
    }
}