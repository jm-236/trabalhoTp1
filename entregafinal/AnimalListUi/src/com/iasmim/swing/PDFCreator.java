/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iasmim.swing;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.joao.model.Funcionario;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author iasmimqf
 */
public class PDFCreator {

    private PdfWriter writer;
    private PdfDocument pdf;
    private Document document;
    private String downloadsPath;

    public PDFCreator(String nomepdf) {
        try {
            // Obtém o caminho para a pasta Downloads do diretório home do usuário
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("-dd-MM-yyyy-HH:mm:ss");
            String home = System.getProperty("user.home");
            downloadsPath = home + File.separator + "Downloads" + File.separator + nomepdf + LocalDateTime.now().format(formatter) + ".pdf";

            // Inicializa os objetos necessários para criar o PDF
            writer = new PdfWriter(downloadsPath);
            pdf = new PdfDocument(writer);
            document = new Document(pdf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void definirTitulo(String titulo) {
        try {
            PdfFont font = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD);
            Paragraph tituloParagrafo = new Paragraph(titulo)
                    .setFont(font)
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(tituloParagrafo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void definirCabecalho(Funcionario funcionario) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataHoraAtual.format(formatter);
        String cabecalho = dataFormatada + " | Emitido por " + funcionario.assinatura();
        Paragraph cabecalhoParagrafo = new Paragraph(cabecalho)
                .setFontSize(10)
                .setMarginTop(10);
        document.add(cabecalhoParagrafo);
    }
    
    
    public void adicionarImagemCentralizada(ImageIcon imageIcon) {
        try {
            // Converte ImageIcon para BufferedImage
            BufferedImage bufferedImage = new BufferedImage(
                    imageIcon.getIconWidth(),
                    imageIcon.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB);
            imageIcon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);

            // Converte BufferedImage para ImageData
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            ImageData data = ImageDataFactory.create(baos.toByteArray());

            // Cria a imagem iText e a centraliza
            Image imagem = new Image(data);
            imagem.setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(imagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void adicionarSubTitulo(String titulo) {
        try {
            PdfFont font = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD);
            Paragraph subtituloParagrafo = new Paragraph(titulo)
                    .setFont(font)
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(subtituloParagrafo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarParagrafo(String texto) {
        document.add(new Paragraph(texto));
    }

    public void exportarEPdf() {
        try {
            document.close();

            // Abre o arquivo PDF
            File pdfFile = new File(downloadsPath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Abertura de PDF não é suportada no seu sistema.");
                }
            } else {
                System.out.println("Arquivo PDF não foi criado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PDFCreator pdfCreator = new PDFCreator("");
    }
}
