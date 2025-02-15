
package com.arthur.main;

import com.arthur.event.EventAnimal;
import com.arthur.form.FormHome;
import com.arthur.jsonmanaging.HandleJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.reflect.TypeToken;
import com.iasmim.swing.CadastroAnimal;
import com.iasmim.swing.EditarAnimal;
import com.joao.model.Adocao;
import com.joao.model.Animal;
import com.joao.model.FichaMedica;
import com.joao.model.Veterinario;
import com.iasmim.swing.FichaAdocao;
import com.iasmim.swing.HistoricoFrame;
import com.iasmim.swing.PerfilFuncionario;
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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
                //throw new UnsupportedOperationException("Not supported yet, filtroDeAdocao.getSelectedIndex()."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String filterText = filterTextField.getText();
                home.filterAnimals(filterText, ((String)filtroDePesquisa.getSelectedItem()), filtroDeAdocao.getSelectedIndex());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String filterText = filterTextField.getText();
                home.filterAnimals(filterText, ((String)filtroDePesquisa.getSelectedItem()), filtroDeAdocao.getSelectedIndex());
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
        mainPanel = new com.arthur.swing.MainPanel();
        TopPanel = new javax.swing.JPanel();
        botaoPerfil = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        botaoAnimal = new javax.swing.JButton();
        botaoAdocao = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botaoSair = new javax.swing.JButton();
        filtroDePesquisa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        filterTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filtroDeAdocao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(177, 251, 216));

        background1.setBackground(new java.awt.Color(177, 251, 216));
        background1.setOpaque(true);

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
            .addGap(0, 568, Short.MAX_VALUE)
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

        botaoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iasmim/image/user.png"))); // NOI18N
        botaoPerfil.setOpaque(true);
        botaoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPerfilActionPerformed(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(64, 86, 76));
        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);

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

        filtroDePesquisa.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        filtroDePesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Espécie", "Raça", "Gênero" }));
        filtroDePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroDePesquisaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jLabel2.setText("Filtro de Pesquisa:");

        filterTextField.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        filterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jLabel1.setText("Pesquisar:");

        jButton2.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jButton2.setText("Editar Animal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jButton1.setText("Excluir Animal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        header.setBackground(new java.awt.Color(177, 251, 216));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jLabel4.setText("Filtro de Adoção:");

        filtroDeAdocao.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        filtroDeAdocao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Não Adotados", "Adotados" }));
        filtroDeAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroDeAdocaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(filtroDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroDeAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(botaoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TopPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroDePesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                            .addGroup(TopPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filterTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TopPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TopPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtroDeAdocao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TopPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseReleased
        compCoords = null;
    }//GEN-LAST:event_TopPanelMouseReleased

    private void TopPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMousePressed
        compCoords = evt.getPoint();
    }//GEN-LAST:event_TopPanelMousePressed

    private void TopPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseDragged
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
    }//GEN-LAST:event_TopPanelMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String IDanimal= home.ExcluirAnimal();

        Iterator<Animal> iterator = listaDeAnimais.iterator();

        while (iterator.hasNext()) {
            Animal animal = iterator.next(); // Obtém o próximo elemento
            if (animal.getAnimalID().equals(IDanimal)) {
                Historico historico = new Historico(animal, false);
                iterator.remove(); // Remove o animal da lista
                try {
                    jsonHandler.AddHistoricoNoArquivo(historico);
                } catch (IOException ex) {
                    System.out.println("Erro ao tentar adicionar a exclusão ao histórico.");
                }
            }
        }
        //        for(Animal animal : listaDeAnimais){
            //            if(animal.getAnimalID().equals(IDanimal)){
                //                Historico historico = new Historico(animal, false);
                //                listaDeAnimais.remove(animal);
                //                try {
                    //                    jsonHandler.AddHistoricoNoArquivo(historico);
                    //                } catch (IOException ex) {
                    //                    System.out.println("Erro ao tentar adicionar a exclusão ao histórico.");
                    //                }
                //            }
            //        }
        System.out.println(listaDeAnimais.size());
        jsonHandler.salvarAnimaisNoArquivo(listaDeAnimais);
        home.resetShow();
        mainPanel.setImage(null);
        mainPanel.setImageOld(null);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Animal animal = home.getAnimal();
        if(animal == null){
            JOptionPane.showMessageDialog(null, "Nenhum animal foi selecionado.");
        }
        else{
            this.dispose();
            EditarAnimal editPetScreen = new EditarAnimal(animal, funcionarioLogado);
            editPetScreen.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void filterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTextFieldActionPerformed

    }//GEN-LAST:event_filterTextFieldActionPerformed

    private void filtroDePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroDePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroDePesquisaActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
        TelaLogin n = new TelaLogin();
        n.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoActionPerformed
        this.dispose();
        HistoricoFrame historicoScreen = new HistoricoFrame(funcionarioLogado);
        historicoScreen.setVisible(true);
    }//GEN-LAST:event_botaoHistoricoActionPerformed

    private void botaoAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdocaoActionPerformed
        this.dispose();
        FichaAdocao adocaoScreen = new FichaAdocao(funcionarioLogado);
        adocaoScreen.setVisible(true);
    }//GEN-LAST:event_botaoAdocaoActionPerformed

    private void botaoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAnimalActionPerformed
        this.dispose();
        CadastroAnimal animalScreen = new CadastroAnimal(funcionarioLogado);
        animalScreen.setVisible(true);
    }//GEN-LAST:event_botaoAnimalActionPerformed

    private void botaoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPerfilActionPerformed
        this.dispose();
        //close();
        PerfilFuncionario perfilFuncionarioScreen = new PerfilFuncionario();
        perfilFuncionarioScreen.setVisible(true);
    }//GEN-LAST:event_botaoPerfilActionPerformed

    private void filtroDeAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroDeAdocaoActionPerformed
        String filterText = filterTextField.getText();
        home.filterAnimals(filterText, ((String)filtroDePesquisa.getSelectedItem()), filtroDeAdocao.getSelectedIndex());
    }//GEN-LAST:event_filtroDeAdocaoActionPerformed


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
    private javax.swing.JButton botaoPerfil;
    private javax.swing.JButton botaoSair;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JComboBox<String> filtroDeAdocao;
    private javax.swing.JComboBox<String> filtroDePesquisa;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToolBar jToolBar1;
    private com.arthur.swing.MainPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
