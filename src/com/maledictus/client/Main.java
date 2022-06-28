package com.maledictus.client;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.text.ParseException;

import com.maledictus.GUI;
import com.maledictus.Game;
import com.maledictus.WelcomePage;
import com.maledictus.music.GameMusic;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedAudioFileException, LineUnavailableException {
        //Game game = new Game();

        GameMusic gameMusic = new GameMusic();
        GameMusic.playMusic();

        //game.initiateGame();
        GUI giu = new GUI();
        WelcomePage.InitImage();











    }
}
