package command;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import util.StorageManager;
import util.WorkerFactory;

@ThisIsACommand
public class AddIfMin implements Command{
    private StorageManager manager;
    private WorkerFactory factory;
    AddIfMin(StorageManager m, WorkerFactory f){
        manager=m;
        factory=f;
    }

    @Override
    public void execute(String args) {
        try {
            Worker w = factory.readWorkerFromConsole();
            if(w.compareTo(manager.getMin())>0){
                manager.add(w);
                System.out.println("Worker added");
            } else {
                System.out.println("Your worker isn't less than max from collection");
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
