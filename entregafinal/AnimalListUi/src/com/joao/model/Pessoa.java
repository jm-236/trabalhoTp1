package com.joao.model;

import com.joao.interfaces.validaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Classe abstrata que representa uma Pessoa.
 * Implementa a interface validaData.
 */
public abstract class Pessoa implements validaData {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    /**
     * Construtor completo da classe Pessoa.
     *
     * @param cpf CPF da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     * @param email Email da pessoa.
     * @param nome Nome da pessoa.
     * @param telefone Telefone da pessoa.
     */
    public Pessoa(String cpf, LocalDate dataNascimento, String email, String nome, String telefone) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    /**
     * Construtor vazio da classe Pessoa.
     */
    public Pessoa() {
    }

    /**
     * Verifica se o nome é válido.
     *
     * @param nome Nome a ser verificado.
     * @return true se o nome for válido, false caso contrário.
     */
    public static boolean isNomeValido(String nome) {
        if (nome.isEmpty() || nome.equals("Nome")){
            return false;
        }
        return true;
    }

    /**
     * Valida o CPF fornecido.
     *
     * @param cpf CPF a ser validado.
     * @return true se o CPF for válido, false caso contrário.
     */
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

    /**
     * Calcula o dígito verificador do CPF.
     *
     * @param cpf CPF a ser calculado.
     * @param pesoInicial Peso inicial para o cálculo.
     * @return Dígito verificador calculado.
     */
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

    /**
     * Valida a data de nascimento fornecida.
     *
     * @param dataNascimentoStr Data de nascimento em formato de string.
     * @return "true" se a data for válida, caso contrário, uma mensagem de erro.
     */
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

    /**
     * Obtém o CPF da pessoa.
     *
     * @return CPF da pessoa.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf CPF a ser definido.
     */
    public void setCpf(String cpf) {
        if(validaCpf(cpf)) {
            this.cpf = cpf.replaceAll("\\D", "");
        }
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return Data de nascimento da pessoa.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataNascimento Data de nascimento a ser definida.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o email da pessoa.
     *
     * @return Email da pessoa.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da pessoa.
     *
     * @param email Email a ser definido.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome Nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone da pessoa.
     *
     * @return Telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     *
     * @param telefone Telefone a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em string do objeto Pessoa.
     *
     * @return String representando o objeto Pessoa.
     */
    @Override
    public String toString() {
        return "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }
}