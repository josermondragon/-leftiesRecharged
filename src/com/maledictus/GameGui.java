package com.maledictus;

import javax.swing.*;
import java.awt.*;


public class GameGui extends JFrame  {

    // grid to setup our frame


    public static void MainFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame fj = new JFrame("MALEDICTUS... Cuz some things have to be done right...no left...");
        fj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fj.setSize(500, 300);
        fj.setLocationRelativeTo(null);
        GridBagConstraints abc = new GridBagConstraints();
        abc.fill = GridBagConstraints.HORIZONTAL;

        //panel1 that holds name (label and text field), btn for map and instructions
        JPanel panel1 = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel1.setLayout(layout);

        //game
        JLabel game = new JLabel("Game: ");
        JTextArea inputtedGame = new JTextArea(10,20);
        abc.gridx = 0;
        abc.gridy = 0;
        panel1.add(game,abc);
        abc.gridx = 0;
        abc.gridy = 1;
        panel1.add(inputtedGame,abc);

        //user input
        JLabel userInput = new JLabel("Type here your option or command: ");
        JTextField inputtedUser = new JTextField("...",15);
        abc.gridx = 0;
        abc.gridy = 2;
        panel1.add(userInput,abc);
        abc.gridx = 0;
        abc.gridy = 3;
        panel1.add(inputtedUser,abc);

        //utilities like map(btn), instructions(btn), command(img) and options(img)
        ImageIcon commands = new ImageIcon("-leftiesRecharged/resources/data/commands.png");
        JLabel showImage = new JLabel(commands);
        ImageIcon options = new ImageIcon("-leftiesRecharged/resources/data/commands.png");
        JLabel showImage2 = new JLabel(options);
        abc.gridx = 30;
        abc.gridy = 1;
        panel1.add(showImage,abc);
        abc.gridx = 60;
        abc.gridy = 1;
        panel1.add(showImage2,abc);






        //button for map and instructions
        JButton map = new JButton("map");
        JButton instructions = new JButton("instructions");
        abc.gridx = 30;
        abc.gridy = 2;
        panel1.add(map,abc);
        //map.addActionListener(e -> buttonPressed());
        abc.gridx = 60;
        abc.gridy = 2;
        panel1.add(instructions,abc);
        instructions.addActionListener(e -> buttonPressed());



        //add panel to frame and make it visible
        fj.add(panel1);
        fj.setVisible(true);

    }


    static void buttonPressed() {
        WelcomePage.Instructions();

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }


    //    public static void main(String[] args) {
//        LayoutFrame layoutFrame=new LayoutFrame();
//        MainFrame();
//
//    }
}