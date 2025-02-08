/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.model;

/**
 *
 * @author joao
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson; 

public class CepInfo {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private Boolean erro;

    public CepInfo() {
    }

    
    
    public boolean isErro() {
        return erro != null && erro;
    }

    @Override
    public String toString() {
        if (isErro()) {
            return "CEP não encontrado!";
        }
        return "Logradouro: " + (logradouro != null ? logradouro : "Não informado") + 
                " Bairro: " + (bairro != null ? bairro : "Não informado") +
                " Cidade: " + localidade + " - " + uf;
    }

    public static boolean validaCep(String cep) {
        // Remover caracteres não numéricos
        cep = cep.replaceAll("\\D", "");

        // Verificar se tem exatamente 8 dígitos
        return cep.matches("\\d{8}");
    }

    public static String consultaCep(String cep) {
        try {
            // Validar o formato antes de consultar
            if (!validaCep(cep)) {
                return "CEP inválido!";
            }

            // Criar URL para a API do ViaCEP
            String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Verificar resposta da API
            if (conn.getResponseCode() != 200) {
                return "Erro ao consultar o CEP!";
            }

            // Ler a resposta JSON
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                resposta.append(linha);
            }
            br.close();
            conn.disconnect();

            // Converter JSON para objeto Java usando Gson
            Gson gson = new Gson();
            CepInfo cepInfo = gson.fromJson(resposta.toString(), CepInfo.class);

            return cepInfo.toString();

        } catch (Exception e) {
            return "Erro ao buscar o CEP!";
        }
    }

}

