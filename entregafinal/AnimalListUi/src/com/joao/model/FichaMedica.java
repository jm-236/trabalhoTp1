package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class FichaMedica {

    private LocalDate dataHora;
    private String diagnostico;
    private String tratamento;
    private String fichaId;
    private Veterinario veterinario;
    
    
    
    public FichaMedica(LocalDate dataHora, String diagnostico, String tratamento, Veterinario veterinario) {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = dataHora;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.veterinario = veterinario;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getFichaId(){
        return fichaId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
