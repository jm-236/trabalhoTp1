
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

        lbAnimalName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbAnimalName.setForeground(new java.awt.Color(76, 76, 76));
        lbAnimalName.setText("Nome");

        lbData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(178, 178, 178));
        lbData.setText("Data");

        lbIdade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbIdade.setForeground(new java.awt.Color(76, 76, 76));
        lbIdade.setText("0");

        lbGenero.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbGenero.setForeground(new java.awt.Color(76, 76, 76));
        lbGenero.setText("Gênero");

        lbRaca.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbRaca.setForeground(new java.awt.Color(76, 76, 76));
        lbRaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRaca.setText("Raça");

        lbEspecie.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbEspecie.setForeground(new java.awt.Color(76, 76, 76));
        lbEspecie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEspecie.setText("Espécie");

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/arthur/image/pet1.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAnimalName, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAnimalName)
                    .addComponent(lbEspecie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData)
                    .addComponent(lbRaca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdade)
                    .addComponent(lbGenero))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
