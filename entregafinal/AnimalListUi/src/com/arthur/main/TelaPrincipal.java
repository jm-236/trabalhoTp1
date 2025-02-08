
package com.arthur.main;

import com.arthur.event.EventAnimal;
import com.arthur.form.FormHome;
import com.arthur.jsonmanaging.HandleJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.reflect.TypeToken;
import com.iasmim.swing.CadastroAnimal;
import com.joao.model.Adocao;
import com.joao.model.Animal;
import com.joao.model.FichaMedica;
import com.joao.model.Veterinario;
import com.iasmim.swing.FichaAdocao;
import com.iasmim.swing.HistoricoFrame;
import com.iasmim.swing.TelaLogin;
import com.joao.model.Funcionario;
import com.joao.model.Historico;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;



public class TelaPrincipal extends javax.swing.JFrame {
    
    static Point compCoords;
    
    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private Animal animalSelected;
    private HandleJson jsonHandler = new HandleJson();
    private Funcionario funcionarioLogado;
    
    public ArrayList<Animal> listaDeAnimais = new ArrayList<Animal>();
    
    
    
    public TelaPrincipal(Funcionario funcionario) {
        funcionarioLogado = funcionario;
        initComponents();
        init();
        //setBackground(new Color(0, 0, 0, 0));
        //listaDeAnimais = carregarAnimaisDoArquivo();
        
        animator = PropertySetter.createAnimator(500,mainPanel,"imageLocation",animatePoint, mainPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel, "imageSize", new Dimension(180, 120), mainPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        filterTextField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String filterText = filterTextField.getText();
                home.filterAnimals(filterText, ((String)filtroDePesquisa.getSelectedItem()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String filterText = filterTextField.getText();
                home.filterAnimals(filterText, ((String)filtroDePesquisa.getSelectedItem()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
    }
    
    private void init(){
        home = new FormHome(funcionarioLogado);
        //winButton.initEvent(this, background1);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        testData();
        
    }

    private void testData() {
        home.setEvent(new EventAnimal(){
            @Override
            public void animalClick(Component com, Animal item){
                //System.out.println(item.getAnimalID());
                //home.setSelected(com);
                //home.showAnimal(item);
                if (animalSelected != null) {
                    mainPanel.setImageOld(animalSelected.getAnimalImage());
                }
                if (animalSelected != item) {
                    if (!animator.isRunning()) {
                        animalSelected = item;
                        animatePoint = getLocationOf(com);
                        //animatePoint = new Point(500,500);
                        mainPanel.setImage(item.getAnimalImage());
                        mainPanel.setImageLocation(animatePoint);
                        mainPanel.setImageSize(new Dimension(180, 120)); //201,134
                        mainPanel.repaint();
                        home.setSelected(com);
                        home.showAnimal(item);
                        animator.start();
                    }
                }
            }
        });
        this.listaDeAnimais = jsonHandler.carregarAnimaisDoArquivo();
        for (Animal a: listaDeAnimais){
            home.addAnimal(a);
        }
        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i=0;i<=5;i++){
            Animal temp = new Animal(LocalDate.parse("20/01/2004", formatter), "Brasília", "Princesa", "Fêmea","Cachorro",17.5f,"Grande Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet1.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            temp = new Animal(LocalDate.parse("19/02/2005", formatter), "Teresina", "Guto", "Macho","Cachorro",30.5f,"Pequeno Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet2.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            temp = new Animal(LocalDate.parse("18/03/2006", formatter), "Belo Horizonte", "Joto", "Fêmea","Jabuti",67.5f,"Médio Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet3.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            temp = new Animal(LocalDate.parse("17/04/2007", formatter), "Guarulhos", "Mingau", "Macho","Cachorro",12.5f,"Grande Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet4.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            temp = new Animal(LocalDate.parse("16/05/2008", formatter), "São Paulo", "Luigi", "Fêmea","Cachorro",5.5f,"Pequeno Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet5.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            temp = new Animal(LocalDate.parse("15/06/2009", formatter), "Parnaíba", "Fernando", "Macho","Gato",27.5f,"Médio Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet6.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao());
            //listaDeAnimais.add(temp);
            home.addAnimal(temp);
            //salvarAnimaisNoArquivo();
        }*/
    }
    
    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.arthur.swing.Background();
        header = new javax.swing.JPanel();
        filterTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filtroDePesquisa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mainPanel = new com.arthur.swing.MainPanel();
        TopPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        botaoInicio = new javax.swing.JButton();
        botaoAnimal = new javax.swing.JButton();
        botaoAdocao = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(177, 251, 216));

        background1.setBackground(new java.awt.Color(177, 251, 216));
        background1.setOpaque(true);

        header.setBackground(new java.awt.Color(177, 251, 216));

        filterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar:");

        filtroDePesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Espécie", "Raça", "Gênero" }));
        filtroDePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroDePesquisaActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtro:");

        jButton1.setText("Excluir Animal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtroDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtroDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        mainPanel.setBackground(new java.awt.Color(177, 251, 216));
        mainPanel.setOpaque(true);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        TopPanel.setBackground(new java.awt.Color(177, 251, 216));
        TopPanel.setOpaque(false);
        TopPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TopPanelMouseDragged(evt);
            }
        });
        TopPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TopPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TopPanelMouseReleased(evt);
            }
        });

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

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TopPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMousePressed
        compCoords = evt.getPoint();
    }//GEN-LAST:event_TopPanelMousePressed

    private void TopPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseReleased
        compCoords = null;
    }//GEN-LAST:event_TopPanelMouseReleased

    private void TopPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseDragged
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
    }//GEN-LAST:event_TopPanelMouseDragged

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        //this.setVisible(false);

        //inicioForm.setVisible(true);
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAnimalActionPerformed
        this.dispose();
        //close();
        CadastroAnimal cadastroAnimalScreen = new CadastroAnimal(funcionarioLogado);
        cadastroAnimalScreen.setVisible(true);
    }//GEN-LAST:event_botaoAnimalActionPerformed

    private void botaoAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdocaoActionPerformed
        this.dispose();
        FichaAdocao adocaoScreen = new FichaAdocao(funcionarioLogado);
        adocaoScreen.setVisible(true);
    }//GEN-LAST:event_botaoAdocaoActionPerformed

    private void botaoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoActionPerformed
        this.dispose();
        HistoricoFrame historicoScreen = new HistoricoFrame(funcionarioLogado);
        historicoScreen.setVisible(true);
    }//GEN-LAST:event_botaoHistoricoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
        TelaLogin n = new TelaLogin();
        n.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void filterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTextFieldActionPerformed
            
    }//GEN-LAST:event_filterTextFieldActionPerformed

    private void filtroDePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroDePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroDePesquisaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String IDanimal= home.ExcluirAnimal();
        for(Animal animal : listaDeAnimais){
            if(animal.getAnimalID().equals(IDanimal)){
                Historico historico = new Historico(animal, false);
                try {
                    jsonHandler.AddHistoricoNoArquivo(historico);
                } catch (IOException ex) {
                    System.out.println("Erro ao tentar adicionar a exclusão ao histórico.");
                }
                listaDeAnimais.remove(animal);
            }
        }
        jsonHandler.salvarAnimaisNoArquivo(listaDeAnimais);
        home.resetShow();
        mainPanel.setImage(null);
        mainPanel.setImageOld(null);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopPanel;
    private com.arthur.swing.Background background1;
    private javax.swing.JButton botaoAdocao;
    private javax.swing.JButton botaoAnimal;
    private javax.swing.JButton botaoHistorico;
    private javax.swing.JButton botaoInicio;
    private javax.swing.JButton botaoSair;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JComboBox<String> filtroDePesquisa;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar jToolBar1;
    private com.arthur.swing.MainPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
