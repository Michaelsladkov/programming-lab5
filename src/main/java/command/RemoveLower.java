package command;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import util.StorageManager;
import util.WorkerFactory;

public class RemoveLower implements Command{
    private final StorageManager manager;
    private final WorkerFactory factory;
    RemoveLower(StorageManager m, WorkerFactory f){
        manager=m;
        factory=f;
    }

    @Override
    public void execute(String args) {
        try {
            Worker w = factory.readWorkerFromConsole();
            for(Worker collected:manager.getCollection()){
                if(w.compareTo(collected)<0){
                    manager.remove(collected);
                }
            }
            System.out.println("All lower elements have been removed");
        }
        catch (IncorrectValueException| NullFieldException e){
            System.out.println(e.getMessage());
            return;
        }
    }

    @Override
    public String description() {
        return "This command takes worker from console and remove all smaller workers from collection\n";
    }
}
