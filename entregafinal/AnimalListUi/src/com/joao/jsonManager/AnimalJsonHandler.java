/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.jsonManager;

import com.arthur.main.TelaPrincipal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.joao.jsonManager.TermoAdapter;
import com.joao.model.Animal;
import com.joao.model.Historico;
import com.joao.model.Termo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Classe responsável por manipular dados de animais em formato JSON.
 */
public class AnimalJsonHandler {
    /**
     * Caminho do arquivo JSON que armazena os dados dos animais.
     */
    private static final String CAMINHO_ARQUIVO_ANIMAIS = "animais.json";

    /**
     * Instância da classe Gson configurada com adaptadores personalizados.
     */
    private Gson gson;

    /**
     * Construtor padrão da classe AnimalJsonHandler.
     */
    public AnimalJsonHandler() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapterr())
                .registerTypeAdapter(ImageIcon.class, new ImageIconAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .registerTypeAdapter(Termo.class, new TermoAdapter())
                .setPrettyPrinting()
                .create();
    }

    /**
     * Carrega a lista de animais do arquivo JSON.
     *
     * @return Lista de animais carregada do arquivo.
     */
    public ArrayList<Animal> carregarAnimaisDoArquivo() {
        try (Reader reader = new FileReader(CAMINHO_ARQUIVO_ANIMAIS)) {
            java.lang.reflect.Type tipoLista = new TypeToken<ArrayList<Animal>>() {}.getType();
            ArrayList<Animal> animais = gson.fromJson(reader, tipoLista);
            return (animais != null) ? animais : new ArrayList<>();
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, retorna lista vazia
            return new ArrayList<Animal>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Animal>();
        }
    }

    /**
     * Busca um animal pelo ID.
     *
     * @param id ID do animal a ser buscado.
     * @return Animal encontrado ou null se não encontrado.
     */
    public Animal buscarAnimalPeloId(String id) {
        ArrayList<Animal> animais = this.carregarAnimaisDoArquivo();

        return animais.stream()
                .filter(animal -> animal.getAnimalID()
                        .equals(id)).findFirst().get();
    }

    /**
     * Atualiza os dados de um animal existente no arquivo JSON.
     *
     * @param id ID do animal a ser atualizado.
     * @param novoAnimal Dados atualizados do animal.
     */
    public void atualizarAnimal(String id, Animal novoAnimal) {
        ArrayList<Animal> animais = this.carregarAnimaisDoArquivo();

        for (Animal animal : animais) {
            if (animal.getAnimalID().equals(id)){
                animais.set(animais.indexOf(animal), novoAnimal);
                break;
            }
        }
        this.salvarAnimaisNoArquivo(animais);
    }

    /**
     * Salva a lista de animais no arquivo JSON.
     *
     * @param listaDeAnimais Lista de animais a ser salva.
     */
    public void salvarAnimaisNoArquivo(ArrayList<Animal> listaDeAnimais) {
        try (Writer writer = new FileWriter(CAMINHO_ARQUIVO_ANIMAIS)) {
            gson.toJson(listaDeAnimais, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO_ANIMAIS))) {
            String linha;
            System.out.println("Conteúdo do arquivo JSON:");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adaptador personalizado para serializar e desserializar objetos LocalDate.
     */
    public class LocalDateAdapterr extends TypeAdapter<LocalDate> {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        @Override
        public void write(JsonWriter out, LocalDate localDate) throws IOException {
            if (localDate == null) {
                out.nullValue();  // Permite null na serialização
                return;
            }
            out.value(localDate.format(formatter));
        }

        @Override
        public LocalDate read(JsonReader jsonReader) throws IOException {
            return LocalDate.parse(jsonReader.nextString(), formatter);
        }
    }

    /**
     * Adaptador personalizado para serializar e desserializar objetos LocalDateTime.
     */
    public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        @Override
        public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
            jsonWriter.value(localDateTime.format(formatter));
        }

        @Override
        public LocalDateTime read(JsonReader jsonReader) throws IOException {
            return LocalDateTime.parse(jsonReader.nextString(), formatter);
        }
    }

    /**
     * Adaptador personalizado para serializar e desserializar objetos ImageIcon.
     */
    class ImageIconAdapter extends TypeAdapter<ImageIcon> {
        @Override
        public void write(JsonWriter out, ImageIcon icon) throws IOException {
            if (icon == null) {
                out.nullValue();
                return;
            }

            // Converte ImageIcon para BufferedImage de forma segura
            BufferedImage bufferedImage = toBufferedImage(icon.getImage());

            // Converte BufferedImage para Base64
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());

            out.value(base64);
        }

        @Override
        public ImageIcon read(JsonReader in) throws IOException {
            String base64 = in.nextString();
            byte[] bytes = Base64.getDecoder().decode(base64);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(bais);
            return new ImageIcon(bufferedImage);
        }

        /**
         * Método auxiliar para converter Image para BufferedImage.
         *
         * @param img Imagem a ser convertida.
         * @return BufferedImage convertida.
         */
        private BufferedImage toBufferedImage(Image img) {
            if (img instanceof BufferedImage) {
                return (BufferedImage) img;
            }

            // Cria um BufferedImage com o tamanho e tipo corretos
            BufferedImage bufferedImage = new BufferedImage(
                    img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
            );

            // Desenha a imagem no BufferedImage
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();

            return bufferedImage;
        }
    }
}