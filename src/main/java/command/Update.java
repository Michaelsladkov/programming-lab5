package command;

import data.IncorrectValueException;
import data.NullFieldException;
import util.StorageManager;
import util.WorkerFactory;

public class Update implements Command{
    private StorageManager manager;
    private WorkerFactory factory;
    Update(StorageManager m, WorkerFactory f){
        manager=m;
        factory=f;
    }

    @Override
    public void execute(String args) {
        if(args.length()==0){
            System.out.println("id is required");
            return;
        }
        int id;
        try{
            id=Integer.parseInt(args);
        } catch (NumberFormatException e){
            System.out.println("Your input is not an id");
            return;
        }
        try {
            manager.remove(manager.getById(id));
        } catch (NullPointerException e){
            System.out.println("No worker with this id found");
            return;
        }
        factory.setStartId(id-1);
        try {
            manager.add(factory.readWorkerFromConsole());
            System.out.println("Worker updated");
        }
        catch (IncorrectValueException e){
            System.out.println(e.getMessage());
            return;
        }
        catch (NullFieldException e){
            System.out.println(e.getMessage());
            return;
        }
        factory.setStartId(manager.getMaxId());
    }
}