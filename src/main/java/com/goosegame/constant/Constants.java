package com.goosegame.constant;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public List<Integer> bridge=new ArrayList<Integer>();

    public List<Integer> goose=new ArrayList<Integer>();


    public enum Commands{
        ADD("add",0), MOVE("move",1),MOVE_WITH_VALUE("move",2);

        String command;
        Integer value;
        Commands(String com ,Integer val)
        {
            this.command=com;
            this.value=val;
        }

        public String getCommand() {
            return command;
        }

        public Integer getValue() {
            return value;
        }
    }


}
