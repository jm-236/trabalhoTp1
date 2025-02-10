
package com.arthur.component;

import com.joao.model.Animal;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Item extends javax.swing.JPanel {
    
    private boolean selected;

    
    public Animal getData() {
        return data;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public JLabel getLbAnimalName() {
        return lbAnimalName;
    }

    public JLabel getLbData() {
        return lbData;
    }

    public JLabel getLbGenero() {
        return lbGenero;
    }

    public JLabel getLbIdade() {
        return lbIdade;
    }
    
    
    
    
    
    private Animal data;

    

    
    
    public void setData(Animal data){
        this.data = data;
        pic.setImage(data.getAnimalImage());
        lbAnimalName.setText(data.getAnimalNome());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lbData.setText(data.getAnimalData().format(formatter));
        lbGenero.setText(data.getAnimalGenero());
        lbIdade.setText(Integer.toString(data.calcularIdade()));
        lbEspecie.setText(data.getAnimalEspecie());
        lbRaca.setText(data.getAnimalRaca());
       
    }
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242,242,242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if(selected){
            g2.setColor(new Color(94,156,255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAnimalName = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbIdade = new javax.swing.JLabel();
        lbIdade.setHorizontalAlignment(SwingConstants.RIGHT);
        lbGenero = new javax.swing.JLabel();
        lbRaca = new javax.swing.JLabel();
        lbEspecie = new javax.swing.JLabel();
        pic = new com.arthur.swing.PictureBox();

        setForeground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(210, 229));
        setMinimumSize(new java.awt.Dimension(210, 229));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAnimalName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbAnimalName.setForeground(new java.awt.Color(76, 76, 76));
        lbAnimalName.setText("Nome");
        add(lbAnimalName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 99, -1));

        lbData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(178, 178, 178));
        lbData.setText("Data");
        add(lbData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 96, -1));

        lbIdade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbIdade.setForeground(new java.awt.Color(76, 76, 76));
        lbIdade.setText("0");
        add(lbIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 201, 73, -1));

        lbGenero.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbGenero.setForeground(new java.awt.Color(76, 76, 76));
        lbGenero.setText("Gênero");
        add(lbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 206, 107, -1));

        lbRaca.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbRaca.setForeground(new java.awt.Color(76, 76, 76));
        lbRaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRaca.setText("Raça");
        add(lbRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 38, 95, -1));

        lbEspecie.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbEspecie.setForeground(new java.awt.Color(76, 76, 76));
        lbEspecie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEspecie.setText("Espécie");
        add(lbEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 15, 85, -1));

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/arthur/image/pet1.jpeg"))); // NOI18N
        add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 210, 134));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbAnimalName;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEspecie;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbRaca;
    private com.arthur.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
