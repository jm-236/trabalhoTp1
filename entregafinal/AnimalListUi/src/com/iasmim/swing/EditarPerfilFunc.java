/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iasmim.swing;

import com.arthur.main.TelaPrincipal;
import com.joao.jsonManager.FuncionarioJsonHandler;
import com.joao.model.Funcionario;
import com.joao.model.Veterinario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class EditarPerfilFunc extends javax.swing.JFrame {

    private Funcionario funcionarioDoPerfil;
    private FuncionarioJsonHandler funcionarioManager;
    
    public EditarPerfilFunc() {
        initComponents();
        setLocationRelativeTo(null);
        this.funcionarioManager = new FuncionarioJsonHandler();
        this.funcionarioDoPerfil = funcionarioManager.GetFuncionarioLogado();
        //this.oldFuncionario = funcionarioManager.GetFuncionarioLogado();
        MostrarDados();
    }
    
    public boolean ConfirmarSenha(){
        String senha1 = new String(senhaField2.getPassword());
        String senha2 = new String(senhaField1.getPassword());
        
        if((funcionarioDoPerfil.getSenha()).equals(senha1) && senha1.equals(senha2)){
            return true;
        }
        else{
            if(!senha1.equals(senha2)){
                JOptionPane.showMessageDialog(null, "Os Campos de Senha devem coincidir");
            }
            else if(!(funcionarioDoPerfil.getSenha()).equals(senha1)){
                JOptionPane.showMessageDialog(null, "Senha Incorreta");
            }
            return false;
        }
    }
    
    
    public void MostrarDados(){
        nomeField.setText(funcionarioDoPerfil.getNome());
        cpfField.setText(funcionarioDoPerfil.getCpf());
        telefoneField.setText(funcionarioDoPerfil.getTelefone());
        emailField.setText(funcionarioDoPerfil.getEmail());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefoneField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        senhaField2 = new javax.swing.JPasswordField();
        senhaField1 = new javax.swing.JPasswordField();
        salvarMudancas = new javax.swing.JButton();
        voltarPerfil = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        botaoInicio1 = new javax.swing.JButton();
        botaoAnimal = new javax.swing.JButton();
        botaoAdocao = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(177, 251, 216));

        jLabel1.setBackground(new java.awt.Color(64, 86, 76));
        jLabel1.setFont(new java.awt.Font("Lato Semibold", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Perfil");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        nomeField.setBackground(new java.awt.Color(217, 217, 217));
        nomeField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        nomeField.setForeground(new java.awt.Color(32, 61, 74));
        nomeField.setText("Nome Completo do Funcionário");
        nomeField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        nomeField.setMargin(new java.awt.Insets(4, 15, 4, 15));

        jLabel2.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 63, 56));
        jLabel2.setText("Nome : ");

        cpfField.setBackground(new java.awt.Color(217, 217, 217));
        cpfField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        cpfField.setForeground(new java.awt.Color(32, 61, 74));
        cpfField.setText("000.000.000-00");
        cpfField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        cpfField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        cpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(48, 63, 56));
        jLabel3.setText("CPF :");

        telefoneField.setBackground(new java.awt.Color(217, 217, 217));
        telefoneField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        telefoneField.setForeground(new java.awt.Color(32, 61, 74));
        telefoneField.setText("(00) 99824 - 4353");
        telefoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        telefoneField.setMargin(new java.awt.Insets(4, 15, 4, 15));

        jLabel4.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(48, 63, 56));
        jLabel4.setText("Telefone : ");

        jLabel5.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(48, 63, 56));
        jLabel5.setText("E-mail :");

        emailField.setBackground(new java.awt.Color(217, 217, 217));
        emailField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        emailField.setForeground(new java.awt.Color(32, 61, 74));
        emailField.setText("exemplo@email.com");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        emailField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(48, 63, 56));
        jLabel6.setText("Confirmação de senha :");

        jLabel7.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(48, 63, 56));
        jLabel7.setText("Senha : ");

        senhaField2.setBackground(new java.awt.Color(217, 217, 217));
        senhaField2.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        senhaField2.setForeground(new java.awt.Color(32, 61, 74));
        senhaField2.setText("jPasswordField1");
        senhaField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        senhaField2.setPreferredSize(new java.awt.Dimension(115, 25));

        senhaField1.setBackground(new java.awt.Color(217, 217, 217));
        senhaField1.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        senhaField1.setForeground(new java.awt.Color(32, 61, 74));
        senhaField1.setText("jPasswordField1");
        senhaField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        senhaField1.setPreferredSize(new java.awt.Dimension(115, 25));
        senhaField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaField1ActionPerformed(evt);
            }
        });

        salvarMudancas.setBackground(new java.awt.Color(21, 102, 64));
        salvarMudancas.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        salvarMudancas.setForeground(new java.awt.Color(255, 255, 255));
        salvarMudancas.setText("Salvar");
        salvarMudancas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salvarMudancas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarMudancas.setMargin(new java.awt.Insets(4, 14, 4, 14));
        salvarMudancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarMudancasActionPerformed(evt);
            }
        });

        voltarPerfil.setBackground(new java.awt.Color(21, 102, 64));
        voltarPerfil.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        voltarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        voltarPerfil.setText("Voltar");
        voltarPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        voltarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        voltarPerfil.setMargin(new java.awt.Insets(4, 14, 4, 14));
        voltarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarPerfilActionPerformed(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(64, 86, 76));
        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);

        botaoInicio1.setBackground(new java.awt.Color(205, 255, 232));
        botaoInicio1.setForeground(new java.awt.Color(64, 86, 76));
        botaoInicio1.setText("Início");
        botaoInicio1.setFocusable(false);
        botaoInicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoInicio1.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoInicio1.setOpaque(true);
        botaoInicio1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicio1ActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoInicio1);

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

        botaoHistorico.setBackground(new java.awt.Color(205, 255, 232));
        botaoHistorico.setForeground(new java.awt.Color(64, 86, 76));
        botaoHistorico.setText("Histórico");
        botaoHistorico.setFocusable(false);
        botaoHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoHistorico.setMargin(new java.awt.Insets(4, 14, 4, 14));
        botaoHistorico.setOpaque(true);
        botaoHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHistoricoActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoHistorico);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(senhaField1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senhaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(555, 555, 555)
                        .addComponent(salvarMudancas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(voltarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(52, 52, 52)
                .addComponent(salvarMudancas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void senhaField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaField1ActionPerformed

    private void salvarMudancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarMudancasActionPerformed
        if (ConfirmarSenha()){
            String nome = nomeField.getText();
            String cpf = cpfField.getText().replace(".", "").replace("-", "");
            String telefone = telefoneField.getText();
            String email = emailField.getText();
            if(nome.equals(funcionarioDoPerfil.getNome()) && cpf.equals(funcionarioDoPerfil.getCpf()) && telefone.equals(funcionarioDoPerfil.getTelefone()) && email.equals(funcionarioDoPerfil.getEmail())){
                JOptionPane.showMessageDialog(null, "Altere pelo menos um dos Dados!");
                return;
            }

            
            funcionarioManager.removerFuncionario(funcionarioDoPerfil.getCpf());
            if (funcionarioDoPerfil instanceof Veterinario){
                Veterinario novoFuncionario = new Veterinario(
                cpf, funcionarioDoPerfil.getDataNascimento(), email, nome, telefone, funcionarioDoPerfil.getSenha(), ((Veterinario)funcionarioDoPerfil).getCrmv()
                );
                funcionarioManager.adicionarFuncionario(novoFuncionario);
                funcionarioManager.SalvarFuncionarioLogado(novoFuncionario);
            }
            else{
                Funcionario novoFuncionario = new Funcionario(
                cpf, funcionarioDoPerfil.getDataNascimento(), email, nome, telefone, funcionarioDoPerfil.getSenha()
                );
                funcionarioManager.adicionarFuncionario(novoFuncionario);
                funcionarioManager.SalvarFuncionarioLogado(novoFuncionario);
            }
            JOptionPane.showMessageDialog(null, "Dados Atualizados!");
            this.dispose();
            PerfilFuncionario telaPerfilFuncionario = new PerfilFuncionario();
            telaPerfilFuncionario.setVisible(true);  
        }
        else{
            return;
        }
    }//GEN-LAST:event_salvarMudancasActionPerformed

    private void voltarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPerfilActionPerformed
        this.dispose();
        PerfilFuncionario telaPerfil = new PerfilFuncionario();
        telaPerfil.setVisible(true);
    }//GEN-LAST:event_voltarPerfilActionPerformed

    private void botaoInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicio1ActionPerformed
        this.dispose();
        TelaPrincipal mainScreen = new TelaPrincipal(funcionarioDoPerfil);
        mainScreen.setVisible(true);
    }//GEN-LAST:event_botaoInicio1ActionPerformed

    private void botaoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAnimalActionPerformed
        this.dispose();
        CadastroAnimal animalScreen = new CadastroAnimal(funcionarioDoPerfil);
        animalScreen.setVisible(true);
    }//GEN-LAST:event_botaoAnimalActionPerformed

    private void botaoAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdocaoActionPerformed
        this.dispose();
        FichaAdocao adocaoScreen = new FichaAdocao(funcionarioDoPerfil);
        adocaoScreen.setVisible(true);
    }//GEN-LAST:event_botaoAdocaoActionPerformed

    private void botaoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoActionPerformed
        this.dispose();
        HistoricoFrame historicoScreen = new HistoricoFrame(funcionarioDoPerfil);
        historicoScreen.setVisible(true);
    }//GEN-LAST:event_botaoHistoricoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
        TelaLogin n = new TelaLogin();
        n.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

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
            java.util.logging.Logger.getLogger(EditarPerfilFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPerfilFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfilFunc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdocao;
    private javax.swing.JButton botaoAnimal;
    private javax.swing.JButton botaoHistorico;
    private javax.swing.JButton botaoInicio1;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField emailField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nomeField;
    private javax.swing.JButton salvarMudancas;
    private javax.swing.JPasswordField senhaField1;
    private javax.swing.JPasswordField senhaField2;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JButton voltarPerfil;
    // End of variables declaration//GEN-END:variables
}
