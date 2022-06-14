package com.maledictus;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        Game game = new Game();
        Json writer = new Json();
        writer.jsonWriteMethod();
        game.displaySplash();
        game.getDirection();

    }
}
