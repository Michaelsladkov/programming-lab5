package main.java.command;

import main.java.storrage.StorrageManager;

import java.util.HashMap;

public class Invoker {
    private final HashMap<String, Command> commandHashMap = new HashMap<>();
    private StorrageManager manager;
    public void initHashMap(){
        manager=new StorrageManager();
        commandHashMap.put("clear", new Clear(manager));
    }
    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }
}
