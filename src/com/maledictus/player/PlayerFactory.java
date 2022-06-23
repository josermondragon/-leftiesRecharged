package com.maledictus.player;

import com.maledictus.Printer;
import com.maledictus.player.Player;
import java.util.Scanner;

public class PlayerFactory {
    public PlayerFactory() {

    }

    public static Player createPlayer() {
        Scanner scanner = new Scanner(System.in);
        Printer.print("Enter your character's name:");
        String name = scanner.nextLine();
        Printer.print("Username is: " + name);

        return new Player(name);
    }

    public static Player createPlayer(String name) {

        Printer.print("Username is: " + name);
        return new Player(name);
    }
}