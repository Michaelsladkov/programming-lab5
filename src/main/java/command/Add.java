package command;

import data.IncorrectValueException;
import data.NullFieldException;
import storrage.StorageManager;
import util.WorkerFactory;

@ThisIsACommand
public class Add implements Command{
    private final WorkerFactory factory;
    private final StorageManager manager;
    public Add(StorageManager manager, WorkerFactory factory){
        this.factory=factory;
        this.manager=manager;
    }
    @Override
    public void execute(String args){
        try {
            manager.add(factory.readWorkerFromConsole());
            System.out.println("Worker created");
        }
        catch (IncorrectValueException e){
            System.out.println(e.getMessage());
        }
        catch (NullFieldException e){
            System.out.println(e.getMessage());
        }
    }
}
