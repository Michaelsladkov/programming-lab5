package command;

import storrage.StorageManager;
import util.WorkerDecoder;
import util.WorkerFactory;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    private WorkerFactory factory;
    private WorkerDecoder decoder;
    public boolean isStopRequested=false;
    public Invoker(StorageManager m, WorkerFactory f, WorkerDecoder d){
        commandHashMap=new HashMap<>();
        manager=m;
        factory=f;
        decoder=d;
        initHashMap();
    }

    public void initHashMap(){
        commandHashMap.put("clear", new Clear(manager));
        commandHashMap.put("ping", new Ping());
        commandHashMap.put("add", new Add(manager,factory));
        commandHashMap.put("info", new Info(manager));
        commandHashMap.put("show", new Show(manager,decoder));
        commandHashMap.put("exit", new Exit(this));
    }

    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }
}