package com.maledictus.client;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.text.ParseException;

import com.maledictus.Game;
import com.maledictus.WelcomePage;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedAudioFileException, LineUnavailableException {
        WelcomePage.InitImage();
        WelcomePage.Instructions();
        Game game = new Game();
        game.initiateGame();


    }
}
