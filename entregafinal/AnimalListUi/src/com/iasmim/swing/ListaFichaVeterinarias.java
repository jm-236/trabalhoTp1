package com.iasmim.swing;

import com.joao.model.Animal;
import com.joao.model.FichaMedica;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

/**
 * @author iasmimqf
 */
public class ListaFichaVeterinarias extends JFrame {
    private JLabel nomeLabel;
    private JLabel idadeLabel;
    private JLabel fotoLabel;
    private JTable tabelaHistorico;
    private Animal animal;
    private CustomTableModel tabelaModel;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ListaFichaVeterinarias(Animal animal) {
        this.animal = animal;
        setTitle("Histórico de Fichas Médicas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel do Cabeçalho
        JPanel headerPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridLayout(1, 2));
        nomeLabel = new JLabel("Nome: " + animal.getAnimalNome(), SwingConstants.CENTER);
        idadeLabel = new JLabel("Idade: " + animal.calcularIdade() + " anos", SwingConstants.CENTER);

        // Carregar a imagem do animal
        ImageIcon foto = animal.getAnimalImage();
        fotoLabel = new JLabel(foto);

        infoPanel.add(nomeLabel);
        infoPanel.add(idadeLabel);
        headerPanel.add(infoPanel, BorderLayout.CENTER);
        headerPanel.add(fotoLabel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        // Modelo da Tabela
        String[] colunas = {"Data", "Hora", "Tipo de Atendimento", "Veterinário"};
        tabelaModel = new CustomTableModel(colunas);

        // Preencher a tabela com dados fictícios (substitua com dados reais)
        for (FichaMedica ficha : animal.getAnimalFichasMedicas()) {
            Object[] linha = {
                ficha.getData().format(DATE_FORMATTER), 
                ficha.getHora().format(TIME_FORMATTER), 
                ficha.getTipoAtendimento(), 
                ficha.getVeterinario().getNome()
            };
            tabelaModel.addRow(linha);
        }

        // Tabela
        tabelaHistorico = new JTable(tabelaModel);
        tabelaHistorico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tabelaHistorico.getSelectedRow() != -1) {
                    int row = tabelaHistorico.getSelectedRow();
                    FichaMedica ficha = animal.getAnimalFichasMedicas().get(row);
                    JOptionPane.showMessageDialog(null, "Abriu!");
                    // new DetalhesFichaMedica(ficha).setVisible(true);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);
        add(scrollPane, BorderLayout.CENTER);
    }

    private static class CustomTableModel extends DefaultTableModel {
        CustomTableModel(String[] columnNames) {
            super(columnNames, 0);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Torna todas as células não editáveis
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ListaFichaVeterinarias(new Animal()).setVisible(true);
        });
    }
}
