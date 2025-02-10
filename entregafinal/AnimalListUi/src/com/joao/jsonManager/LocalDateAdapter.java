package com.joao.jsonManager;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Adaptador personalizado para serializar e desserializar objetos LocalDate.
 * Utiliza o formato "dd-MM-yyyy" para a conversão.
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    /**
     * Formatador de data para o padrão "dd-MM-yyyy".
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Serializa um objeto LocalDate para seu formato JSON.
     *
     * @param localDate Objeto LocalDate a ser serializado.
     * @param type Tipo do objeto.
     * @param context Contexto de serialização.
     * @return JsonElement representando a data formatada.
     */
    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(localDate.format(formatter));
    }

    /**
     * Desserializa um objeto JSON para seu formato LocalDate.
     *
     * @param json JsonElement representando a data.
     * @param type Tipo do objeto.
     * @param context Contexto de desserialização.
     * @return Objeto LocalDate desserializado.
     * @throws JsonParseException Se ocorrer um erro durante a desserialização.
     */
    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), formatter);
    }

    /**
     * Construtor padrão da classe LocalDateAdapter.
     */
    public LocalDateAdapter() {
    }
}
