package com.goosegame.gamePlay;

import com.goosegame.cell.Cell;
import com.goosegame.commandParser.Command;
import com.goosegame.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePlay {

    List<Integer> gooseCells= Stream.of(5, 9, 14, 18, 23, 27).collect(Collectors.toList());
    Integer bridge=6;
    List<Player> players=new ArrayList<Player>();

    public GamePlay() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addplayer(String playerName){

        Player player=new Player();
        player.setName(playerName);
        player.setCells(new Cell(0));
        if(!players.stream().anyMatch(p->p.getName().equalsIgnoreCase(playerName))) {
            players.add(player);
            System.out.println("Player: "+ player.getName());
        }else{
            System.out.println("Player already exists");
        }
    }

    public boolean moveplayer(Player player, Integer roll1, Integer roll2,boolean printRolls) {


            Integer tempcell = player.getCells().getPosition() + roll1 + roll2;

            tempcell = tempcell > 63 ? tempcell = 63 - (tempcell - 63) : tempcell;
            String movement = null;

            final Integer finalcell = tempcell;

            Optional<Player> playertomove = players.stream().filter(p -> p.getCells().getPosition() == finalcell).findFirst();

            if (checkbridge(tempcell)) {
                Integer oldcell = tempcell;
                tempcell = tempcell + 6;
                movement = oldcell + " ,The Bridge. " + player.getName() + " jumps to " + tempcell;
            }
            if (checkgoofe(tempcell)) {
                Integer oldcell = tempcell;
                tempcell = tempcell + roll1 + roll2;
                movement = oldcell + " ,The Goose. " + player.getName() + " moves again and goes to " + tempcell;
            }

            if (playertomove.isPresent()) {
                Integer oldcell = tempcell;
                playertomove.get().setCells(new Cell(player.getCells().getPosition()));
                System.out.println("On "+oldcell+" there is "+playertomove.get().getName()+" who returns to "+ player.getCells().getPosition());

            }
            Integer oldPos = player.getCells().getPosition();
            player.setCells(new Cell(tempcell));

            if (tempcell == 63) {
                System.out.println(player.getName() + " WIN!");
                return true;
            }
            String rolls = printRolls ? " roll " + roll1 + " " + roll2 : " ";
            movement = movement == null ? tempcell.toString() : movement;
            System.out.println(player.getName() + rolls + " move from  " + oldPos + " to " + movement);
            return false;
        }


    public boolean checkbridge(Integer cell){
        return cell==bridge;
    }

    public boolean checkgoofe(Integer cell){
        return gooseCells.stream().anyMatch(c -> c==cell);
    }

    public boolean excuteCommand(Command command){
        if(command.isValid()){
            switch (command.getType().getValue()){
                case 0:{
                    addplayer(command.getPlayerName());

                    break;
                }
                case 1:{
                    Optional<Player> player=checkValidPlayer(command.getPlayerName());
                    if(player.isPresent()){
                       return  moveplayer(player.get(),rollDice(),rollDice(),true);
                    }
                    break;
                }
                case 2:{
                    Optional<Player> player=checkValidPlayer(command.getPlayerName());
                    if(player.isPresent()){
                        return moveplayer(player.get(),command.getRoll1(),command.getRoll2(),false);
                    }
                    break;
                }
                default:
                {
                  break;
                }
            }

        }
        else{
            System.out.println(command.getErrorMessage());
        }
        return false;
    }

    public Integer rollDice(){
        Integer min =1;
        Integer max=6;
        Random random=new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public Optional<Player> checkValidPlayer(String playerName){
        return players.stream().filter(p -> p.getName().equalsIgnoreCase(playerName)).findFirst();
    }
}
