package com.goosegame.player;


import com.goosegame.cell.Cell;

public class Player {

    String name;
    Cell cell;

    public Player() {
    }

    public Player(String name, Cell cells) {
        this.name = name;
        this.cell = cells;
    }

    public String getName() {
        return name;
    }

    public Cell getCells() {
        return cell;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCells(Cell cells) {
        this.cell = cells;
    }




}
