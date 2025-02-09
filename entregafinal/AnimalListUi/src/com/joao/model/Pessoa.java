package com.joao.model;

import com.joao.interfaces.validaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class Pessoa implements validaData {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    public Pessoa(String cpf, LocalDate dataNascimento, String email, String nome, String telefone) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Pessoa() {
    }
    
    public static boolean isNomeValido(String nome) {
        if (nome.isEmpty() || nome.equals("Nome")){
            return false;
        }
        return true;
    }

    public static boolean validaCpf(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verificar se tem 11 dígitos e se não é uma sequência repetida
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular os dois dígitos verificadores
        int primeiroDV = calcularDigitoVerificador(cpf, 10);
        int segundoDV = calcularDigitoVerificador(cpf, 11);

        // Comparar com os dígitos originais do CPF
        return (primeiroDV == Character.getNumericValue(cpf.charAt(9)) &&
                segundoDV == Character.getNumericValue(cpf.charAt(10)));
    }

    private static int calcularDigitoVerificador(String cpf, int pesoInicial) {
        int soma = 0;
        int peso = pesoInicial;

        for (int i = 0; i < pesoInicial - 1; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso;
            peso--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
    
    public final String validarData(String dataNascimentoStr) {
        // Define o formato esperado da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Converte a String para LocalDate
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

            // Obtém a data atual
            LocalDate dataAtual = LocalDate.now();

            // Verifica se a data de nascimento é anterior à data atual
            if (dataNascimento.isAfter(dataAtual)) {
                System.out.println();
                return "Data de nascimento no futuro.";
            }

            // Verifica se a pessoa tem pelo menos 18 anos
            long idade = ChronoUnit.YEARS.between(dataNascimento, dataAtual);
            if (idade < 18) {
                return "A pessoa tem menos de 18 anos.";
            }

            // Se passou por todas as verificações, a data é válida
            return "true";

        } catch (DateTimeParseException e) {
            
            return "Formato de data inválido. Use o formato dd/MM/yyyy.";
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(validaCpf(cpf)) {
            this.cpf = cpf.replaceAll("\\D", "");
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
}
