package main.java.command;

import main.java.storrage.StorrageManager;

public class Clear implements Command{
    private final StorrageManager storage;

    public Clear(StorrageManager storage){
        this.storage=storage;
    }
    @Override
    public void execute(String args){
        storage.clear();
    }
}