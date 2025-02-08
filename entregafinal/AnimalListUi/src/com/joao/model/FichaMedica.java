package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class FichaMedica {

    private LocalDateTime dataHora;
    private String diagnosticoTratamento;
    private String fichaId;
    private String medicacaoContinua;
    private String suplementacao;
    private String examesRecentes;
    private String cirurgia;
    private String alergiaMed;
    private String tipoAtendimento;
    private Veterinario veterinario;
    
    
    
    public FichaMedica(String diagnosticoTratamento, String tipoAtendimento, Veterinario veterinario) {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
        this.diagnosticoTratamento = diagnosticoTratamento;
        this.tipoAtendimento = tipoAtendimento;
        this.veterinario = veterinario;
    }
    
    public FichaMedica(String tipoAtendimento, Veterinario veterinario) {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
        this.tipoAtendimento = tipoAtendimento;
        this.veterinario = veterinario;
    }

    public FichaMedica() {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDiagnosticoTratamento() {
        return diagnosticoTratamento;
    }

    public void setDiagnosticoTratamento(String diagnosticoTratamento) {
        this.diagnosticoTratamento = diagnosticoTratamento;
    }

    public String getFichaId() {
        return fichaId;
    }

    public String getMedicacaoContinua() {
        return medicacaoContinua;
    }

    public void setMedicacaoContinua(String medicacaoContinua) {
        this.medicacaoContinua = medicacaoContinua;
    }

    public String getSuplementacao() {
        return suplementacao;
    }

    public void setSuplementacao(String suplementacao) {
        this.suplementacao = suplementacao;
    }

    public String getExamesRecentes() {
        return examesRecentes;
    }

    public void setExamesRecentes(String examesRecentes) {
        this.examesRecentes = examesRecentes;
    }

    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getAlergiaMed() {
        return alergiaMed;
    }

    public void setAlergiaMed(String alergiaMed) {
        this.alergiaMed = alergiaMed;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
