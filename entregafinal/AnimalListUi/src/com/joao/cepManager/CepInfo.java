/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.cepManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

/**
 * Classe responsável por armazenar e manipular informações de CEP.
 * Utiliza a API ViaCEP para consulta de dados.
 *
 * @author joao
 */
public class CepInfo {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private Boolean erro;

    /**
     * Construtor padrão da classe CepInfo.
     */
    public CepInfo() {
    }

    /**
     * Verifica se houve erro na consulta do CEP.
     *
     * @return true se houve erro, false caso contrário.
     */
    public boolean isErro() {
        return erro != null && erro;
    }

    /**
     * Retorna uma representação em string do objeto CepInfo.
     *
     * @return String representando o objeto CepInfo.
     */
    @Override
    public String toString() {
        if (isErro()) {
            return "CEP não encontrado!";
        }
        return "Logradouro: " + (logradouro != null ? logradouro : "Não informado") +
                " Bairro: " + (bairro != null ? bairro : "Não informado") +
                " Cidade: " + localidade + " - " + uf;
    }

    /**
     * Valida o formato de um CEP.
     *
     * @param cep CEP a ser validado.
     * @return true se o CEP for válido, false caso contrário.
     */
    public static boolean validaCep(String cep) {
        // Remover caracteres não numéricos
        cep = cep.replaceAll("\\D", "");

        // Verificar se tem exatamente 8 dígitos
        return cep.matches("\\d{8}");
    }

    /**
     * Consulta informações de um CEP utilizando a API ViaCEP.
     *
     * @param cep CEP a ser consultado.
     * @return String com as informações do CEP ou mensagem de erro.
     */
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