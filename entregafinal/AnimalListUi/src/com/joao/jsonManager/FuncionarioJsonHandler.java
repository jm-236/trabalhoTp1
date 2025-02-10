/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.jsonManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.joao.model.Funcionario;
import com.joao.model.Veterinario;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Classe responsável por manipular dados de funcionários em formato JSON.
 */
public class FuncionarioJsonHandler {
    /**
     * Caminho do arquivo JSON que armazena os dados dos funcionários.
     */
    private static final String ARQUIVO_JSON = "funcionarios.json";

    /**
     * Caminho do arquivo JSON que armazena os dados do funcionário logado.
     */
    private static final String ARQUIVO_JSON_USER = "funcionarioLogado.json";

    /**
     * Instância da classe Gson configurada com adaptadores personalizados.
     */
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    /**
     * Construtor padrão da classe FuncionarioJsonHandler.
     * Adiciona um hook para limpar os dados do funcionário logado ao encerrar o programa.
     */
    public FuncionarioJsonHandler() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            limparDadosAoEncerrar();
            System.out.println("Dados do funcionário logado foram apagados ao encerrar o programa.");
        }));
    }

    /**
     * Salva a lista de funcionários no arquivo JSON.
     *
     * @param funcionarios Lista de funcionários a ser salva.
     */
    private void salvarFuncionarios(List<Funcionario> funcionarios) {
        try (FileWriter writer = new FileWriter(ARQUIVO_JSON)) {
            gson.toJson(funcionarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega a lista de funcionários do arquivo JSON.
     *
     * @return Lista de funcionários carregada do arquivo.
     */
    private List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        File arquivo = new File(ARQUIVO_JSON);

        try {
            // Se o arquivo não existir, cria um novo com lista vazia
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                salvarFuncionarios(new ArrayList<>()); // Salva lista vazia
            }

            // Carrega os dados do arquivo
            try (FileReader reader = new FileReader(arquivo)) {
                Type tipoLista = new TypeToken<ArrayList<Funcionario>>() {}.getType();
                funcionarios = gson.fromJson(reader, tipoLista);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios != null ? funcionarios : new ArrayList<>();
    }

    /**
     * Carrega a lista de funcionários do arquivo JSON, diferenciando entre funcionários e veterinários.
     *
     * @return Lista de funcionários carregada do arquivo.
     */
    public List<Funcionario> carregarFuncionariosDiferencial() {
        List<Funcionario> funcionarios = new ArrayList<>();
        File arquivo = new File(ARQUIVO_JSON);

        try {
            if (!arquivo.exists()) {
                return funcionarios;
            }

            try (FileReader reader = new FileReader(arquivo)) {
                JsonElement jsonElement = JsonParser.parseReader(reader);
                if (jsonElement.isJsonArray()) {
                    JsonArray jsonArray = jsonElement.getAsJsonArray();
                    for (JsonElement element : jsonArray) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        if (jsonObject.has("crmv")) {
                            funcionarios.add(gson.fromJson(jsonObject, Veterinario.class));
                        } else {
                            funcionarios.add(gson.fromJson(jsonObject, Funcionario.class));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    /**
     * Adiciona um novo funcionário à lista e salva no arquivo JSON.
     *
     * @param funcionario Funcionário a ser adicionado.
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = carregarFuncionariosDiferencial();
        funcionario.setId(UUID.randomUUID().toString());
        funcionarios.add(funcionario);
        salvarFuncionarios(funcionarios);
    }

    /**
     * Lista todos os funcionários carregados do arquivo JSON.
     *
     * @return Lista de funcionários.
     */
    public List<Funcionario> listarFuncionarios() {
        return carregarFuncionarios();
    }

    /**
     * Atualiza os dados de um funcionário existente no arquivo JSON.
     *
     * @param cpf CPF do funcionário a ser atualizado.
     * @param funcionarioAtualizado Dados atualizados do funcionário.
     */
    public void atualizarFuncionario(String cpf, Funcionario funcionarioAtualizado) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(cpf)) {
                funcionarios.set(i, funcionarioAtualizado);
                break;
            }
        }
        salvarFuncionarios(funcionarios);
    }

    /**
     * Remove um funcionário da lista pelo CPF e salva no arquivo JSON.
     *
     * @param cpf CPF do funcionário a ser removido.
     */
    public void removerFuncionario(String cpf) {
        List<Funcionario> funcionarios = carregarFuncionariosDiferencial();
        funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpf));
        salvarFuncionarios(funcionarios);
    }

    /**
     * Busca um funcionário pelo CPF.
     *
     * @param cpf CPF do funcionário a ser buscado.
     * @return Optional contendo o funcionário encontrado, ou vazio se não encontrado.
     */
    public Optional<Funcionario> buscarFuncionario(String cpf) {
        List<Funcionario> funcionarios = carregarFuncionariosDiferencial();
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getCpf().equals(cpf))
                .findFirst()
                .map(funcionario -> {
                    JsonElement jsonElement = gson.toJsonTree(funcionario);
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("crmv")) {
                        return gson.fromJson(jsonObject, Veterinario.class);
                    } else {
                        return gson.fromJson(jsonObject, Funcionario.class);
                    }
                });
    }

    /**
     * Salva os dados do funcionário logado no arquivo JSON.
     *
     * @param funcionario Funcionário logado.
     */
    public void SalvarFuncionarioLogado(Funcionario funcionario) {
        try (FileWriter writer = new FileWriter(ARQUIVO_JSON_USER)) {
            gson.toJson(funcionario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém os dados do funcionário logado do arquivo JSON.
     *
     * @return Funcionário logado ou null se não encontrado.
     */
    public Funcionario GetFuncionarioLogado() {
        File arquivo = new File(ARQUIVO_JSON_USER);
        if (!arquivo.exists()) {
            System.out.println("arquivo funcionarioLogado não existe");
            return null;
        }

        try (FileReader reader = new FileReader(arquivo)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject);

            if (jsonObject.has("crmv")) {
                System.out.println("achei um veterinario");
                return gson.fromJson(jsonObject, Veterinario.class);
            } else {
                return gson.fromJson(jsonObject, Funcionario.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Limpa os dados do funcionário logado ao encerrar o programa.
     */
    public void limparDadosAoEncerrar() {
        File arquivo = new File(ARQUIVO_JSON_USER);
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }
}