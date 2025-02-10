package com.joao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Classe que representa uma Ficha Médica de um animal.
 */
public class FichaMedica {

    /**
     * Data e hora do atendimento.
     */
    private LocalDateTime dataHora;

    /**
     * Diagnóstico e tratamento do animal.
     */
    private String diagnosticoTratamento;

    /**
     * ID da ficha médica.
     */
    private String fichaId;

    /**
     * Medicação contínua do animal.
     */
    private String medicacaoContinua;

    /**
     * Suplementação do animal.
     */
    private String suplementacao;

    /**
     * Exames recentes do animal.
     */
    private String examesRecentes;

    /**
     * Cirurgias realizadas no animal.
     */
    private String cirurgia;

    /**
     * Alergias a medicamentos do animal.
     */
    private String alergiaMed;

    /**
     * Tipo de atendimento realizado.
     */
    private String tipoAtendimento;

    /**
     * Veterinário responsável pelo atendimento.
     */
    private Veterinario veterinario;

    /**
     * Construtor da classe FichaMedica.
     *
     * @param diagnosticoTratamento Diagnóstico e tratamento do animal.
     * @param tipoAtendimento Tipo de atendimento realizado.
     * @param veterinario Veterinário responsável pelo atendimento.
     */
    public FichaMedica(String diagnosticoTratamento, String tipoAtendimento, Veterinario veterinario) {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
        this.diagnosticoTratamento = diagnosticoTratamento;
        this.tipoAtendimento = tipoAtendimento;
        this.veterinario = veterinario;
    }

    /**
     * Construtor da classe FichaMedica.
     *
     * @param tipoAtendimento Tipo de atendimento realizado.
     * @param veterinario Veterinário responsável pelo atendimento.
     */
    public FichaMedica(String tipoAtendimento, Veterinario veterinario) {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
        this.tipoAtendimento = tipoAtendimento;
        this.veterinario = veterinario;
    }

    /**
     * Construtor vazio da classe FichaMedica.
     */
    public FichaMedica() {
        this.fichaId = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
    }

    /**
     * Obtém a data e hora do atendimento.
     *
     * @return Data e hora do atendimento.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora do atendimento.
     *
     * @param dataHora Data e hora do atendimento.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém o diagnóstico e tratamento do animal.
     *
     * @return Diagnóstico e tratamento do animal.
     */
    public String getDiagnosticoTratamento() {
        return diagnosticoTratamento;
    }

    /**
     * Define o diagnóstico e tratamento do animal.
     *
     * @param diagnosticoTratamento Diagnóstico e tratamento do animal.
     */
    public void setDiagnosticoTratamento(String diagnosticoTratamento) {
        this.diagnosticoTratamento = diagnosticoTratamento;
    }

    /**
     * Obtém o ID da ficha médica.
     *
     * @return ID da ficha médica.
     */
    public String getFichaId() {
        return fichaId;
    }

    /**
     * Obtém a medicação contínua do animal.
     *
     * @return Medicação contínua do animal.
     */
    public String getMedicacaoContinua() {
        return medicacaoContinua;
    }

    /**
     * Define a medicação contínua do animal.
     *
     * @param medicacaoContinua Medicação contínua do animal.
     */
    public void setMedicacaoContinua(String medicacaoContinua) {
        this.medicacaoContinua = medicacaoContinua;
    }

    /**
     * Obtém a suplementação do animal.
     *
     * @return Suplementação do animal.
     */
    public String getSuplementacao() {
        return suplementacao;
    }

    /**
     * Define a suplementação do animal.
     *
     * @param suplementacao Suplementação do animal.
     */
    public void setSuplementacao(String suplementacao) {
        this.suplementacao = suplementacao;
    }

    /**
     * Obtém os exames recentes do animal.
     *
     * @return Exames recentes do animal.
     */
    public String getExamesRecentes() {
        return examesRecentes;
    }

    /**
     * Define os exames recentes do animal.
     *
     * @param examesRecentes Exames recentes do animal.
     */
    public void setExamesRecentes(String examesRecentes) {
        this.examesRecentes = examesRecentes;
    }

    /**
     * Obtém as cirurgias realizadas no animal.
     *
     * @return Cirurgias realizadas no animal.
     */
    public String getCirurgia() {
        return cirurgia;
    }

    /**
     * Define as cirurgias realizadas no animal.
     *
     * @param cirurgia Cirurgias realizadas no animal.
     */
    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    /**
     * Obtém as alergias a medicamentos do animal.
     *
     * @return Alergias a medicamentos do animal.
     */
    public String getAlergiaMed() {
        return alergiaMed;
    }

    /**
     * Define as alergias a medicamentos do animal.
     *
     * @param alergiaMed Alergias a medicamentos do animal.
     */
    public void setAlergiaMed(String alergiaMed) {
        this.alergiaMed = alergiaMed;
    }

    /**
     * Obtém o tipo de atendimento realizado.
     *
     * @return Tipo de atendimento realizado.
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * Define o tipo de atendimento realizado.
     *
     * @param tipoAtendimento Tipo de atendimento realizado.
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * Obtém o veterinário responsável pelo atendimento.
     *
     * @return Veterinário responsável pelo atendimento.
     */
    public Veterinario getVeterinario() {
        return veterinario;
    }

    /**
     * Define o veterinário responsável pelo atendimento.
     *
     * @param veterinario Veterinário responsável pelo atendimento.
     */
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    /**
     * Obtém a hora do atendimento.
     *
     * @return Hora do atendimento.
     */
    public LocalTime getHora() {
        return dataHora.toLocalTime();
    }

    /**
     * Obtém a data do atendimento.
     *
     * @return Data do atendimento.
     */
    public LocalDate getData() {
        return dataHora.toLocalDate();
    }

    /**
     * Obtém o histórico clínico do animal.
     *
     * @return Histórico clínico do animal.
     */
    public String getHistoricoClinico() {
        String hist = "";
        hist += " - Usa medicação contínua ? ";
        if(medicacaoContinua == null || medicacaoContinua.isEmpty()) hist += "Não\n";
        else hist += "Sim, " + medicacaoContinua + "\n";
        hist += " - Usa suplementação ? ";
        if(suplementacao == null || suplementacao.isEmpty()) hist += "Não\n";
        else hist += "Sim, " + suplementacao + "\n";
        hist += " - Fez exames recentes ? ";
        if(examesRecentes == null || examesRecentes.isEmpty()) hist += "Não\n";
        else hist += "Sim, " + examesRecentes + "\n";
        hist += " - Já realizou alguma cirurgia ? ";
        if(cirurgia == null || cirurgia.isEmpty()) hist += "Não\n";
        else hist += "Sim, " + cirurgia + "\n";
        hist += " - Tem alergia a algum medicamento ? ";
        if(alergiaMed == null || alergiaMed.isEmpty()) hist += "Não\n";
        else hist += "Sim, " + alergiaMed + "\n";

        return hist;
    }
}