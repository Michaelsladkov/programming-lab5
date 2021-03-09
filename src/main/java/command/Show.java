package main.java.command;

import main.java.storrage.StorageManager;

public class Show implements Command {
    private StorageManager s;
    public Show(StorageManager manager){
        s=manager;
    }

    @Override
    public void execute(String args) {

    }
}
