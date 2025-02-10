/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iasmim.swing;

import com.joao.model.Animal;
import com.joao.model.FichaMedica;
import com.joao.model.Funcionario;
import com.joao.model.Historico;
import com.joao.model.Veterinario;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author iasmimqf
 */
public class EditarFichaMedica extends javax.swing.JFrame {

    /**
     * Creates new form EditarFichaMedica
     */
    private final Funcionario funcionarioLogado;
    private final Animal animal;
    private FichaMedica fichaVet;
    
    public EditarFichaMedica(Animal animal, Funcionario funcionario, FichaMedica fichaVet) {
        funcionarioLogado = funcionario;
        this.animal = animal;
        this.fichaVet = fichaVet;
        initComponents();
        setLocationRelativeTo(null);
        medTextField.setText(fichaVet.getMedicacaoContinua());
        sumplementTextField.setText(fichaVet.getSuplementacao());
        examesTextField.setText(fichaVet.getExamesRecentes());
        cirurgiasTextField.setText(fichaVet.getCirurgia());
        alergiaMedTextField.setText(fichaVet.getAlergiaMed());
        queixasTextArea.setText(fichaVet.getDiagnosticoTratamento());
        try{
            if(fichaVet.getMedicacaoContinua().isEmpty())
                naoMed.setSelected(true);
            else
                simMed.setSelected(true);
        } catch (NullPointerException e) {
            naoMed.setSelected(true);
        }
        try{
            if(fichaVet.getSuplementacao().isEmpty())
                naoSuplemento.setSelected(true);
            else
                simSuplemento.setSelected(true);
        } catch (NullPointerException e) {
            naoSuplemento.setSelected(true);
        }
        try{
            if(fichaVet.getMedicacaoContinua().isEmpty())
                naoMed.setSelected(true);
            else
                simMed.setSelected(true);
        } catch (NullPointerException e) {
            naoMed.setSelected(true);
        }
        try{
            if(fichaVet.getExamesRecentes().isEmpty())
                naoExamesButton.setSelected(true);
            else
                simExamesButton.setSelected(true);
        } catch (NullPointerException e) {
            naoExamesButton.setSelected(true);
        }
        try{
            if(fichaVet.getCirurgia().isEmpty())
                naoCirurgiasButton.setSelected(true);
            else
                simCirurgiasButton.setSelected(true);
        } catch (NullPointerException e) {
            naoCirurgiasButton.setSelected(true);
        }
        try{
            if(fichaVet.getAlergiaMed().isEmpty())
                naoAlergiaButton.setSelected(true);
            else
                simAlergiaButton.setSelected(true);
        } catch (NullPointerException e) {
            naoAlergiaButton.setSelected(true);
        }
        try{
            if(fichaVet.getTipoAtendimento().equals("Urgência")) urgenciaButton.setSelected(true);
            else if(fichaVet.getTipoAtendimento().equals("Emergência")) emergenciaButton.setSelected(true);
            else if(fichaVet.getTipoAtendimento().equals("Rotina")) rotinaButton.setSelected(true);
        } catch (NullPointerException e) {
            System.out.println("Erro ao tentar selecionar o tipo de atendimento");
        }
    }
    
    public String atendimento(){
        if(urgenciaButton.isSelected()){
            return "Urgência";
        }
        if(emergenciaButton.isSelected()){
            return "Emergência";
        }
        if(rotinaButton.isSelected()){
            return "Rotina";
        }
        return "";
    }
    
    public String medicacao(){
        if(simMed.isSelected()){
            if(medTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Antes de salvar, escreva o tipo de medicação contínua que está sendo utilizada, na caixa abaixo da pergunta.");
                return "vazio";
            }
            return medTextField.getText();
        }
        return "";
    }
    
    public String suplemento(){
        if(simSuplemento.isSelected()){
            if(sumplementTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Antes de salvar, escreva o tipo de suplementação que está sendo feita, na caixa abaixo da pergunta.");
                return "vazio";
            }
            return sumplementTextField.getText();
        }
        return "";
    }
    
    public String fezExames(){
        if(simExamesButton.isSelected()){
            if(examesTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Antes de salvar, escreva os exames que foram feitos recentemente, na caixa abaixo da pergunta.");
                return "vazio";
            }
            return examesTextField.getText();
        }
        return "";
    }
    
    public String fezCirurgias(){
        if(simCirurgiasButton.isSelected()){
            if(cirurgiasTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Antes de salvar, escreva as cirurgias que o animal já foi submetido, na caixa abaixo da pergunta.");
                return "vazio";
            }
            return cirurgiasTextField.getText();
        }
        return "";
    }
    
    public String alergiaMedicamentos(){
        if(simAlergiaButton.isSelected()){
            if(alergiaMedTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Antes de salvar, escreva as alergias medicamentosas do animal, na caixa abaixo da pergunta.");
                return "vazio";
            }
            return alergiaMedTextField.getText();
        }
        return "";
    }
    
    public boolean novaFichaMedica() throws IOException{
        String tipoAtendimento = atendimento();
        String medicacaoContinua = medicacao();
        if(medicacaoContinua.equals("vazio")) return false;
        String suplementacao = suplemento();
        if(suplementacao.equals("vazio")) return false;
        String exames = fezExames();
        if(exames.equals("vazio")) return false;
        String cirurgias = fezCirurgias();
        if(cirurgias.equals("vazio")) return false;
        String alergiaMeds = alergiaMedicamentos();
        if(alergiaMeds.equals("vazio")) return false;
        
        String historicoQueixa = queixasTextArea.getText();
        if(historicoQueixa.isEmpty()){
            JOptionPane.showMessageDialog(null, "Descreva as queixas, histórico e ou tratamento do animal antes de salvar a ficha veterinária.");
            return false;
        }
        
        fichaVet.setTipoAtendimento(tipoAtendimento);
        fichaVet.setMedicacaoContinua(medicacaoContinua);
        fichaVet.setSuplementacao(suplementacao);
        fichaVet.setExamesRecentes(exames);
        fichaVet.setCirurgia(cirurgias);
        fichaVet.setAlergiaMed(alergiaMeds);
        fichaVet.setDiagnosticoTratamento(historicoQueixa);
        
        HandleJson handleJson = new HandleJson();
        ArrayList<Animal> listaAnimais = handleJson.carregarAnimaisDoArquivo();
        for (Animal animalNaLista : listaAnimais) {
            if (animalNaLista.getAnimalID().equals(animal.getAnimalID())) {
                ArrayList<FichaMedica> fichas = animalNaLista.getAnimalFichasMedicas();
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getFichaId().equals(fichaVet.getFichaId())) {
                        fichas.set(i, fichaVet); // Substitui diretamente na lista
                    }
                }
            }
        }

        //animal.addAnimalFichaMedica(fichaVet);
        Historico historico = new Historico(animal, fichaVet, true);
        handleJson.salvarAnimaisNoArquivo(listaAnimais);
        handleJson.AddHistoricoNoArquivo(historico);
        
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        sairButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        medLabel = new javax.swing.JLabel();
        simMed = new javax.swing.JRadioButton();
        naoMed = new javax.swing.JRadioButton();
        medTextField = new javax.swing.JTextField();
        sumplementTextField = new javax.swing.JTextField();
        simSuplemento = new javax.swing.JRadioButton();
        suplementLabel = new javax.swing.JLabel();
        naoSuplemento = new javax.swing.JRadioButton();
        examesTextField = new javax.swing.JTextField();
        naoExamesButton = new javax.swing.JRadioButton();
        simExamesButton = new javax.swing.JRadioButton();
        exameslabel = new javax.swing.JLabel();
        cirurgiasTextField = new javax.swing.JTextField();
        naoCirurgiasButton = new javax.swing.JRadioButton();
        simCirurgiasButton = new javax.swing.JRadioButton();
        cirurgiasLabel = new javax.swing.JLabel();
        alergiaMedTextField = new javax.swing.JTextField();
        naoAlergiaButton = new javax.swing.JRadioButton();
        simAlergiaButton = new javax.swing.JRadioButton();
        alergiaLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queixasTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        tipoAtendimentoLabel = new javax.swing.JLabel();
        urgenciaButton = new javax.swing.JRadioButton();
        emergenciaButton = new javax.swing.JRadioButton();
        rotinaButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1230, 788));

        jPanel1.setBackground(new java.awt.Color(177, 251, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(1230, 788));

        jToolBar1.setBackground(new java.awt.Color(64, 86, 76));
        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);
        jToolBar1.add(filler1);

        sairButton.setBackground(new java.awt.Color(205, 255, 232));
        sairButton.setForeground(new java.awt.Color(64, 86, 76));
        sairButton.setText("Fechar");
        sairButton.setFocusable(false);
        sairButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sairButton.setMargin(new java.awt.Insets(4, 14, 4, 14));
        sairButton.setOpaque(true);
        sairButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(sairButton);

        jLabel1.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(48, 63, 56));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iasmim/image/veterinarioIcoon.png"))); // NOI18N
        jLabel1.setText("Ficha Veterinária");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histórico Clínico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lato Semibold", 0, 20), new java.awt.Color(48, 63, 56))); // NOI18N
        jPanel2.setOpaque(false);

        medLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        medLabel.setForeground(new java.awt.Color(48, 63, 56));
        medLabel.setText("Uso de medicação Contínua?");

        buttonGroup2.add(simMed);
        simMed.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        simMed.setForeground(new java.awt.Color(48, 63, 56));
        simMed.setText("Sim");
        simMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simMedActionPerformed(evt);
            }
        });

        buttonGroup2.add(naoMed);
        naoMed.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        naoMed.setForeground(new java.awt.Color(48, 63, 56));
        naoMed.setText("Não");
        naoMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoMedActionPerformed(evt);
            }
        });

        medTextField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        medTextField.setForeground(new java.awt.Color(48, 63, 56));
        medTextField.setText(fichaVet.getMedicacaoContinua());
        medTextField.setToolTipText("");
        medTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medTextFieldActionPerformed(evt);
            }
        });

        sumplementTextField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        sumplementTextField.setForeground(new java.awt.Color(48, 63, 56));
        sumplementTextField.setText(fichaVet.getSuplementacao());

        buttonGroup3.add(simSuplemento);
        simSuplemento.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        simSuplemento.setForeground(new java.awt.Color(48, 63, 56));
        simSuplemento.setText("Sim");
        simSuplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simSuplementoActionPerformed(evt);
            }
        });

        suplementLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        suplementLabel.setForeground(new java.awt.Color(48, 63, 56));
        suplementLabel.setText("Uso de suplementação?");

        buttonGroup3.add(naoSuplemento);
        naoSuplemento.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        naoSuplemento.setForeground(new java.awt.Color(48, 63, 56));
        naoSuplemento.setText("Não");
        naoSuplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoSuplementoActionPerformed(evt);
            }
        });

        examesTextField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        examesTextField.setForeground(new java.awt.Color(48, 63, 56));
        examesTextField.setText(fichaVet.getExamesRecentes());

        buttonGroup4.add(naoExamesButton);
        naoExamesButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        naoExamesButton.setForeground(new java.awt.Color(48, 63, 56));
        naoExamesButton.setText("Não");
        naoExamesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoExamesButtonActionPerformed(evt);
            }
        });

        buttonGroup4.add(simExamesButton);
        simExamesButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        simExamesButton.setForeground(new java.awt.Color(48, 63, 56));
        simExamesButton.setText("Sim");
        simExamesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simExamesButtonActionPerformed(evt);
            }
        });

        exameslabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        exameslabel.setForeground(new java.awt.Color(48, 63, 56));
        exameslabel.setText("Fez exames recentes?");

        cirurgiasTextField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        cirurgiasTextField.setForeground(new java.awt.Color(48, 63, 56));
        cirurgiasTextField.setText(fichaVet.getCirurgia());

        buttonGroup5.add(naoCirurgiasButton);
        naoCirurgiasButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        naoCirurgiasButton.setForeground(new java.awt.Color(48, 63, 56));
        naoCirurgiasButton.setText("Não");
        naoCirurgiasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoCirurgiasButtonActionPerformed(evt);
            }
        });

        buttonGroup5.add(simCirurgiasButton);
        simCirurgiasButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        simCirurgiasButton.setForeground(new java.awt.Color(48, 63, 56));
        simCirurgiasButton.setText("Sim");
        simCirurgiasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simCirurgiasButtonActionPerformed(evt);
            }
        });

        cirurgiasLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        cirurgiasLabel.setForeground(new java.awt.Color(48, 63, 56));
        cirurgiasLabel.setText("Realizou cirurgias?");

        alergiaMedTextField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        alergiaMedTextField.setForeground(new java.awt.Color(48, 63, 56));
        alergiaMedTextField.setText(fichaVet.getAlergiaMed());

        buttonGroup6.add(naoAlergiaButton);
        naoAlergiaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        naoAlergiaButton.setForeground(new java.awt.Color(48, 63, 56));
        naoAlergiaButton.setText("Não");
        naoAlergiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoAlergiaButtonActionPerformed(evt);
            }
        });

        buttonGroup6.add(simAlergiaButton);
        simAlergiaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        simAlergiaButton.setForeground(new java.awt.Color(48, 63, 56));
        simAlergiaButton.setText("Sim");
        simAlergiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simAlergiaButtonActionPerformed(evt);
            }
        });

        alergiaLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        alergiaLabel.setForeground(new java.awt.Color(48, 63, 56));
        alergiaLabel.setText("Alergia a medicamentos?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medTextField)
                            .addComponent(sumplementTextField)
                            .addComponent(examesTextField)
                            .addComponent(cirurgiasTextField)
                            .addComponent(alergiaMedTextField)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(medLabel)
                                .addGap(51, 51, 51)
                                .addComponent(simMed)
                                .addGap(27, 27, 27)
                                .addComponent(naoMed)
                                .addGap(0, 70, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(exameslabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(simExamesButton)
                                .addGap(27, 27, 27)
                                .addComponent(naoExamesButton)
                                .addGap(72, 72, 72))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cirurgiasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(simCirurgiasButton)
                                .addGap(27, 27, 27)
                                .addComponent(naoCirurgiasButton)
                                .addGap(72, 72, 72))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(alergiaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(simAlergiaButton)
                                .addGap(27, 27, 27)
                                .addComponent(naoAlergiaButton)
                                .addGap(71, 71, 71)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(suplementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simSuplemento)
                        .addGap(27, 27, 27)
                        .addComponent(naoSuplemento)
                        .addGap(77, 77, 77))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medLabel)
                    .addComponent(simMed)
                    .addComponent(naoMed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suplementLabel)
                    .addComponent(simSuplemento)
                    .addComponent(naoSuplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sumplementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exameslabel)
                    .addComponent(simExamesButton)
                    .addComponent(naoExamesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(examesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cirurgiasLabel)
                    .addComponent(simCirurgiasButton)
                    .addComponent(naoCirurgiasButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cirurgiasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergiaLabel)
                    .addComponent(simAlergiaButton)
                    .addComponent(naoAlergiaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alergiaMedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Queixa Principal e Histórico Recente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lato Semibold", 0, 20), new java.awt.Color(48, 63, 56))); // NOI18N
        jPanel3.setOpaque(false);

        queixasTextArea.setColumns(20);
        queixasTextArea.setRows(5);
        queixasTextArea.setText(fichaVet.getDiagnosticoTratamento());
        jScrollPane1.setViewportView(queixasTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1))
        );

        saveButton.setBackground(new java.awt.Color(21, 102, 64));
        saveButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Salvar");
        saveButton.setPreferredSize(new java.awt.Dimension(108, 36));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        tipoAtendimentoLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        tipoAtendimentoLabel.setForeground(new java.awt.Color(48, 63, 56));
        tipoAtendimentoLabel.setText("Tipo de atendimento : ");

        buttonGroup1.add(urgenciaButton);
        urgenciaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        urgenciaButton.setForeground(new java.awt.Color(48, 63, 56));
        urgenciaButton.setText("Urgência");
        urgenciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urgenciaButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(emergenciaButton);
        emergenciaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        emergenciaButton.setForeground(new java.awt.Color(48, 63, 56));
        emergenciaButton.setText("Emergência");

        buttonGroup1.add(rotinaButton);
        rotinaButton.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        rotinaButton.setForeground(new java.awt.Color(48, 63, 56));
        rotinaButton.setText("Rotina");
        rotinaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotinaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tipoAtendimentoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(urgenciaButton)
                                .addGap(18, 18, 18)
                                .addComponent(emergenciaButton)
                                .addGap(18, 18, 18)
                                .addComponent(rotinaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipoAtendimentoLabel)
                        .addComponent(urgenciaButton)
                        .addComponent(emergenciaButton)
                        .addComponent(rotinaButton)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void simMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simMedActionPerformed
        medTextField.setText(fichaVet.getMedicacaoContinua());
    }//GEN-LAST:event_simMedActionPerformed

    private void simSuplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simSuplementoActionPerformed
        sumplementTextField.setText(fichaVet.getSuplementacao());
    }//GEN-LAST:event_simSuplementoActionPerformed

    private void simExamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simExamesButtonActionPerformed
        examesTextField.setText(fichaVet.getExamesRecentes());
    }//GEN-LAST:event_simExamesButtonActionPerformed

    private void simCirurgiasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simCirurgiasButtonActionPerformed
        cirurgiasTextField.setText(fichaVet.getCirurgia());
    }//GEN-LAST:event_simCirurgiasButtonActionPerformed

    private void simAlergiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simAlergiaButtonActionPerformed
        alergiaMedTextField.setText(fichaVet.getAlergiaMed());
    }//GEN-LAST:event_simAlergiaButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            if(novaFichaMedica()){
                JOptionPane.showMessageDialog(null, "Ficha Veterinária editada com sucesso!");
                this.dispose();
            }
        } catch (IOException ex) {
            System.out.println("Erro ao tentar editar a ficha veterinária!");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void urgenciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urgenciaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urgenciaButtonActionPerformed

    private void rotinaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotinaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotinaButtonActionPerformed

    private void naoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoMedActionPerformed
        medTextField.setText("");
    }//GEN-LAST:event_naoMedActionPerformed

    private void naoSuplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoSuplementoActionPerformed
        sumplementTextField.setText("");
    }//GEN-LAST:event_naoSuplementoActionPerformed

    private void naoExamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoExamesButtonActionPerformed
        examesTextField.setText("");
    }//GEN-LAST:event_naoExamesButtonActionPerformed

    private void naoCirurgiasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoCirurgiasButtonActionPerformed
        cirurgiasTextField.setText("");
    }//GEN-LAST:event_naoCirurgiasButtonActionPerformed

    private void naoAlergiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoAlergiaButtonActionPerformed
        alergiaMedTextField.setText("");
    }//GEN-LAST:event_naoAlergiaButtonActionPerformed

    private void medTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(EditarFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarFichaMedica(new Animal(), new Funcionario(), new FichaMedica()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alergiaLabel;
    private javax.swing.JTextField alergiaMedTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JLabel cirurgiasLabel;
    private javax.swing.JTextField cirurgiasTextField;
    private javax.swing.JRadioButton emergenciaButton;
    private javax.swing.JTextField examesTextField;
    private javax.swing.JLabel exameslabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel medLabel;
    private javax.swing.JTextField medTextField;
    private javax.swing.JRadioButton naoAlergiaButton;
    private javax.swing.JRadioButton naoCirurgiasButton;
    private javax.swing.JRadioButton naoExamesButton;
    private javax.swing.JRadioButton naoMed;
    private javax.swing.JRadioButton naoSuplemento;
    private javax.swing.JTextArea queixasTextArea;
    private javax.swing.JRadioButton rotinaButton;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton simAlergiaButton;
    private javax.swing.JRadioButton simCirurgiasButton;
    private javax.swing.JRadioButton simExamesButton;
    private javax.swing.JRadioButton simMed;
    private javax.swing.JRadioButton simSuplemento;
    private javax.swing.JTextField sumplementTextField;
    private javax.swing.JLabel suplementLabel;
    private javax.swing.JLabel tipoAtendimentoLabel;
    private javax.swing.JRadioButton urgenciaButton;
    // End of variables declaration//GEN-END:variables
}
