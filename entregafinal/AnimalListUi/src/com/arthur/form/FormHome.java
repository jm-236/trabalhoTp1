/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.arthur.form;

import com.arthur.component.Item;
import com.arthur.event.EventAnimal;
import com.arthur.main.TelaPrincipal;
import com.joao.model.Animal;
import com.arthur.swing.ScrollBar;
import com.iasmim.swing.CriarFichaMedica;
import com.iasmim.swing.HandleJson;
import com.iasmim.swing.ListaFichaVeterinarias;
import com.iasmim.swing.VisualizarAdocao;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.swing.SwingUtilities;
import com.joao.model.Veterinario;
import com.joao.jsonManager.FuncionarioJsonHandler;
import com.joao.model.Funcionario;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class FormHome extends javax.swing.JPanel {

    private EventAnimal event;
    private Animal animal;
    private final Funcionario funcionarioLogado;

    public void setEvent(EventAnimal event) {
        this.event = event;
    }
    public FormHome(Funcionario funcionario) {
        funcionarioLogado = funcionario;
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
    }

    public void addAnimal(Animal data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    //System.out.println(data.getAnimalID());
                    event.animalClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }
    
    public Animal getAnimal() {
        for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        if (((Item) comp).isSelected()){
                            return ((Item) comp).getData();
                        }
                    }
        }
        return null;
        
    }
    
    public String ExcluirAnimal() {
        for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        if (((Item) comp).isSelected()){
                            panelItem.remove(comp);
                            panelItem.repaint();
                            panelItem.revalidate();
                            return ((Item) comp).getData().getAnimalID();
                        }
                    }
        }
        return "";
        
    }
    
    public boolean filtroAdocao(int idxAdocao, Animal animal){
        if(idxAdocao == 0) return true;
        if(idxAdocao == 1 && animal.getAnimalAdocao() == null) return true;
        if(idxAdocao == 2 && !(animal.getAnimalAdocao() == null)) return true;
        return false;
    }
    
    public void filterAnimals(String textfilter, String tipoSelecionado, int adocao) {
        if(textfilter.isEmpty() || textfilter.isBlank()){
            for (Component comp : panelItem.getComponents()){
                if (comp instanceof Item){
                    if (filtroAdocao(adocao, ((Item)comp).getData())){
                        comp.setVisible(true);
                    }
                    else{
                        comp.setVisible(false);
                    }
                }
            }
        }
        if (tipoSelecionado.equals("Nome")){
            if (!textfilter.equals("")){    
                for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        String itemName = ((Item)comp).getData().getAnimalNome();
                        if (itemName.toLowerCase().contains(textfilter.toLowerCase()) && filtroAdocao(adocao, ((Item)comp).getData())){
                            comp.setVisible(true);
                        }
                        else{
                            comp.setVisible(false);
                        }
                    }
                }
            }
        }
        else if (tipoSelecionado.equals("Espécie")){
            if (!textfilter.equals("")){    
                for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        String itemName = ((Item)comp).getData().getAnimalEspecie();
                        if (itemName.toLowerCase().contains(textfilter.toLowerCase()) && filtroAdocao(adocao, ((Item)comp).getData())){
                            comp.setVisible(true);
                        }
                        else{
                            comp.setVisible(false);
                        }
                    }
                }
            }
        }
        else if (tipoSelecionado.equals("Raça")){
            if (!textfilter.equals("")){    
                for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        String itemName = ((Item)comp).getData().getAnimalRaca();
                        if (itemName.toLowerCase().contains(textfilter.toLowerCase()) && filtroAdocao(adocao, ((Item)comp).getData())){
                            comp.setVisible(true);
                        }
                        else{
                            comp.setVisible(false);
                        }
                    }
                }
            }
        }
        else if (tipoSelecionado.equals("Gênero")){
            if (!textfilter.equals("")){    
                for (Component comp : panelItem.getComponents()){
                    if (comp instanceof Item){
                        String itemName = ((Item)comp).getData().getAnimalGenero();
                        if (itemName.toLowerCase().contains(textfilter.toLowerCase()) && filtroAdocao(adocao, ((Item)comp).getData())){
                            comp.setVisible(true);
                        }
                        else{
                            comp.setVisible(false);
                        }
                    }
                }
            }
        }
    }   
    
    
    public void setSelected(Component item){
        for(Component com:panelItem.getComponents()){
            Item i=(Item)com;
            if(i.isSelected()){
                i.setSelected(false);
            }
        }
        ((Item)item).setSelected(true);
    }
    
    public void resetShow(){
        lbAnimalName.setText("Nome do Animal");
        
        
        lbData.setText("Data");
        lbGenero.setText("Gênero");
        lbIdade.setText("Idade:");
        lbRaca.setText("Raça");
        lbPorte.setText("Porte");
        lbLocal.setText("Local:");
        lbPeso.setText("Peso:");
        lbNascimento.setText("Data de Nascimento:");
        lbEspecie.setText("Espécie:");
        lbAdoptionStatus.setText("Status da Adoção");
        lbAdoptionStatus.setForeground(new Color(76,76,76));
    
    
    }
    
    public void showAnimal(Animal data) {
        animal = data;
        lbAnimalName.setText(data.getAnimalNome());
        //txtDescription.setText(data.getDescription());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lbData.setText(data.getAnimalData().format(formatter));
        lbGenero.setText(data.getAnimalGenero());
        lbIdade.setText("Idade: "+ Integer.toString(data.calcularIdade()));
        lbRaca.setText(data.getAnimalRaca());
        lbPorte.setText(data.getAnimalPorte());
        lbLocal.setText("Local: "+data.getAnimalLocal());
        lbPeso.setText("Peso: "+data.getAnimalPeso());
        lbNascimento.setText("Data de Nascimento: "+data.getAnimalDataNascimento());
        lbEspecie.setText("Espécie: "+data.getAnimalEspecie());
        if (data.isAdotado()){
            lbAdoptionStatus.setText("O animal foi adotado por: "+ ((data.getAnimalAdocao()).getAdotante()).getNome());
            lbAdoptionStatus.setForeground(Color.red);
        }
        else{
            lbAdoptionStatus.setText("O animal está disponível para adoção");
            lbAdoptionStatus.setForeground(new Color(87, 54, 247));
        }
    }
    
    
    public Point getPanelItemLocation() {
        Point p = jScrollPane1.getLocation();
        return new Point(p.x, p.y - jScrollPane1.getViewport().getViewPosition().y);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelItem = new com.arthur.swing.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        lbAnimalName = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        lbIdade = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbLocal = new javax.swing.JLabel();
        lbPeso = new javax.swing.JLabel();
        lbPorte = new javax.swing.JLabel();
        lbRaca = new javax.swing.JLabel();
        lbNascimento = new javax.swing.JLabel();
        lbEspecie = new javax.swing.JLabel();
        botaoListFichaVet = new javax.swing.JButton();
        botaoCriarFichaVet = new javax.swing.JButton();
        botaoVisualizarAdocao = new javax.swing.JButton();
        lbAdoptionStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(177, 251, 216));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 86, 76)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelItem.setBackground(new java.awt.Color(177, 251, 216));
        jScrollPane1.setViewportView(panelItem);

        jPanel1.setBackground(new java.awt.Color(177, 251, 216));

        lbAnimalName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbAnimalName.setForeground(new java.awt.Color(76, 76, 76));
        lbAnimalName.setText("Nome do Animal");

        lbData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(178, 178, 178));
        lbData.setText("Data");

        lbGenero.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbGenero.setForeground(new java.awt.Color(76, 76, 76));
        lbGenero.setText("Gênero");

        lbIdade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbIdade.setForeground(new java.awt.Color(76, 76, 76));
        lbIdade.setText("Idade:");

        lbLocal.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbLocal.setForeground(new java.awt.Color(76, 76, 76));
        lbLocal.setText("Local:");

        lbPeso.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbPeso.setForeground(new java.awt.Color(76, 76, 76));
        lbPeso.setText("Peso:");

        lbPorte.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbPorte.setForeground(new java.awt.Color(76, 76, 76));
        lbPorte.setText("Porte");

        lbRaca.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbRaca.setForeground(new java.awt.Color(76, 76, 76));
        lbRaca.setText("Raça");

        lbNascimento.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbNascimento.setForeground(new java.awt.Color(76, 76, 76));
        lbNascimento.setText("Data de Nascimento:");

        lbEspecie.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbEspecie.setForeground(new java.awt.Color(76, 76, 76));
        lbEspecie.setText("Espécie:");

        botaoListFichaVet.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        botaoListFichaVet.setText("Visualizar Fichas Médicas");
        botaoListFichaVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListFichaVetActionPerformed(evt);
            }
        });

        botaoCriarFichaVet.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        botaoCriarFichaVet.setText("Criar Ficha Médica");
        botaoCriarFichaVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarFichaVetActionPerformed(evt);
            }
        });

        botaoVisualizarAdocao.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        botaoVisualizarAdocao.setText("Visualizar adoção");
        botaoVisualizarAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarAdocaoActionPerformed(evt);
            }
        });

        lbAdoptionStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbAdoptionStatus.setForeground(new java.awt.Color(76, 76, 76));
        lbAdoptionStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAdoptionStatus.setText("Status da Adoção");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbEspecie)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbIdade)
                            .addComponent(lbLocal)
                            .addComponent(lbPeso)
                            .addComponent(lbNascimento)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoListFichaVet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoCriarFichaVet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoVisualizarAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbGenero)
                                    .addGap(78, 78, 78)
                                    .addComponent(lbPorte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbAdoptionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPorte, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIdade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEspecie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAdoptionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(botaoListFichaVet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(botaoCriarFichaVet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVisualizarAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        botaoListFichaVet.setVisible(true);
        com.joao.jsonManager.FuncionarioJsonHandler testeVeterinario = new com.joao.jsonManager.FuncionarioJsonHandler();
        if ((testeVeterinario.GetFuncionarioLogado()) instanceof Veterinario){
            botaoCriarFichaVet.setVisible(true);
        }
        else{
            botaoCriarFichaVet.setVisible(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoListFichaVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListFichaVetActionPerformed
        if(!(animal == null)){
            HandleJson jsonHandler = new HandleJson();
            for(Animal animalL : jsonHandler.carregarAnimaisDoArquivo()){
                if(animalL.getAnimalID().equals(animal.getAnimalID())){
                    if(!(animalL.getAnimalFichasMedicas().isEmpty())){
                        ListaFichaVeterinarias fichaScreen = new ListaFichaVeterinarias(funcionarioLogado, animalL);
                        fichaScreen.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Este animal ainda não possui ficha médica.");
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um animal antes de pesquisar fichas médicas.");
        }
    }//GEN-LAST:event_botaoListFichaVetActionPerformed

    private void botaoCriarFichaVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarFichaVetActionPerformed
        if(!(animal == null)){
            CriarFichaMedica fichaVetScreen = new CriarFichaMedica(animal, funcionarioLogado);
            fichaVetScreen.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um animal antes de criar uma ficha médica.");
        }
    }//GEN-LAST:event_botaoCriarFichaVetActionPerformed

    private void botaoVisualizarAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarAdocaoActionPerformed
        // TODO add your handling code here:
        if(!(animal == null)){
            // System.out.println(animal.getAnimalAdocao());
            if (!animal.isAdotado()) {
                JOptionPane.showMessageDialog(null, "Animal selecionado não possui adoção.");
                return;
            }
            
            VisualizarAdocao visualizarAdocao = new VisualizarAdocao(animal, funcionarioLogado);
            visualizarAdocao.setVisible(true);
        }
        else if(animal == null){
            JOptionPane.showMessageDialog(null, "Selecione um animal antes de visualizar adoção.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Este animal não foi adotado ainda.");
        }
    }//GEN-LAST:event_botaoVisualizarAdocaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCriarFichaVet;
    private javax.swing.JButton botaoListFichaVet;
    private javax.swing.JButton botaoVisualizarAdocao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAdoptionStatus;
    private javax.swing.JLabel lbAnimalName;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEspecie;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbNascimento;
    private javax.swing.JLabel lbPeso;
    private javax.swing.JLabel lbPorte;
    private javax.swing.JLabel lbRaca;
    private com.arthur.swing.PanelItem panelItem;
    // End of variables declaration//GEN-END:variables
}
