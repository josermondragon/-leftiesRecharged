package com.maledictus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePage extends JFrame {


    private JPanel panelWelcome;
    private JLabel title;
    private JButton btnGo;
    private JTextPane youMadeItTheTextPane;
    private static final String IMG_PATH = "resources/data/imageIntro.jpeg";
    private static final String IMG_PATH2 = "resources/data/instructions.png";


    public static void InitImage() {

        try {
            JFrame f = new JFrame();
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 700, 500);
            JButton close = new JButton("Close");
            panel.add(close);
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            JLabel label = new JLabel(new ImageIcon(img));
            panel.add(label);
            panel.setBackground(new Color(0, 0, 0));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane();
            f.setLayout(null);
            f.add(panel);
            f.setSize(700, 500);
            f.setUndecorated(true);                              //remove upper bar
            f.setVisible(true);
            f.getContentPane().setBackground(Color.black);
            f.setLocationRelativeTo(null);                       //center the frame
            close.addActionListener(e -> {
                f.dispose();
            });
            close.setBackground(new Color(0, 0, 0));
            close.setForeground(Color.WHITE);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void Instructions() {
        try {
            JFrame f1 = new JFrame();
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 700, 500);
            JButton close2 = new JButton("Close");
            panel.add(close2);
            BufferedImage img = ImageIO.read(new File(IMG_PATH2));
            JLabel label = new JLabel(new ImageIcon(img));
            panel.add(label);
            panel.setBackground(new Color(221, 221, 221));
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.getContentPane();
            f1.setLayout(null);
            f1.add(panel);
            f1.setUndecorated(true);
            f1.setVisible(true);
            f1.setSize(700, 500);
            f1.getContentPane().setBackground(Color.GRAY);
            f1.setLocationRelativeTo(null);
            close2.addActionListener(e -> {
                f1.dispose();
            });
            close2.setBackground(new Color(221, 221, 221));
            close2.setForeground(Color.BLACK);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}