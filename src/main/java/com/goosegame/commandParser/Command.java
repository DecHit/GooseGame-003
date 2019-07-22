package com.goosegame.commandParser;


import com.goosegame.constant.Constants;

public class Command {
    private Constants.Commands type;
    private String PlayerName;
    private Integer roll1;
    private Integer roll2;
    private boolean valid;
    private String errorMessage;

    public Command() {

    }

    public Constants.Commands getType() {
        return type;
    }

    public void setType(Constants.Commands type) {
        this.type = type;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public Integer getRoll1() {
        return roll1;
    }

    public void setRoll1(Integer roll1) {
        this.roll1 = roll1;
    }

    public Integer getRoll2() {
        return roll2;
    }

    public void setRoll2(Integer roll2) {
        this.roll2 = roll2;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
