package com.joao.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Classe Veterinario que herda de Funcionario.
 * Representa um veterinário com CRMV.
 */
public class Veterinario extends Funcionario {

    private String crmv;

    /**
     * Construtor da classe Veterinario.
     *
     * @param cpf            CPF do veterinário.
     * @param dataNascimento Data de nascimento do veterinário.
     * @param email          Email do veterinário.
     * @param nome           Nome do veterinário.
     * @param telefone       Telefone do veterinário.
     * @param senha          Senha do veterinário.
     * @param crmv           CRMV do veterinário.
     */
    public Veterinario(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String senha, String crmv) {
        super(cpf, dataNascimento, email, nome, telefone, senha);
        this.crmv = crmv;
    }

    /**
     * Obtém o CRMV do veterinário.
     *
     * @return CRMV do veterinário.
     */
    public String getCrmv() {
        return crmv;
    }

    /**
     * Retorna uma representação em string do objeto Veterinario.
     *
     * @return String representando o objeto Veterinario.
     */
    @Override
    public String toString() {
        return "Veterinario{" + "crmv=" + crmv + '}';
    }

    /**
     * Verifica se o CRMV fornecido é válido.
     *
     * @param crmv CRMV a ser validado.
     * @return true se o CRMV for válido, false caso contrário.
     */
    public static boolean isValidCRMV(String crmv) {
        if (crmv == null || crmv.isEmpty()) {
            return false; // Evita NullPointerException e garante que não seja uma string vazia
        }

        // Expressão regular para validar o formato "12345-UF"
        String crmvRegex = "^[0-9]{1,6}-[A-Z]{2}$";
        if (!Pattern.matches(crmvRegex, crmv)) {
            return false; // Retorna falso se o formato estiver incorreto
        }

        // Lista de estados válidos
        Set<String> estadosValidos = Set.of(
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
                "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        );

        // Obtém a UF do CRMV (dois últimos caracteres)
        String uf = crmv.substring(crmv.length() - 2);

        return estadosValidos.contains(uf); // Retorna true se a UF for válida, senão false
    }

    /**
     * Retorna a assinatura do veterinário.
     *
     * @return String representando a assinatura do veterinário.
     */
    @Override
    public String assinatura(){
        return String.format("%s (%s) CRMV: %s", super.getNome(), super.getId(), crmv);
    }
}