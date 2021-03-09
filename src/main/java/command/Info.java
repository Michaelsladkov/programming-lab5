package main.java.command;

import main.java.storrage.StorageManager;

public class Info implements Command {
    private StorageManager s;
    public Info(StorageManager manager){
        s=manager;
    }

    @Override
    public void execute(String args) {
        for(String line:s.getInfo()){

        }
    }
}
