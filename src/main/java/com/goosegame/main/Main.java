package com.goosegame.main;


import com.goosegame.commandParser.Command;
import com.goosegame.commandParser.CommandParser;
import com.goosegame.gamePlay.GamePlay;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the Goose game!");
        System.out.println("Start adding some players");

        boolean finished=false;
        GamePlay game=new GamePlay();
        CommandParser parser=new CommandParser();

        while(!finished){
            String line=scanner.nextLine();
            Command command=parser.parser(line);
            finished=game.excuteCommand(command);
        }


    }



}
