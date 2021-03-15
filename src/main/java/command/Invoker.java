package command;

import util.StorageManager;
import util.FileWorks;
import util.WorkerDecoder;
import util.WorkerFactory;

import java.util.HashMap;
import java.util.TreeSet;

public class Invoker {
    private HashMap<String, Command> commandHashMap;
    private StorageManager manager;
    private WorkerFactory factory;
    private WorkerDecoder decoder;
    private FileWorks fileWorks;
    private boolean isStopRequested=false;
    private final Class[] allowedToStop = {Exit.class};
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
        commandHashMap.put("add_if_max", new AddIfMax(manager,factory));
        commandHashMap.put("add_if_min", new AddIfMin(manager, factory));
        commandHashMap.put("remove_lower", new RemoveLower(manager, factory));
        commandHashMap.put("remove_all_by_status", new RemoveAllByStatus(manager, factory));
        commandHashMap.put("min_by_end_date", new MinByEndDate(manager,decoder));
        commandHashMap.put("print_field_descending_salary", new PrintFieldDescendingSalary(manager));
        commandHashMap.put("execute_script", new ExecuteScript(this));
        commandHashMap.put("help", new Help(this.commandHashMap));
    }

    public void execute(String name, String args) throws NullPointerException{
        commandHashMap.get(name).execute(args);
    }

    public void requestExit(Object requester){
        for(Class c:allowedToStop){
            if(c.equals(requester.getClass())){
                isStopRequested=true;
                break;
            }
        }
    }

    public boolean isStopRequested(){
        return isStopRequested;
    }
}