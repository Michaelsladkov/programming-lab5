package command;

import data.IncorrectValueException;
import data.NullFieldException;
import util.StorageManager;
import util.WorkerFactory;

public class Add implements Command{
    private final WorkerFactory factory;
    private final StorageManager manager;
    Add(StorageManager manager, WorkerFactory factory){
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

    @Override
    public String description() {
        return "This command allows you to enter new worker and write it to collection\n" +
                "There are input messages whih will help you to enter all the data\n";
    }
}
