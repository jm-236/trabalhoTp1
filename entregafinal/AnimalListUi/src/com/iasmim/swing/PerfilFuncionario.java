/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iasmim.swing;

import com.arthur.main.TelaPrincipal;
import com.joao.jsonManager.FuncionarioDAO;
import com.joao.model.Funcionario;
import com.joao.model.Veterinario;
import javax.swing.JOptionPane;

/**
 *
 * @author iasmimqf
 */
public class PerfilFuncionario extends javax.swing.JFrame {

    private Funcionario funcionarioDoPerfil;
    private FuncionarioDAO funcionarioManager;
    
    public PerfilFuncionario() {
        initComponents();
        setLocationRelativeTo(null);
        this.funcionarioManager = new FuncionarioDAO();
        this.funcionarioDoPerfil = funcionarioManager.GetFuncionarioLogado();
        MostrarDados();
        
    }

    public void MostrarDados(){
        nomeField.setText(funcionarioDoPerfil.getNome());
        cpfField.setText(funcionarioDoPerfil.getCpf());
        jTextField3.setText(funcionarioDoPerfil.getTelefone());
        emailField.setText(funcionarioDoPerfil.getEmail());
        if (funcionarioDoPerfil instanceof Veterinario){
            crmvField.setText(((Veterinario)(funcionarioDoPerfil)).getCrmv());
        }
        else{
            crmvField.setText("Apenas para veterinários");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telefoneField = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        crmvField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        excluirConta = new javax.swing.JButton();
        editarPerfil = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        botaoInicio1 = new javax.swing.JButton();
        botaoAnimal = new javax.swing.JButton();
        botaoAdocao = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        telefoneField.setBackground(new java.awt.Color(177, 251, 216));

        jLabel1.setBackground(new java.awt.Color(64, 86, 76));
        jLabel1.setFont(new java.awt.Font("Lato Semibold", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Meu Perfil");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        nomeField.setEditable(false);
        nomeField.setBackground(new java.awt.Color(240, 255, 250));
        nomeField.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        nomeField.setForeground(new java.awt.Color(48, 63, 56));
        nomeField.setText("Nome Completo do Funcionário");
        nomeField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        nomeField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 63, 56));
        jLabel2.setText("Nome : ");

        cpfField.setEditable(false);
        cpfField.setBackground(new java.awt.Color(240, 255, 250));
        cpfField.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        cpfField.setForeground(new java.awt.Color(48, 63, 56));
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

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(240, 255, 250));
        jTextField3.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(48, 63, 56));
        jTextField3.setText("(00) 99824 - 4353");
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        jTextField3.setMargin(new java.awt.Insets(4, 15, 4, 15));

        jLabel4.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(48, 63, 56));
        jLabel4.setText("Telefone : ");

        jLabel5.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(48, 63, 56));
        jLabel5.setText("E-mail :");

        emailField.setEditable(false);
        emailField.setBackground(new java.awt.Color(240, 255, 250));
        emailField.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        emailField.setForeground(new java.awt.Color(48, 63, 56));
        emailField.setText("exemplo@email.com");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        emailField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        crmvField.setEditable(false);
        crmvField.setBackground(new java.awt.Color(240, 255, 250));
        crmvField.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        crmvField.setForeground(new java.awt.Color(48, 63, 56));
        crmvField.setText("000.000.000-00");
        crmvField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        crmvField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        crmvField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crmvFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(48, 63, 56));
        jLabel8.setText("CRMV :");

        excluirConta.setBackground(new java.awt.Color(21, 102, 64));
        excluirConta.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        excluirConta.setForeground(new java.awt.Color(255, 255, 255));
        excluirConta.setText("Excluir");
        excluirConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        excluirConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirConta.setMargin(new java.awt.Insets(4, 14, 4, 14));
        excluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirContaActionPerformed(evt);
            }
        });

        editarPerfil.setBackground(new java.awt.Color(21, 102, 64));
        editarPerfil.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        editarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        editarPerfil.setText("Editar");
        editarPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarPerfil.setMargin(new java.awt.Insets(4, 14, 4, 14));
        editarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPerfilActionPerformed(evt);
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

        javax.swing.GroupLayout telefoneFieldLayout = new javax.swing.GroupLayout(telefoneField);
        telefoneField.setLayout(telefoneFieldLayout);
        telefoneFieldLayout.setHorizontalGroup(
            telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telefoneFieldLayout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(crmvField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telefoneFieldLayout.createSequentialGroup()
                        .addComponent(editarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206)))
                .addGap(157, 157, 157)
                .addComponent(excluirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        telefoneFieldLayout.setVerticalGroup(
            telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telefoneFieldLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telefoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crmvField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addComponent(editarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telefoneField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telefoneField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void excluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirContaActionPerformed
        String senhaInserida = JOptionPane.showInputDialog("Se está certo que quer fazer isso, insira a senha:");
        if (senhaInserida.equals(funcionarioDoPerfil.getSenha())){
            JOptionPane.showMessageDialog(null,"Conta apagada com sucesso.");
            this.dispose();
            funcionarioManager.removerFuncionario(funcionarioDoPerfil.getCpf());
            funcionarioManager.limparDadosAoEncerrar();
            TelaLogin n = new TelaLogin();
            n.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null,"Senha Incorreta.");
        }
    }//GEN-LAST:event_excluirContaActionPerformed

    private void crmvFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crmvFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crmvFieldActionPerformed

    private void editarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPerfilActionPerformed
        this.dispose();
        EditarPerfilFunc telaEdicaoPerfil = new EditarPerfilFunc();
        telaEdicaoPerfil.setVisible(true);
    }//GEN-LAST:event_editarPerfilActionPerformed

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

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

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
            java.util.logging.Logger.getLogger(PerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilFuncionario().setVisible(true);
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
    private javax.swing.JTextField crmvField;
    private javax.swing.JButton editarPerfil;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton excluirConta;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nomeField;
    private javax.swing.JPanel telefoneField;
    // End of variables declaration//GEN-END:variables
}
