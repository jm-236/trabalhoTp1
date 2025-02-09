
package com.joao.model;

import com.joao.model.Adocao;
import com.joao.model.FichaMedica;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Animal {
    private String animalID;
    private LocalDate animalData;
    private String animalLocal;
    private String animalNome;
    private String animalGenero;
    //private String animalIdade;
    private String animalEspecie;
    private float animalPeso;
    private String animalPorte;
    private ImageIcon animalImage;
    private String animalRaca;
    private LocalDate animalDataNascimento;
    private ArrayList<FichaMedica> histFichaMedica;
    private Adocao animalAdocao;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
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

    public Animal() {
    }

    public String getAnimalRaca() {
        return animalRaca;
    }

    public void setAnimalRaca(String animalRaca) {
        this.animalRaca = animalRaca;
    }

    public LocalDate getAnimalDataNascimento() {
        return animalDataNascimento;
    }

    public void setAnimalDataNascimento(LocalDate animalDataNascimento) {
        this.animalDataNascimento = animalDataNascimento;
    }

    public ArrayList<FichaMedica> getAnimalFichasMedicas() {
        return histFichaMedica;
    }

    public void addAnimalFichaMedica(FichaMedica animalFichaMedica) {
        histFichaMedica.add(animalFichaMedica);
    }

    public Adocao getAnimalAdocao() {
        return animalAdocao;
    }

    public void setAnimalAdocao(Adocao animalAdocao) {
        this.animalAdocao = animalAdocao;
    }
    
    
    
    public String getAnimalID() {
        return animalID;
    }

    public LocalDate getAnimalData() {
        return animalData;
    }

    public void setAnimalData(LocalDate animalData) {
        this.animalData = animalData;
    }

    public String getAnimalLocal() {
        return animalLocal;
    }

    public void setAnimalLocal(String animalLocal) {
        this.animalLocal = animalLocal;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public void setAnimalNome(String animalNome) {
        this.animalNome = animalNome;
    }

    public String getAnimalGenero() {
        return animalGenero;
    }

    public void setAnimalGenero(String animalGenero) {
        this.animalGenero = animalGenero;
    }

    //public String getAnimalIdade() {
    //    return animalIdade;
    //}

    //public void setAnimalIdade(String animalIdade) {
    //    this.animalIdade = animalIdade;
    //}

    public String getAnimalEspecie() {
        return animalEspecie;
    }

    public void setAnimalEspecie(String animalEspecie) {
        this.animalEspecie = animalEspecie;
    }

    public float getAnimalPeso() {
        return animalPeso;
    }

    public void setAnimalPeso(float animalPeso) {
        this.animalPeso = animalPeso;
    }

    public String getAnimalPorte() {
        return animalPorte;
    }

    public void setAnimalPorte(String animalPorte) {
        this.animalPorte = animalPorte;
    }

    public ImageIcon getAnimalImage() {
        return animalImage;
    }
    
    public void setAnimalImage(ImageIcon animalImage) {
        this.animalImage = animalImage;
    }
    
    public int calcularIdade() {
        return Period.between(this.getAnimalDataNascimento(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        String sanimal =  String.format("Nome : %s\nId : %s\nEspécie : %s\nRaça : %s\nGênero : %s\nPorte : %s\nPeso : %.2f\nData de Nascimento : %s\nIdade : %d anos\n", animalNome, animalID, animalEspecie, animalRaca, animalGenero, animalPorte, animalPeso, animalDataNascimento.format(DATE_FORMATTER), this.calcularIdade());
        return sanimal;
    }
    
    
    
}
