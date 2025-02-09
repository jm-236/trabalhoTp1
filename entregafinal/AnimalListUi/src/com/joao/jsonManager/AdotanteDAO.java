/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joao.jsonManager;

/**
 *
 * @author joao
 */

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
import com.joao.model.Adotante;
import com.joao.model.Termo;
import com.joao.model.Veterinario;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AdotanteDAO {
    private static final String ARQUIVO_JSON = "adotantes.json";
    Gson gson = new GsonBuilder()
    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter2())
    .registerTypeAdapter(ImageIcon.class, new ImageIconAdapter())
    .registerTypeAdapter(Termo.class, new TermoAdapter())
    .create();
    
    
    public AdotanteDAO() {
    }
    
    
    
    // Salva a lista de adotantes no arquivo JSON
    private void salvarAdotantes(List<Adotante> adotantes) {
        try (FileWriter writer = new FileWriter(ARQUIVO_JSON)) {
            gson.toJson(adotantes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega a lista de adotantes do arquivo JSON
    private List<Adotante> carregarAdotantes() {
        List<Adotante> adotantes = new ArrayList<>();
        File arquivo = new File(ARQUIVO_JSON);
    
        try {
            // Se o arquivo não existir, cria um novo com lista vazia
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                salvarAdotantes(new ArrayList<>()); // Salva lista vazia
            }

        // Carrega os dados do arquivo
        try (FileReader reader = new FileReader(arquivo)) {
            Type tipoLista = new TypeToken<ArrayList<Adotante>>() {}.getType();
            adotantes = gson.fromJson(reader, tipoLista);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return adotantes != null ? adotantes : new ArrayList<>();
    }
    
    // Adiciona um novo funcionário
    public void adicionarAdotante(Adotante adotante) {
        List<Adotante> adotantes = carregarAdotantes();
        adotante.setId(UUID.randomUUID().toString());
        adotantes.add(adotante);
        salvarAdotantes(adotantes);
    }

    // Lista todos os funcionários
    public List<Adotante> listarAdotantes() {
        return carregarAdotantes();
    }

    // Atualiza um funcionário existente
    public void atualizarAdotante(String cpf, Adotante adotanteAtualizado) {
        List<Adotante> adotantes = carregarAdotantes();
        for (int i = 0; i < adotantes.size(); i++) {
            if (adotantes.get(i).getCpf().equals(cpf)) {
                adotantes.set(i, adotanteAtualizado);
                break;
            }
        }
        salvarAdotantes(adotantes);
    }

    // Remove um funcionário pelo CPF
    public void removerAdotante(String cpf) {
        List<Adotante> adotantes = carregarAdotantes();
        adotantes.removeIf(adotante -> adotante.getCpf().equals(cpf));
        salvarAdotantes(adotantes);
    }
    
    public Optional<Adotante> buscarAdotante(String cpf) {
        List<Adotante> adotantes = carregarAdotantes();
        return adotantes.stream()
            .filter(adotante -> adotante.getCpf().equals(cpf))
            .findFirst();
    }
        
    
    class ImageIconAdapter extends TypeAdapter<ImageIcon> {

    @Override
    public void write(JsonWriter out, ImageIcon icon) throws IOException {
        if (icon == null) {
            out.nullValue();
            return;
        }

        // Convert ImageIcon to BufferedImage safely
        BufferedImage bufferedImage = toBufferedImage(icon.getImage());

        // Convert BufferedImage to Base64
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

    // Helper method to convert Image to BufferedImage
    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a BufferedImage with the correct size and type
        BufferedImage bufferedImage = new BufferedImage(
            img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );

        // Draw the image onto the BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return bufferedImage;
    }
} 
}
