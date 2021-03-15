package util;

import data.Worker;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class StorageManager {
    private TreeSet<Worker> storage;
    private boolean isModified=false;
    private ZonedDateTime initTime;

    public StorageManager(){
        storage=new TreeSet<>();
        initTime=ZonedDateTime.now();
    }

    public StorageManager(TreeSet<Worker> externalStorage){
        storage=externalStorage;
        initTime=ZonedDateTime.now();
    }

    public StorageManager(Collection external){
        storage=new TreeSet<Worker>(external);
        initTime=ZonedDateTime.now();
    }

    public Worker getMax(){
        Worker max;
        try {
            max = storage.first();
        }catch (NoSuchElementException e) {
            return null;
        }
        for(Worker w : storage){
            if(max.compareTo(w)>0){
                max=w;
            }
        }
        return max;
    }

    public Worker getMin(){
        Worker min;
        try {
            min = storage.first();
        }catch (NoSuchElementException e) {
            return null;
        }
        for(Worker w : storage){
            if(min.compareTo(w)<0){
                min=w;
            }
        }
        return min;
    }

    public boolean add(Worker w){
        isModified=true;
        return storage.add(w);
    }

    public Worker getById(int id){
        for(Worker w : storage){
           if(w.getId()==id){
               return w;
           }
        }
        return null;
    }

    public boolean remove(Worker w){
        isModified=true;
        return storage.remove(w);
    }
    public void clear()
    {
        isModified=true;
        storage.clear();
    }
    public boolean isModified(){
        return isModified;
    }

    public String[] getInfo(){
        String type = "this is collection of worker type objects";
        String init = "initialized "+initTime.toString();
        String size = "number of elements: "+storage.size();
        String state;
        if(isModified()){
            state="recently modified";
        }
        else{
            state="all changes are saved";
        }
        return new String[]{type,init,size,state};
    }

    public int getMaxId(){
        int maxId;
        try {
            maxId=storage.first().getId();
        }catch (NoSuchElementException e){
            return 0;
        }

        for(Worker w:storage){
            if(w.getId()>maxId){
                maxId=w.getId();
            }
        }
        return maxId;
    }

    public void hasBeenSaved(){
        isModified=false;
    }

    public Collection<Worker> getCollection(){
        return new TreeSet(storage);
    }

    public void load(Collection<Worker> collection){
        storage.addAll(collection);
        isModified=true;
    }
}