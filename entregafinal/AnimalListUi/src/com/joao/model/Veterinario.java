package com.joao.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.regex.Pattern;

public class Veterinario extends Funcionario{

    private String crmv;
    
    public Veterinario(String cpf, LocalDate dataNascimento, String email, String nome, String telefone, String senha, String crmv) {
        super(cpf, dataNascimento, email, nome, telefone, senha);
        this.crmv = crmv;
    }

    public String getCrmv() {
        return crmv;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "crmv=" + crmv + '}';
    }
    
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
}