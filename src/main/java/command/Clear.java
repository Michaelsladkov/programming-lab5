package main.java.command;

import main.java.storrage.StorageManager;

public class Clear implements Command{
    private final StorageManager storage;

    public Clear(StorageManager storage){
        this.storage=storage;
    }
    @Override
    public void execute(String args){
        storage.clear();
    }
}