package main.java.storrage;

import main.java.data.Worker;

import java.util.Collection;
import java.util.TreeSet;

public class StorageManager {
    private TreeSet<Worker> storage;
    public StorageManager(){
        storage=new TreeSet<>();
    }
    public StorageManager(TreeSet<Worker> externalStorage){
        storage=externalStorage;
    }
    public StorageManager(Collection external){
        storage=new TreeSet<>(external);
    }
    public Worker getMax(){
        Worker max = storage.first();
        for(Worker w : storage){
            if(max.compareTo(w)>0){
                max=w;
            }
        }
        return max;
    }
    public boolean add(Worker w){
        return storage.add(w);
    }
    public Worker searchById(int id){
        for(Worker w : storage){
           if(w.getId()==id){
               return w;
           }
        }
        return null;
    }
    public boolean remove(Worker w){
        return storage.remove(w);
    }
    public void clear(){
        storage.clear();
    }
}
