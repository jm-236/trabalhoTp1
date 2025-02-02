
package com.arthur.main;

import com.arthur.event.EventAnimal;
import com.arthur.form.FormHome;
import com.joao.model.Adocao;
import com.joao.model.Animal;
import com.joao.model.FichaMedica;
import com.joao.model.Veterinario;
import com.iasmim.swing.FichaAdocao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Main extends javax.swing.JFrame {
    
    static Point compCoords;
    
    //Mouse shenenigans
    
    
    
    
    
    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private Animal animalSelected;
    
    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
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
    }
    
    private void init(){
        home = new FormHome();
        winButton.initEvent(this, background1);
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
        int ID=1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i=0;i<=5;i++){
            home.addAnimal(new Animal(ID++,LocalDate.parse("20/01/2004", formatter), "Brasília", "Princesa", "Fêmea","Especie",17.5f,"Grande Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet1.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
            home.addAnimal(new Animal(ID++,LocalDate.parse("19/02/2005", formatter), "Teresina", "Guto", "Macho","Especie",30.5f,"Pequeno Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet2.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
            home.addAnimal(new Animal(ID++,LocalDate.parse("18/03/2006", formatter), "Belo Horizonte", "Joto", "Fêmea","Especie",67.5f,"Médio Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet3.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
            home.addAnimal(new Animal(ID++,LocalDate.parse("17/04/2007", formatter), "Guarulhos", "Mingau", "Macho","Especie",12.5f,"Grande Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet4.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
            home.addAnimal(new Animal(ID++,LocalDate.parse("16/05/2008", formatter), "São Paulo", "Luigi", "Fêmea","Especie",5.5f,"Pequeno Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet5.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
            home.addAnimal(new Animal(ID++,LocalDate.parse("15/06/2009", formatter), "Parnaíba", "Fernando", "Macho","Especie",27.5f,"Médio Porte", new ImageIcon(getClass().getResource("/com/arthur/image/pet6.jpeg")), "raça", LocalDate.now(),new FichaMedica(LocalDateTime.now(), "diagnostico", "tratamento", new Veterinario("cpf",new Date(),"email","nome","telefone",1,"senha",2)), new Adocao()));
        }
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
        CadastrarAnimalButton = new javax.swing.JButton();
        mainPanel = new com.arthur.swing.MainPanel();
        TopPanel = new javax.swing.JPanel();
        winButton = new com.arthur.swing.win_button.WinButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setOpaque(false);

        CadastrarAnimalButton.setText("Cadastrar um Animal");
        CadastrarAnimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarAnimalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CadastrarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(981, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addComponent(CadastrarAnimalButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void CadastrarAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarAnimalButtonActionPerformed
        this.setVisible(false);
        //close();
        FichaAdocao adocaoScreen = new FichaAdocao(this);
        adocaoScreen.setVisible(true);
    }//GEN-LAST:event_CadastrarAnimalButtonActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarAnimalButton;
    private javax.swing.JPanel TopPanel;
    private com.arthur.swing.Background background1;
    private javax.swing.JPanel header;
    private com.arthur.swing.MainPanel mainPanel;
    private com.arthur.swing.win_button.WinButton winButton;
    // End of variables declaration//GEN-END:variables
}
