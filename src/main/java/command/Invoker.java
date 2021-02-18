package main.java.command;

import main.java.storrage.StorageManager;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    public Invoker(){
        commandHashMap=new HashMap<>();
        initHashMap();
    }
    public void initHashMap(){
        manager=new StorageManager();
        commandHashMap.put("clear", new Clear(manager));
    }
    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }
}
