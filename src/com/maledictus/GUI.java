package com.maledictus;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static GUI instance;
//    TODO: make this a JTextPane
    private JTextPane jta;

    public GUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame fj = new JFrame("MALEDICTUS... Cuz some things have to be done right...no left...");
        fj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fj.setSize(900, 800);
        fj.setLocationRelativeTo(null);

        GridBagConstraints abc = new GridBagConstraints();
        abc.fill = GridBagConstraints.HORIZONTAL;

        //panel1 that holds name (label and text field), btn for map and instructions
        JPanel panel1 = new JPanel(new BorderLayout());

        GridBagLayout layout = new GridBagLayout();

        panel1.setLayout(layout);

        //game
        JLabel game = new JLabel("Game: ");
        jta = new JTextPane();
        jta.setEditable(false);
//        jta.setLineWrap(true);
        abc.gridx = 0;
        abc.gridy = 0;
        panel1.add(game,abc);
        abc.gridx = 0;
        abc.gridy = 1;
//        panel1.add(textScrollPane(jta),abc);
        panel1.add(textScrollPane(jta), abc);
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


    public static GUI getInstance() {
        if(instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    private static JTextArea textArea() {
        JTextArea output = new JTextArea();
        output.setLineWrap(true); // Text return to line, so no horizontal scrollbar
        output.setForeground(Color.BLACK);
        output.setBackground(Color.WHITE);

        return output;
    }

    private static JScrollPane textScrollPane(JTextPane jta) {
        JScrollPane scrollPane = new JScrollPane(jta);
        scrollPane.setBounds(0, 0, 500, 500);
        scrollPane.getViewport().setViewPosition(new Point(0,0));
        return scrollPane;
    }

    static void buttonPressed() {
        WelcomePage.Instructions();

    }

//    public static void MainFrame() {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JFrame fj = new JFrame("MALEDICTUS... Cuz some things have to be done right...no left...");
//        fj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fj.setSize(500, 300);
//        fj.setLocationRelativeTo(null);
//        GridBagConstraints abc = new GridBagConstraints();
//        abc.fill = GridBagConstraints.HORIZONTAL;
//
//        //panel1 that holds name (label and text field), btn for map and instructions
//        JPanel panel1 = new JPanel();
//        GridBagLayout layout = new GridBagLayout();
//        panel1.setLayout(layout);
//
//        //game
//        JLabel game = new JLabel("Game: ");
//        JTextArea inputtedGame = new JTextArea(10,20);
//        abc.gridx = 0;
//        abc.gridy = 0;
//        panel1.add(game,abc);
//        abc.gridx = 0;
//        abc.gridy = 1;
//        panel1.add(inputtedGame,abc);
//
//        //user input
//        JLabel userInput = new JLabel("Type here your option or command: ");
//        JTextField inputtedUser = new JTextField("...",15);
//        abc.gridx = 0;
//        abc.gridy = 2;
//        panel1.add(userInput,abc);
//        abc.gridx = 0;
//        abc.gridy = 3;
//        panel1.add(inputtedUser,abc);
//
//        //utilities like map(btn), instructions(btn), command(img) and options(img)
//        ImageIcon commands = new ImageIcon("-leftiesRecharged/resources/data/commands.png");
//        JLabel showImage = new JLabel(commands);
//        ImageIcon options = new ImageIcon("-leftiesRecharged/resources/data/commands.png");
//        JLabel showImage2 = new JLabel(options);
//        abc.gridx = 30;
//        abc.gridy = 1;
//        panel1.add(showImage,abc);
//        abc.gridx = 60;
//        abc.gridy = 1;
//        panel1.add(showImage2,abc);
//
//        //button for map and instructions
//        JButton map = new JButton("map");
//        JButton instructions = new JButton("instructions");
//        abc.gridx = 30;
//        abc.gridy = 2;
//        panel1.add(map,abc);
//        //map.addActionListener(e -> buttonPressed());
//        abc.gridx = 60;
//        abc.gridy = 2;
//        panel1.add(instructions,abc);
//        instructions.addActionListener(e -> buttonPressed());
//
//
//
//        //add panel to frame and make it visible
//        fj.add(panel1);
//        fj.setVisible(true);
//
//    }

//    private static JButton buttonAddText(JTextArea jta)
//    {
//        jta.insert("TEXT",0);
//        JButton testbutton = new JButton("TEST");
//        testbutton.setBounds(20, 280, 138, 36);
//
//        testbutton.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                //action listener here
//                jta.insert("TEXT",0);
//                System.out.println("Button Tested!");
//            }
//        });
//
//        return testbutton;
//    }

    public void buttonAddText(String string) {
        try {
            jta.getDocument().insertString(0,string,null);
        } catch (BadLocationException exp) {
            System.out.println(exp);
        }
    }
}