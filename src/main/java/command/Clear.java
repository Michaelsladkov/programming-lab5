package command;

import util.StorageManager;

@ThisIsACommand
public class Clear implements Command{
    private final StorageManager storage;

    Clear(StorageManager storage){
        this.storage=storage;
    }
    @Override
    public void execute(String args){
        storage.clear();
        System.out.println("Collection cleared");
    }
}