package main.java.storrage;

import main.java.data.Worker;

import java.util.TreeSet;

public class StorrageManager {
    private TreeSet<Worker> storrage = new TreeSet<>();
    public Worker getMax(){
        Worker max = storrage.first();
        for(Worker w : storrage){
            if(max.compareTo(w)>0){
                max=w;
            }
        }
        return max;
    }
    public boolean add(Worker w){
        return storrage.add(w);
    }
    public Worker searchById(int id){
        for(Worker w : storrage){
           if(w.getId()==id){
               return w;
           }
        }
        return null;
    }
    public boolean remove(Worker w){
        return storrage.remove(w);
    }
    public void clear(){
        storrage.clear();
    }
}
