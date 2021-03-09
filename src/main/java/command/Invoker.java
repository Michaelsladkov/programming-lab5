package main.java.command;

import main.java.storrage.StorageManager;
import main.java.util.CommandLineListener;
import main.java.util.WorkerFactory;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    private WorkerFactory factory;
    public Invoker(StorageManager m, WorkerFactory f){
        commandHashMap=new HashMap<>();
        manager=m;
        factory=f;
        initHashMap();
    }

    public void initHashMap(){
        commandHashMap.put("clear", new Clear(manager));
        commandHashMap.put("ping", new Ping());
        commandHashMap.put("add", new Add(manager,factory));
        commandHashMap.put("info", new Info(manager));
    }

    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }


}