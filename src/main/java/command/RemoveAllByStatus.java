package command;

import data.Status;
import data.Worker;
import storrage.StorageManager;
import util.WorkerFactory;

@ThisIsACommand
public class RemoveAllByStatus implements Command{
    private StorageManager manager;
    private WorkerFactory factory;
    RemoveAllByStatus(StorageManager m, WorkerFactory f){
        manager=m;
        factory=f;
    }

    @Override
    public void execute(String args) {
        Status status=null;
        while (status==null){
            System.out.println("Enter one of following states: ");
            for(Status s:Status.values()){
                System.out.println(s.toString());
            }
            try {
                status = Status.valueOf(factory.readLine().toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status=null;
            }
            catch (NullPointerException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status=null;
            }
        }
        for(Worker w:manager.getCollection()){
            if(w.getStatus()==status){
                manager.remove(w);
                System.out.println("id "+w.getId()+" removed");
            }
        }
        if(!manager.isModified()){
            System.out.println("no elements with this status found");
        }
    }
}