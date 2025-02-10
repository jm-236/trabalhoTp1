package com.iasmim.swing;

import com.iasmim.pdfManager.PDFCreator;
import com.arthur.main.TelaPrincipal;
import com.joao.model.Funcionario;
import com.joao.model.Historico;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author iasmimqf
 */
public class HistoricoFrame extends javax.swing.JFrame {        
    private final ArrayList<Historico> listaHistoricoOriginal;
    private ArrayList<Historico> listaHistorico;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Funcionario funcionarioLogado;
    /**
     * Creates new form HistoricoFrame
     */
    public HistoricoFrame(Funcionario funcionario) {
        funcionarioLogado = funcionario;
        HandleJson handleJson = new HandleJson();
        listaHistorico = handleJson.carregarHistoricoDoArquivo();
        listaHistoricoOriginal = listaHistorico;
        // Ordenando a lista pelo atributo LocalDateTime de forma decrescente
        listaHistorico.sort(Comparator.comparing(Historico::getDataHora).reversed());
        initComponents();
        setLocationRelativeTo(null);
        atualizarTabela();
    }
    
    public void filtrarEventoLista(boolean novoPet, boolean adocao, boolean fichaVet, boolean exclusoes, boolean edicoes, int dia, int mes, int ano, String nome){
        if(!novoPet && !adocao && !fichaVet && !exclusoes && !edicoes){
            novoPet = true;
            adocao = true;
            fichaVet = true;
            exclusoes = true;
            edicoes = true;
        }
        listaHistorico = new ArrayList();
        for(Historico historico : listaHistoricoOriginal){
            if((historico.getEvento().equals("Novo Pet") && novoPet) ||
            (historico.getEvento().length() > 5 && historico.getEvento().substring(0, 6).equals("Adoção") && adocao) ||
            (historico.getEvento().length() > 11 && historico.getEvento().substring(0, 12).equals("Ficha Médica") && fichaVet) ||
            (historico.getEvento().equals("Exclusão de Pet") && exclusoes) ||
            (historico.getEvento().equals("Edição de Pet") && edicoes)){
                if(dia <= 0 || historico.getDataHora().getDayOfMonth() == dia)
                    if (mes <= 0 || historico.getDataHora().getMonthValue() == mes)
                        if (ano < 0 || historico.getDataHora().getYear() == ano)
                            if(nome.isEmpty() || (historico.getNomeAnimal().length() >= nome.length() && nome.equals(historico.getNomeAnimal().subSequence(0, nome.length()))))
                                listaHistorico.add(historico);
            }
        }
    }
    
    public void atualizarTabela(){
        String[] colunas = {"Data", "Hora", "Evento", "Nome do Animal", "Id do Animal", "Id do Evento"}; 
        Object[][] dadosTabela = new Object[listaHistorico.size()][6];
        for (int i = 0; i < listaHistorico.size(); i++) {
            Historico historico = listaHistorico.get(i);
            dadosTabela[i][0] = historico.getData().format(DATE_FORMATTER);
            dadosTabela[i][1] = historico.getHora().format(TIME_FORMATTER);
            dadosTabela[i][2] = historico.getEvento();
            dadosTabela[i][3] = historico.getNomeAnimal();
            dadosTabela[i][4] = historico.getIdAnimal();
            dadosTabela[i][5] = historico.getIdEvento();
        }
        DefaultTableModel model = new DefaultTableModel(dadosTabela, colunas);
        tabelaHist.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        newPetCheckBox = new javax.swing.JCheckBox();
        adocoesCheckBox = new javax.swing.JCheckBox();
        fichaVetCheckBox = new javax.swing.JCheckBox();
        exclusoesCheckBox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        diaComboBox = new javax.swing.JComboBox<>();
        mesComboBox = new javax.swing.JComboBox<>();
        anoComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pesquisaButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        edicoesCheckBox = new javax.swing.JCheckBox();
        gerarPDFButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHist = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botaoInicio = new javax.swing.JButton();
        botaoAnimal = new javax.swing.JButton();
        botaoAdocao = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botaoSair = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Lato Medium", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(48, 63, 56));
        jLabel6.setText("Data");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(177, 251, 216));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel1.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(48, 63, 56));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iasmim/image/pawIcon6.jpeg"))); // NOI18N
        jLabel1.setText("Histórico da ONG");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lato Semibold", 0, 20), new java.awt.Color(48, 63, 56))); // NOI18N
        jPanel2.setOpaque(false);

        newPetCheckBox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        newPetCheckBox.setForeground(new java.awt.Color(48, 63, 56));
        newPetCheckBox.setText("Novos Pets");
        newPetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPetCheckBoxActionPerformed(evt);
            }
        });

        adocoesCheckBox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        adocoesCheckBox.setForeground(new java.awt.Color(48, 63, 56));
        adocoesCheckBox.setText("Adoções");

        fichaVetCheckBox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        fichaVetCheckBox.setForeground(new java.awt.Color(48, 63, 56));
        fichaVetCheckBox.setText("Fichas Veterinárias");
        fichaVetCheckBox.setActionCommand("");
        fichaVetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fichaVetCheckBoxActionPerformed(evt);
            }
        });

        exclusoesCheckBox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        exclusoesCheckBox.setForeground(new java.awt.Color(48, 63, 56));
        exclusoesCheckBox.setText("Exlcusões de Pet");
        exclusoesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exclusoesCheckBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato Medium", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 63, 56));
        jLabel2.setText("Data");

        diaComboBox.setEditable(true);
        diaComboBox.setFont(new java.awt.Font("Liberation Mono", 0, 14)); // NOI18N
        diaComboBox.setForeground(new java.awt.Color(48, 63, 56));
        diaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mesComboBox.setFont(new java.awt.Font("Liberation Mono", 0, 14)); // NOI18N
        mesComboBox.setForeground(new java.awt.Color(48, 63, 56));
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        anoComboBox.setFont(new java.awt.Font("Liberation Mono", 0, 14)); // NOI18N
        anoComboBox.setForeground(new java.awt.Color(48, 63, 56));
        anoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "2025", "2024", "2023", "2022", "2021", "2020" }));

        jLabel3.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(48, 63, 56));
        jLabel3.setText("Mês");

        jLabel4.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(48, 63, 56));
        jLabel4.setText("Dia");

        jLabel5.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(48, 63, 56));
        jLabel5.setText("Ano");

        pesquisaButton.setBackground(new java.awt.Color(21, 102, 64));
        pesquisaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        pesquisaButton.setForeground(new java.awt.Color(255, 255, 255));
        pesquisaButton.setText("Pesquisar");
        pesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaButtonActionPerformed(evt);
            }
        });

        limparButton.setBackground(new java.awt.Color(21, 102, 64));
        limparButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        limparButton.setForeground(new java.awt.Color(255, 255, 255));
        limparButton.setText("Limpar");
        limparButton.setPreferredSize(new java.awt.Dimension(108, 36));
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lato Medium", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(48, 63, 56));
        jLabel8.setText("Nome do Animal");

        nomeTextField.setToolTipText("");
        nomeTextField.setPreferredSize(new java.awt.Dimension(131, 29));
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });

        edicoesCheckBox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        edicoesCheckBox.setForeground(new java.awt.Color(48, 63, 56));
        edicoesCheckBox.setText("Edições de Pet");
        edicoesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicoesCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(40, 40, 40))
                            .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(diaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(mesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(anoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPetCheckBox)
                                    .addComponent(adocoesCheckBox)
                                    .addComponent(fichaVetCheckBox)
                                    .addComponent(exclusoesCheckBox)
                                    .addComponent(edicoesCheckBox)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(pesquisaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(newPetCheckBox)
                .addGap(12, 12, 12)
                .addComponent(adocoesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fichaVetCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exclusoesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edicoesCheckBox)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        gerarPDFButton.setBackground(new java.awt.Color(21, 102, 64));
        gerarPDFButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        gerarPDFButton.setForeground(new java.awt.Color(255, 255, 255));
        gerarPDFButton.setText("Gerar PDF");
        gerarPDFButton.setPreferredSize(new java.awt.Dimension(108, 36));
        gerarPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarPDFButtonActionPerformed(evt);
            }
        });

        tabelaHist.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        tabelaHist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Evento", "Nome do Animal", "Id do Animal", "Id do Evento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaHist.setEnabled(false);
        jScrollPane1.setViewportView(tabelaHist);

        jToolBar1.setBackground(new java.awt.Color(64, 86, 76));
        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);

        botaoInicio.setBackground(new java.awt.Color(205, 255, 232));
        botaoInicio.setForeground(new java.awt.Color(64, 86, 76));
        botaoInicio.setText("Início");
        botaoInicio.setFocusable(false);
        botaoInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoInicio.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoInicio.setOpaque(true);
        botaoInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicioActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoInicio);

        botaoAnimal.setBackground(new java.awt.Color(205, 255, 232));
        botaoAnimal.setForeground(new java.awt.Color(64, 86, 76));
        botaoAnimal.setText("Novo Pet");
        botaoAnimal.setFocusable(false);
        botaoAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAnimal.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoAnimal.setOpaque(true);
        botaoAnimal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAnimalActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoAnimal);

        botaoAdocao.setBackground(new java.awt.Color(205, 255, 232));
        botaoAdocao.setForeground(new java.awt.Color(64, 86, 76));
        botaoAdocao.setText("Adoção");
        botaoAdocao.setFocusable(false);
        botaoAdocao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAdocao.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoAdocao.setOpaque(true);
        botaoAdocao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdocaoActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoAdocao);
        jToolBar1.add(filler1);

        botaoSair.setBackground(new java.awt.Color(205, 255, 232));
        botaoSair.setForeground(new java.awt.Color(64, 86, 76));
        botaoSair.setText("Sair");
        botaoSair.setFocusable(false);
        botaoSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSair.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoSair.setOpaque(true);
        botaoSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoSair);

        jComboBox1.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data (decrescente)", "Data (crescente)", "Nome (decrescente)", "Nome (crescente)", "Evento", "Id do Animal" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jLabel7.setText("Odernar por :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gerarPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gerarPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newPetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPetCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPetCheckBoxActionPerformed

    private void fichaVetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fichaVetCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fichaVetCheckBoxActionPerformed

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        this.dispose();
        TelaPrincipal mainScreen = new TelaPrincipal(funcionarioLogado);
        mainScreen.setVisible(true);
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAnimalActionPerformed
        this.dispose();
        CadastroAnimal cadastroScreen = new CadastroAnimal(funcionarioLogado);
        cadastroScreen.setVisible(true);
    }//GEN-LAST:event_botaoAnimalActionPerformed

    private void botaoAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdocaoActionPerformed
        this.dispose();
        FichaAdocao adocaoScreen = new FichaAdocao(funcionarioLogado);
        adocaoScreen.setVisible(true);
    }//GEN-LAST:event_botaoAdocaoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
        TelaLogin n = new TelaLogin();
        n.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void exclusoesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exclusoesCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exclusoesCheckBoxActionPerformed

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        listaHistorico = listaHistoricoOriginal;
        newPetCheckBox.setSelected(false);
        adocoesCheckBox.setSelected(false);
        fichaVetCheckBox.setSelected(false);
        exclusoesCheckBox.setSelected(false);
        edicoesCheckBox.setSelected(false);
        nomeTextField.setText("");
        diaComboBox.setSelectedIndex(0);
        mesComboBox.setSelectedIndex(0);
        anoComboBox.setSelectedIndex(0);
        atualizarTabela();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void pesquisaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaButtonActionPerformed
        boolean newPet = newPetCheckBox.isSelected();
        boolean adocao = adocoesCheckBox.isSelected();
        boolean fichaVet = fichaVetCheckBox.isSelected();
        boolean exclusoes = exclusoesCheckBox.isSelected();
        boolean edicoes = edicoesCheckBox.isSelected();
        
        String nome = nomeTextField.getText();
        
        int dia = diaComboBox.getSelectedIndex();
        int mes = mesComboBox.getSelectedIndex();
        String anoS = anoComboBox.getSelectedItem().toString();
        int ano;
        try {
            ano = Integer.parseInt(anoS);
        } catch (NumberFormatException e) {
            ano = -1;
        }
        
        filtrarEventoLista(newPet, adocao, fichaVet, exclusoes, edicoes, dia, mes, ano, nome);
        jComboBox1.setSelectedIndex(0);
        atualizarTabela();
    }//GEN-LAST:event_pesquisaButtonActionPerformed

    private void gerarPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarPDFButtonActionPerformed
        PDFCreator pdf = new PDFCreator("Historico");
        pdf.definirCabecalho(funcionarioLogado);
        pdf.definirTitulo("Histórico");
        int i=1;
        for(Historico historico : listaHistorico) pdf.adicionarParagrafo(i++ + " : " + historico.toString());
        pdf.exportarEPdf();
    }//GEN-LAST:event_gerarPDFButtonActionPerformed

    private void edicoesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicoesCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edicoesCheckBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        switch (jComboBox1.getSelectedIndex()) {
        //ordenar data decrescente
            case 0:
                listaHistorico.sort(Comparator.comparing(Historico::getDataHora).reversed());
                break;
        //ordenar data crescente
            case 1:
                listaHistorico.sort(Comparator.comparing(Historico::getDataHora));
                break;
        //ordenar nome decrescente
            case 2:
                listaHistorico.sort(Comparator.comparing(Historico::getNomeAnimal).reversed());
                break;
        //ordenar nome crescente
            case 3:
                listaHistorico.sort(Comparator.comparing(Historico::getNomeAnimal));
                break;
        //ordenar por tipo de evento
            case 4:
                listaHistorico.sort(Comparator.comparing(Historico::getEvento));
                break;
        //ordenar por tipo de evento
            case 5:
                listaHistorico.sort(Comparator.comparing(Historico::getIdAnimal));
                break;
            default:
                listaHistorico.sort(Comparator.comparing(Historico::getDataHora).reversed());
                break;
        }
        atualizarTabela();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoricoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoFrame(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adocoesCheckBox;
    private javax.swing.JComboBox<String> anoComboBox;
    private javax.swing.JButton botaoAdocao;
    private javax.swing.JButton botaoAnimal;
    private javax.swing.JButton botaoInicio;
    private javax.swing.JButton botaoSair;
    private javax.swing.JComboBox<String> diaComboBox;
    private javax.swing.JCheckBox edicoesCheckBox;
    private javax.swing.JCheckBox exclusoesCheckBox;
    private javax.swing.JCheckBox fichaVetCheckBox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton gerarPDFButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton limparButton;
    private javax.swing.JComboBox<String> mesComboBox;
    private javax.swing.JCheckBox newPetCheckBox;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton pesquisaButton;
    private javax.swing.JTable tabelaHist;
    // End of variables declaration//GEN-END:variables
}
