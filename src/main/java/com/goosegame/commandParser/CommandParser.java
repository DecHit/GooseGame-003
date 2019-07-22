package com.goosegame.commandParser;


import com.goosegame.constant.Constants;

public class CommandParser {
    String command;

    public CommandParser(String command) {
        this.command = command;
    }

    public CommandParser() {
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public Command parser(String commandString) {
        Command command = new Command();
        String[] parts = commandString.split(" ");
        if (parts.length == 2) {
             if (parts[0].trim().equalsIgnoreCase(Constants.Commands.MOVE.getCommand())) {
                command.setType(Constants.Commands.MOVE);
                command.setPlayerName(parts[1].trim().toLowerCase());
                command.setValid(Boolean.TRUE);
                return command;
            }
        }
        if (parts.length == 3) {
            if (parts[0].trim().equalsIgnoreCase(Constants.Commands.ADD.getCommand())
            && parts[1].trim().equalsIgnoreCase("player")) {
                command.setType(Constants.Commands.ADD);
                command.setPlayerName(parts[2].trim().toLowerCase());
                command.setValid(Boolean.TRUE);
                return command;
            }
        }
        if (parts.length == 4) {
                Integer roll1 = -1;
                Integer roll2 = -1;
                try {
                    roll1 = Integer.parseInt(parts[2].trim().replace(",", ""));
                    roll2 = Integer.parseInt(parts[3].trim());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    command.setErrorMessage("NOT valid roll value");
                    command.setValid(Boolean.FALSE);
                    return command;
                }

                if (parts[0].trim().equalsIgnoreCase(Constants.Commands.MOVE.getCommand())
                        && roll1 > 0 && roll1 < 7
                        && roll2 > 0 && roll2 < 7) {
                    command.setType(Constants.Commands.MOVE_WITH_VALUE);
                    command.setPlayerName(parts[1].trim().toLowerCase());
                    command.setRoll1(roll1);
                    command.setRoll2(roll2);
                    command.setValid(Boolean.TRUE);
                    return command;
                }
            }
            command.setErrorMessage("NOT valid command");
            command.setValid(Boolean.FALSE);
            return command;
        }
    }
