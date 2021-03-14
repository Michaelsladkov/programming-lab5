package command;

import data.Worker;
import util.StorageManager;
import util.WorkerDecoder;

import java.util.Collection;

@ThisIsACommand
public class Show implements Command {
    private StorageManager s;
    private WorkerDecoder d;
    Show(StorageManager manager, WorkerDecoder decoder){
        s=manager;
        d=decoder;
    }

    @Override
    public void execute(String args) {
        Collection<Worker> collection=s.getCollection();
        if(collection.size()==0){
            System.out.println("Nothing to show");
        }
        for(Worker w:collection){
            d.describe(w);
        }
    }
}
