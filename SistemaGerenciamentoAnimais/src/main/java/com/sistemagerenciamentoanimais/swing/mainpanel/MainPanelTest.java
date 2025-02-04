package com.sistemagerenciamentoanimais.swing.mainpanel;
import javax.swing.*;

public class MainPanelTest {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Main Panel Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                MainPanel mainPanel = new MainPanel();
                frame.add(mainPanel);

                frame.setVisible(true);
            }
        });
    }
}
