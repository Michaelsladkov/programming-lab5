package command;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import util.StorageManager;
import util.WorkerFactory;

@ThisIsACommand
public class AddIfMax implements Command{
    private StorageManager manager;
    private WorkerFactory factory;
    AddIfMax(StorageManager m, WorkerFactory f){
        manager=m;
        factory=f;
    }

    @Override
    public void execute(String args) {
        try {
            Worker w = factory.readWorkerFromConsole();
            if(w.compareTo(manager.getMax())<0){
                manager.add(w);
                System.out.println("Worker added");
            } else {
                System.out.println("Your worker isn't greater than max from collection");
            }
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
