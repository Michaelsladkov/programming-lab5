package command;

import storrage.StorageManager;
import util.FileWorks;
import util.WorkerDecoder;
import util.WorkerFactory;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    private WorkerFactory factory;
    private WorkerDecoder decoder;
    private FileWorks fileWorks;
    public boolean isStopRequested=false;
    public Invoker(StorageManager m, WorkerFactory f, WorkerDecoder d, FileWorks fw){
        commandHashMap=new HashMap<>();
        manager=m;
        factory=f;
        decoder=d;
        fileWorks=fw;
        initHashMap();
    }

    public void initHashMap(){
        commandHashMap.put("clear", new Clear(manager));
        commandHashMap.put("ping", new Ping());
        commandHashMap.put("add", new Add(manager,factory));
        commandHashMap.put("info", new Info(manager));
        commandHashMap.put("show", new Show(manager,decoder));
        commandHashMap.put("exit", new Exit(this));
        commandHashMap.put("save", new Save(fileWorks, manager));
        commandHashMap.put("update", new Update(manager,factory));
        commandHashMap.put("remove_by_id", new RemoveById(manager));
    }

    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }
}