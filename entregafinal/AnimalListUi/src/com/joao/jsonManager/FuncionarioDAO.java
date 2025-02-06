/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.jsonManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.joao.model.Funcionario;
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

public class FuncionarioDAO {
    private static final String ARQUIVO_JSON = "funcionarios.json";
    Gson gson = new GsonBuilder()
    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter2())
    .create();

    // Salva a lista de funcionários no arquivo JSON
    private void salvarFuncionarios(List<Funcionario> funcionarios) {
        try (FileWriter writer = new FileWriter(ARQUIVO_JSON)) {
            gson.toJson(funcionarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega a lista de funcionários do arquivo JSON
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

    // Adiciona um novo funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        funcionario.setId(UUID.randomUUID().toString());
        funcionarios.add(funcionario);
        salvarFuncionarios(funcionarios);
    }

    // Lista todos os funcionários
    public List<Funcionario> listarFuncionarios() {
        return carregarFuncionarios();
    }

    // Atualiza um funcionário existente
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

    // Remove um funcionário pelo CPF
    public void removerFuncionario(String cpf) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpf));
        salvarFuncionarios(funcionarios);
    }
    
    public Optional<Funcionario> buscarFuncionario(String cpf) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        return funcionarios.stream().filter(funcionario -> funcionario.getCpf()
                .equals(cpf)).findFirst();
    }
}