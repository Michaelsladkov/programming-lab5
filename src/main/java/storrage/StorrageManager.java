package main.java.storrage;

import main.java.data.Worker;

import java.util.TreeSet;

public class StorrageManager {
    private final TreeSet<Worker> storage = new TreeSet<>();
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
