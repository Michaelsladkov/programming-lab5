package main.java.command;

import main.java.storrage.StorageManager;
import main.java.util.CommandLineListener;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    private CommandLineListener listener;
    public Invoker(StorageManager m){
        commandHashMap=new HashMap<>();
        manager=m;
        initHashMap();
    }

    public void initHashMap(){
        commandHashMap.put("clear", new Clear(manager));
        commandHashMap.put("ping", new Ping());
    }

    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }

    public void setListener(CommandLineListener l){
        listener=l;
    }
}