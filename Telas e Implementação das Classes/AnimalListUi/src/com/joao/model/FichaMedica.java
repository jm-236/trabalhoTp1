package com.joao.model;

import java.time.LocalDateTime;

public class FichaMedica {

    private LocalDateTime dataHora;
    private String diagnostico;
    private String tratamento;
    private Veterinario veterinario;
    
    
    
    public FichaMedica(LocalDateTime dataHora, String diagnostico, String tratamento, Veterinario veterinario) {
        this.dataHora = dataHora;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.veterinario = veterinario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
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
