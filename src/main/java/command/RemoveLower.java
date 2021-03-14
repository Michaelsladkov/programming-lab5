package command;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import storrage.StorageManager;
import util.WorkerFactory;

@ThisIsACommand
public class RemoveLower implements Command{
    private StorageManager manager;
    private WorkerFactory factory;
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
        catch (IncorrectValueException e){
            System.out.println(e.getMessage());
            return;
        }
        catch (NullFieldException e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
