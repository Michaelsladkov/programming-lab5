package command;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import util.StorageManager;
import util.WorkerFactory;
/** AddIfMax command
 * Begins reading worker from console and add it to collection if it is more than maximal element in collection
 */
public class AddIfMax implements Command{
    private StorageManager manager;
    private WorkerFactory factory;

    /**
     * Constructor for this command
     * @param m - receiver, collection manager
     * @param f - factory class for workers
     */
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
        catch (IncorrectValueException|NullFieldException e){
            System.out.println(e.getMessage());
            return;
        }
    }

    @Override
    public String description() {
        return "This command allows you to enter your worker and save it to collection\n" +
                "Saving is only proceeds if entered worker is more than maximal from collection\n";
    }
}