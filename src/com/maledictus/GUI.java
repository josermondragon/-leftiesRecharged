package com.maledictus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static GUI instance;
    JTextArea jta;

    public GUI() {
        //Build JFrame
        JFrame frame = new JFrame("Text Frame");
        frame.setLayout(null);
        frame.setSize(500,400);

        Container contentPane = frame.getContentPane();
         jta = textArea();
        contentPane.add(textScrollPane(jta));
//        contentPane.add(buttonAddText(jta));

        //Set Frame Visible
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static GUI getInstance() {
        if(instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    private static JTextArea textArea()
    {
        JTextArea output = new JTextArea();
        output.setLineWrap(true); // Text return to line, so no horizontal scrollbar
        output.setForeground(Color.BLACK);
        output.setBackground(Color.WHITE);

        return output;
    }

    private static JScrollPane textScrollPane(JTextArea jta)
    {
        JScrollPane scrollPane2 = new JScrollPane(jta);
        scrollPane2.setBounds(0, 0, 490, 250);

        return scrollPane2;
    }

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
        jta.insert(string,0);
    }
}