/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.jsonManager;

/**
 * Adaptador personalizado para serializar e desserializar objetos Termo.
 * Utiliza a biblioteca Gson para manipulação de JSON.
 *
 * @author joao
 */

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.joao.model.Termo;
import java.io.IOException;

public class TermoAdapter extends TypeAdapter<Termo> {

    /**
     * Serializa um objeto Termo para seu formato JSON.
     *
     * @param out JsonWriter para escrever o JSON.
     * @param termo Objeto Termo a ser serializado.
     * @throws IOException Se ocorrer um erro de I/O durante a escrita.
     */
    @Override
    public void write(JsonWriter out, Termo termo) throws IOException {
        if (termo == null) {
            out.nullValue();
            return;
        }

        out.beginObject();

        // Campos booleanos
        out.name("temOutrosAnimais").value(termo.isTemOutrosAnimais());

        // Campo condicional: outrosAnimais só aparece se temOutrosAnimais = true
        if (termo.isTemOutrosAnimais()) {
            out.name("outrosAnimais").value(termo.getOutrosAnimais());
        }

        out.name("podeLevarAoVet").value(termo.isPodeLevarAoVet())
                .name("ambiente").value(termo.getAmbiente())
                .name("localDuranteViagem").value(termo.getLocalDuranteViagem())
                .name("acaoSeFizerMudanca").value(termo.getAcaoSeFizerMudanca())
                .name("consciencia").value(termo.isConsciencia())
                .name("jaEntregouParaAdocao").value(termo.isJaEntregouParaAdocao());

        out.endObject();
    }

    /**
     * Desserializa um objeto JSON para seu formato Termo.
     *
     * @param in JsonReader para ler o JSON.
     * @return Objeto Termo desserializado.
     * @throws IOException Se ocorrer um erro de I/O durante a leitura.
     */
    @Override
    public Termo read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        Termo termo = new Termo();
        in.beginObject();

        while (in.hasNext()) {
            String fieldName = in.nextName();
            switch (fieldName) {
                case "temOutrosAnimais":
                    termo.setTemOutrosAnimais(in.nextBoolean());
                    break;
                case "outrosAnimais":
                    termo.setOutrosAnimais(in.nextString());
                    break;
                case "podeLevarAoVet":
                    termo.setPodeLevarAoVet(in.nextBoolean());
                    break;
                case "ambiente":
                    termo.setAmbiente(in.nextString());
                    break;
                case "localDuranteViagem":
                    termo.setLocalDuranteViagem(in.nextString());
                    break;
                case "acaoSeFizerMudanca":
                    termo.setAcaoSeFizerMudanca(in.nextString());
                    break;
                case "consciencia":
                    termo.setConsciencia(in.nextBoolean());
                    break;
                case "jaEntregouParaAdocao":
                    termo.setJaEntregouParaAdocao(in.nextBoolean());
                    break;
                default:
                    in.skipValue();
            }
        }

        in.endObject();
        return termo;
    }
}