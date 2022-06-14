package com.maledictus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.parser.*;

public class Game {


    int direction;


    public void displaySplash() {

        boolean play = true;


        String titleBanner = null;
        try {
            titleBanner = Files.readString(Path.of("data/splash_banner.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(titleBanner);
        System.out.println("Welcome to Maledictus.  A game created by Lefties.\n");

        while (play) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select [1] to start game.");
            System.out.println("Select [2] to quit game.\n>>>");
            String startGame = scanner.nextLine();

            if (startGame.equals("1")) {
                displayIntroText();
                play = false;
            } else if (startGame.equals("2")) {
                System.out.println("Exiting the game...");
                System.exit(1);
            } else {
                System.out.println("Invalid Selection.  Please enter [1] to start game or [2] to quit.\n>>>");
            }
        }
    }


    public void displayIntroText() {
        System.out.println("\nYou made it, the castle looks old and abandoned, but is an immaculate piece of architecture. There is an uneasy feeling in the air, a rush of\n" +
                "wind picks up the leaves around you. Will you be the first to claim King Berengars treasure? Or will you join the cursed souls that linger\n" +
                "within...\n");
    }

    public void getDirection() throws IOException, ParseException, java.text.ParseException {

        //this will be the json read method
        //refactor this so that a method will return the room values to avoid redundancy



//        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
//        JSONObject jo = (JSONObject) obj;
//
//
//        String room0 = (String) jo.get("room0");
//        String room0Description = (String) jo.get("room0Description");
//
//        String room1 = (String) jo.get("room1");
//        String room1Description = (String) jo.get("room1Description");
//
//        String room2 = (String) jo.get("room2");
//        String room2Description = (String) jo.get("room2Description");
//
//        String room3 = (String) jo.get("room3");
//        String room3Description = (String) jo.get("room3Description");
//
//        String room4 = (String) jo.get("room4");
//        String room4Description = (String) jo.get("room4Description");
//
//        String room5 = (String) jo.get("room5");
//        String room5Description = (String) jo.get("room5Description");
//
//        String room6 = (String) jo.get("room6");
//        String room6Description = (String) jo.get("room6Description");
//
//        String room7 = (String) jo.get("room7");
//        String room7Description = (String) jo.get("room7Description");
//
//        String room8 = (String) jo.get("room8");
//        String room8Description = (String) jo.get("room8Description");
//
//        String room9 = (String) jo.get("room9");
//        String room9Description = (String) jo.get("room9Description");
//
//        String room10 = (String) jo.get("room10");
//        String room10Description = (String) jo.get("room10Description");
//
//        String room11 = (String) jo.get("room11");
//        String room11Description = (String) jo.get("room11Description");
//
//        String room12 = (String) jo.get("room12");
//        String room12Description = (String) jo.get("room12Description");




        ArrayList<Room> map = new ArrayList<>();
        Json reader = new Json();


        map.add(new Room(reader.returnRoomName("0"), reader.returnRoomDescription("0"), 3, 0, 0, 1));
        //0

        map.add(new Room(reader.returnRoomName("1"), reader.returnRoomDescription("1"), 2, 1, 0, 1));
        //1
        map.add(new Room(reader.returnRoomName("2"),  reader.returnRoomDescription("2"), 2, 1, 2, 2));
        //2
        map.add(new Room(reader.returnRoomName("3"), reader.returnRoomDescription("3"), 4, 0, 3, 3));
        //3
        map.add(new Room(reader.returnRoomName("4"), reader.returnRoomDescription("4"), 4, 3, 4, 4));
        //4
        map.add(new Room(reader.returnRoomName("5"), reader.returnRoomDescription("5"), 6, 5, 7, 0));
        //5
        map.add(new Room(reader.returnRoomName("6"), reader.returnRoomDescription("6"), 6, 5, 6, 6));
        //6
        map.add(new Room(reader.returnRoomName("7"), reader.returnRoomDescription("7"), 9, 8, 7, 5));
        //7
        map.add(new Room(reader.returnRoomName("8"), reader.returnRoomDescription("8"), 7, 8, 8, 8));
        //8
        map.add(new Room(reader.returnRoomName("9"), reader.returnRoomDescription("9"), 9, 9, 7, 10));
        //9
        map.add(new Room(reader.returnRoomName("10"), reader.returnRoomDescription("10"), 11, 10, 9, 12));
        //10
        map.add(new Room(reader.returnRoomName("11"), reader.returnRoomDescription("11"), 11, 10, 11, 11));
        //11
        map.add(new Room(reader.returnRoomName("12"), reader.returnRoomDescription("12"), 12, 12, 10, 12));
        //12


        Room currentRoom = map.get(0); //sets the current room to the great hall(0) for initial start of game

        System.out.println(currentRoom.toString());
        System.out.println("\nAvailable commands:\n[go north]\n[go west]\n[go south]\n");

        boolean round = true;
        while (round) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a command or enter [options] to see game options: \n>>>");
            String userCommand = scanner.nextLine();

            if (userCommand.equalsIgnoreCase("options")){
                displayOptions();
            }
            if (direction == 0){ //great hall

            switch(userCommand.toLowerCase()) {
                case "go north":
                    direction = 3;
                    break;
                case "go east":
                    direction = 1;
                    break;
                case "go west":
                    direction = 5;
                    break;
                }
            }

            else if (direction == 1){ //dining room
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 2; //kitchen
                        break;
                    case "go west":
                        direction = 0; //great hall
                        break;
                }
            }

            else if (direction ==2){ //Kitchen
                switch(userCommand.toLowerCase()) {
                    case "go south":
                        direction = 1; //dining room
                        break;
                }
            }

            else if (direction == 3){ //Courtyard
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 4; //ball room
                        break;
                    case "go south":
                        direction = 0; //great hall
                        break;
                }
            }

            else if (direction == 4){ //Ball room
                switch(userCommand.toLowerCase()) {
                    case "go south":
                        direction = 3; //courtyard
                        break;
                }
            }

            else if (direction == 5){ //Great Hall hallway
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 6; //guard room
                        break;
                    case "go west":
                        direction = 7; //library
                        break;
                    case "go east":
                        direction = 0; //great hall
                        break;
                }
            }

            else if (direction == 6){ //Guard room
                switch(userCommand.toLowerCase()) {
                    case "go south":
                        direction = 5; //great hall hallway
                        break;
                }
            }

            else if (direction == 7){ //Library
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 9; //foyer
                        break;
                    case "go east":
                        direction = 5; //great hall hallway
                        break;
                    case "go south":
                        direction = 8; //secret room
                }
            }

            else if (direction == 8){ //Secret room
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 7; //library
                        break;
                }
            }

            else if (direction ==9){ //Foyer
                switch(userCommand.toLowerCase()) {
                    case "go east":
                        direction = 10; //kitchen
                        break;
                    case "go west":
                        direction = 7; //library
                        break;
                }
            }

            else if (direction == 10){ //Dungeon
                switch(userCommand.toLowerCase()) {
                    case "go north":
                        direction = 11; //cellar
                        break;
                    case "go west":
                        direction = 9; //foyer
                        break;
                    case "go east":
                        direction = 12; //crypt
                        break;
                }
            }

            else if (direction == 11){ //Cellar
                switch(userCommand.toLowerCase()) {
                    case "go south":
                        direction = 10; //dungeon
                        break;
                }
            }

            else if (direction == 12){ //Crypt
                switch(userCommand.toLowerCase()) {
                    case "go east":
                        direction = 10; //dungeon
                        break;
                }
            }

            currentRoom = map.get(direction);
            System.out.println(currentRoom.toString());


            switch (direction) {
                case 0: //great hall
                    System.out.println("\nAvailable commands:\n[go north]\n[go west]\n[go east]\n");

                    //combat encounter method called
                    //getting items logic called --> item added to list/map whatever the case may be
                    //approach npc method called --> json file for npc dialogue is read
                    break;
                case 1: //dining room
                    System.out.println("\nAvailable commands:\n[go north]\n[go west]\n");
                    break;
                case 2: //kitchen
                    System.out.println("\nAvailable commands:\n[go south]\n");
                    break;
                case 3: //courtyard
                    System.out.println("\nAvailable commands:\n[go south]\n[go north]\n");
                    break;
                case 4://Ballroom
                    System.out.println("\nAvailable commands:\n[go south]\n");
                    break;
                case 5://Great Hall Hallway
                    System.out.println("\nAvailable commands:\n[go north]\n[go west]\n[go east]\n");
                    break;
                case 6://Guard room
                    System.out.println("\nAvailable commands:\n[go south]\n");
                    break;
                case 7://Library
                    System.out.println("\nAvailable commands:\n[go south]\n[go north]\n[go east]\n");
                    break;
                case 8://Secret room
                    System.out.println("\nAvailable commands:\n[go north]\n");
                    break;
                case 9://Foyer
                    System.out.println("\nAvailable commands:\n[go east]\n[go south]\n");
                    break;
                case 10://Dungeon
                    System.out.println("\nAvailable commands:\n[go north]\n[go east]\n[go west]\n");
                    break;
                case 11://Cellar
                    System.out.println("\nAvailable commands:\n[go south]\n");
                    break;
                case 12://Crypt
                    System.out.println("\nAvailable commands:\n[go west]\n");
                    break;
            }
            //SET THE ROUND TO FALSE IF PLAYER HP <= 0 TO BREAK THE LOOP
        }
    }

    public void displayOptions() {
        boolean waitingOnInput = true;
        while (waitingOnInput) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Press [1] to start a new game.\nPress [2] to quit.\nPress [3] for game info.\nPress [4] to resume game.");
            String optionInput = scanner.nextLine();
            if (optionInput.equals("1")) {
                displaySplash(); //starts a new game
                waitingOnInput = false;
            } else if (optionInput.equals("2")) {
                System.out.println("Exiting game.  Thank you for playing.");
                System.exit(1);
            }
            else if (optionInput.equals("3")) {
                System.out.println("Maledictus is a console text-adventure game.  You are a treasure hunter is seek of riches.  Your goal is to traverse the map, discover what lies within, and make it out alive!\nGame created by team Lefties: Ryan Mosser, Michael Herman, and Nikko Colby\n");
            }
            else if (optionInput.equals("4")){
                break; //resumes current game
            }
            else {
                System.out.println("Invalid Selection.  Please try again.");
            }
        }
    }

}