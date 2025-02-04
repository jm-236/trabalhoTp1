package com.arthur.jsonmanaging;

import com.arthur.main.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.joao.model.Animal;
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

public class HandleJson {
        private static final String CAMINHO_ARQUIVO_ANIMAIS = "animais.json";
        private static final String CAMINHO_ARQUIVO_HISTORICO = "historico.json";
        private Gson gson;

    public HandleJson() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new HandleJson.LocalDateAdapter())
                .registerTypeAdapter(ImageIcon.class, new HandleJson.ImageIconAdapter())
                .setPrettyPrinting()
                .create();
    }
        
        
        
        
        
        
        
    
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
        
        
        
        
         public class LocalDateAdapter extends TypeAdapter<LocalDate> {
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
    


    public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
        jsonWriter.value(localDateTime.format(formatter));
    }

    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        return LocalDateTime.parse(jsonReader.nextString(), formatter);
    }
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