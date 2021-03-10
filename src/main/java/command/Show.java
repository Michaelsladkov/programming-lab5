package main.java.command;

import main.java.data.Worker;
import main.java.storrage.StorageManager;
import main.java.util.WorkerDecoder;

import java.util.Collection;

public class Show implements Command {
    private StorageManager s;
    private WorkerDecoder d;
    public Show(StorageManager manager, WorkerDecoder decoder){
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
