/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iasmim.swing;

import com.joao.jsonManager.FuncionarioDAO;
import com.joao.model.Funcionario;
import com.joao.model.Veterinario;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author iasmimqf
 */
public class CadastroFuncionario extends javax.swing.JFrame {
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Creates new form CadastroFuncionario
     */
    public CadastroFuncionario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nomeFuncionarioField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefoneField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        senhaIIField = new javax.swing.JPasswordField();
        senhaIField = new javax.swing.JPasswordField();
        isVeterinarioCheckbox = new javax.swing.JCheckBox();
        crmvField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cadastrarButton = new javax.swing.JButton();
        ocultarSenhaCheckbox = new javax.swing.JCheckBox();
        nascimentoField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(177, 251, 216));

        jPanel1.setBackground(new java.awt.Color(177, 251, 216));

        jToolBar1.setBackground(new java.awt.Color(64, 86, 76));
        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);

        jButton2.setBackground(new java.awt.Color(205, 255, 232));
        jButton2.setForeground(new java.awt.Color(64, 86, 76));
        jButton2.setText("Início");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(4, 14, 4, 14));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        loginButton.setBackground(new java.awt.Color(205, 255, 232));
        loginButton.setForeground(new java.awt.Color(64, 86, 76));
        loginButton.setText("Login");
        loginButton.setFocusable(false);
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.setMargin(new java.awt.Insets(4, 14, 4, 14));
        loginButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(loginButton);

        jLabel1.setBackground(new java.awt.Color(64, 86, 76));
        jLabel1.setFont(new java.awt.Font("Lato Semibold", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        nomeFuncionarioField.setBackground(new java.awt.Color(217, 217, 217));
        nomeFuncionarioField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        nomeFuncionarioField.setForeground(new java.awt.Color(32, 61, 74));
        nomeFuncionarioField.setText("Nome Completo");
        nomeFuncionarioField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        nomeFuncionarioField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        nomeFuncionarioField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomeFuncionarioFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeFuncionarioFieldFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 63, 56));
        jLabel2.setText("Nome : ");

        cpfField.setBackground(new java.awt.Color(217, 217, 217));
        cpfField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        cpfField.setForeground(new java.awt.Color(32, 61, 74));
        cpfField.setText("000.000.000-00");
        cpfField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        cpfField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        cpfField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cpfFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cpfFieldFocusLost(evt);
            }
        });
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
        telefoneField.setText("(99) 99999-9999");
        telefoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        telefoneField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        telefoneField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefoneFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefoneFieldFocusLost(evt);
            }
        });

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
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
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

        senhaIIField.setBackground(new java.awt.Color(217, 217, 217));
        senhaIIField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        senhaIIField.setForeground(new java.awt.Color(32, 61, 74));
        senhaIIField.setText("Senha");
        senhaIIField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        senhaIIField.setPreferredSize(new java.awt.Dimension(115, 25));

        senhaIField.setBackground(new java.awt.Color(217, 217, 217));
        senhaIField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        senhaIField.setForeground(new java.awt.Color(32, 61, 74));
        senhaIField.setText("Senha");
        senhaIField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        senhaIField.setPreferredSize(new java.awt.Dimension(115, 25));
        senhaIField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaIFieldActionPerformed(evt);
            }
        });

        isVeterinarioCheckbox.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        isVeterinarioCheckbox.setForeground(new java.awt.Color(32, 61, 74));
        isVeterinarioCheckbox.setText("Veterinário");
        isVeterinarioCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isVeterinarioCheckboxActionPerformed(evt);
            }
        });

        crmvField.setBackground(new java.awt.Color(217, 217, 217));
        crmvField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        crmvField.setForeground(new java.awt.Color(32, 61, 74));
        crmvField.setText("000.000.000-00");
        crmvField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        crmvField.setEnabled(false);
        crmvField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        crmvField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                crmvFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                crmvFieldFocusLost(evt);
            }
        });
        crmvField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crmvFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(48, 63, 56));
        jLabel8.setText("CRMV :");

        cadastrarButton.setBackground(new java.awt.Color(21, 102, 64));
        cadastrarButton.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        cadastrarButton.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarButton.setText("Cadastrar");
        cadastrarButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cadastrarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastrarButton.setMargin(new java.awt.Insets(4, 14, 4, 14));
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        ocultarSenhaCheckbox.setForeground(new java.awt.Color(32, 61, 74));
        ocultarSenhaCheckbox.setSelected(true);
        ocultarSenhaCheckbox.setText("Ocultar senha");
        ocultarSenhaCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarSenhaCheckboxActionPerformed(evt);
            }
        });

        nascimentoField.setBackground(new java.awt.Color(217, 217, 217));
        nascimentoField.setFont(new java.awt.Font("Lato", 2, 18)); // NOI18N
        nascimentoField.setForeground(new java.awt.Color(32, 61, 74));
        nascimentoField.setText("00/00/0000");
        nascimentoField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 86, 76), 1, true));
        nascimentoField.setMargin(new java.awt.Insets(4, 15, 4, 15));
        nascimentoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nascimentoFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nascimentoFieldFocusLost(evt);
            }
        });
        nascimentoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nascimentoFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lato Semibold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(48, 63, 56));
        jLabel9.setText("Nascimento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
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
                                .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(senhaIField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senhaIIField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(isVeterinarioCheckbox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeFuncionarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(crmvField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ocultarSenhaCheckbox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeFuncionarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
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
                    .addComponent(senhaIField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ocultarSenhaCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaIIField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addComponent(isVeterinarioCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crmvField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        TelaLogin mainframe = new TelaLogin();
        mainframe.setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void senhaIFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaIFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaIFieldActionPerformed

    private void isVeterinarioCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isVeterinarioCheckboxActionPerformed
        // TODO add your handling code here:
        if (!isVeterinarioCheckbox.isSelected()) {
            crmvField.setEnabled(false);
            crmvField.setText("000.000.000-00");
        } else {
            crmvField.setEnabled(true); 
        }
    }//GEN-LAST:event_isVeterinarioCheckboxActionPerformed

    private void crmvFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crmvFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crmvFieldActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // TODO add your handling code here:
        try{
            System.out.println("Botão de cadastrar funcionário clicado!");
            String nome = nomeFuncionarioField.getText();
            if (nome.equals("") || nome.equals("Nome Completo")){
                JOptionPane.showMessageDialog(null, "O nome não pode ser vazio!");
                return;
            }
            String cpf = cpfField.getText();
            LocalDate dataNascimento = LocalDate.parse(nascimentoField.getText(), 
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String telefone = telefoneField.getText();
            String email = emailField.getText();
            String senhaI = new String(senhaIField.getPassword());
            String senhaII = new String(senhaIIField.getPassword());
            System.out.println(senhaI + " " + senhaII);
            if (!senhaI.equals(senhaII)){
                JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
                return;
            }
            if (funcionarioDAO.buscarFuncionario(cpf).orElse(null) != null){
                JOptionPane.showMessageDialog(null, "Já existe um usuário com este CPF!");
                return;
            }
            if (isVeterinarioCheckbox.isSelected()){
                String crmv = crmvField.getText();
                Veterinario veterinario = new Veterinario(cpf, dataNascimento, email
                , nome, telefone, senhaI, crmv);
                funcionarioDAO.adicionarFuncionario(veterinario);
                JOptionPane.showConfirmDialog(null, "Novo veterinário cadastrado com sucesso!\n"
                + veterinario);
            } else {
                Funcionario funcionario = new Funcionario(cpf, dataNascimento, email,
                nome, telefone, senhaI);
                funcionarioDAO.adicionarFuncionario(funcionario);
                JOptionPane.showConfirmDialog(null, "Novo funcionário cadastrado com sucesso!\n"
                + funcionario);     
            }
            
            this.setVisible(false);
            TelaLogin mainframe = new TelaLogin();
            mainframe.setVisible(true);
        } catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida!\n"
                    + "A data deve ser escrita no formato dd/MM/yyyy");
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void nomeFuncionarioFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFuncionarioFieldFocusGained
        // TODO add your handling code here:
        if (nomeFuncionarioField.getText().equals("Nome Completo")) {
            nomeFuncionarioField.setText("");
        }
    }//GEN-LAST:event_nomeFuncionarioFieldFocusGained

    private void nomeFuncionarioFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFuncionarioFieldFocusLost
        // TODO add your handling code here:
        if (nomeFuncionarioField.getText().isEmpty()) {
            nomeFuncionarioField.setText("Nome Completo");
        }
    }//GEN-LAST:event_nomeFuncionarioFieldFocusLost

    private void cpfFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfFieldFocusGained
        // TODO add your handling code here:
        if (cpfField.getText().equals("000.000.000-00")) {
            cpfField.setText("");
        }
    }//GEN-LAST:event_cpfFieldFocusGained

    private void cpfFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfFieldFocusLost
        // TODO add your handling code here:
        if (cpfField.getText().isEmpty()) {
            cpfField.setText("000.000.000-00");
        }
    }//GEN-LAST:event_cpfFieldFocusLost

    private void telefoneFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefoneFieldFocusGained
        // TODO add your handling code here:
        if (telefoneField.getText().equals("(99) 99999-9999")) {
            telefoneField.setText("");
        }
    }//GEN-LAST:event_telefoneFieldFocusGained

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        // TODO add your handling code here:
        if (emailField.getText().equals("exemplo@email.com")) {
            emailField.setText("");
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        // TODO add your handling code here:
        if (emailField.getText().isEmpty()) {
            emailField.setText("exemplo@email.com");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void telefoneFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefoneFieldFocusLost
        // TODO add your handling code here:
        if (telefoneField.getText().isEmpty()) {
            telefoneField.setText("(99) 99999-9999");
        }
    }//GEN-LAST:event_telefoneFieldFocusLost

    private void ocultarSenhaCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarSenhaCheckboxActionPerformed
        // TODO add your handling code here:
         if (!ocultarSenhaCheckbox.isSelected()) {
                    senhaIField.setEchoChar((char) 0); 
                    senhaIIField.setEchoChar((char) 0); 
                } else {
                    senhaIField.setEchoChar('*'); 
                    senhaIIField.setEchoChar('*');
                }
    }//GEN-LAST:event_ocultarSenhaCheckboxActionPerformed

    private void crmvFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_crmvFieldFocusGained
        // TODO add your handling code here:
        if (crmvField.getText().equals("000.000.000-00") && isVeterinarioCheckbox.isSelected()) {
            crmvField.setText("");
        }
    }//GEN-LAST:event_crmvFieldFocusGained

    private void crmvFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_crmvFieldFocusLost
        // TODO add your handling code here:
        if (crmvField.getText().isEmpty()) {
            crmvField.setText("000.000.000-00");
        }
    }//GEN-LAST:event_crmvFieldFocusLost

    private void nascimentoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nascimentoFieldFocusGained
        // TODO add your handling code here:
        if (nascimentoField.getText().equals("00/00/0000")) {
            nascimentoField.setText("");
        }
    }//GEN-LAST:event_nascimentoFieldFocusGained

    private void nascimentoFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nascimentoFieldFocusLost
        // TODO add your handling code here:
        if (nascimentoField.getText().isEmpty()) {
            nascimentoField.setText("00/00/0000");
        }
    }//GEN-LAST:event_nascimentoFieldFocusLost

    private void nascimentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nascimentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nascimentoFieldActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField crmvField;
    private javax.swing.JTextField emailField;
    private javax.swing.JCheckBox isVeterinarioCheckbox;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nascimentoField;
    private javax.swing.JTextField nomeFuncionarioField;
    private javax.swing.JCheckBox ocultarSenhaCheckbox;
    private javax.swing.JPasswordField senhaIField;
    private javax.swing.JPasswordField senhaIIField;
    private javax.swing.JTextField telefoneField;
    // End of variables declaration//GEN-END:variables

}
