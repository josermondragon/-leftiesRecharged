package com.maledictus;

import javax.swing.*;
import java.io.PrintStream;

public class Printer {

    public static GUI gui = GUI.getInstance();

    public static void print(Object string) {
        String obj = string.toString();
        gui.buttonAddText(obj);
//        gui.MainFrame();
        System.out.println(string);
    }

}