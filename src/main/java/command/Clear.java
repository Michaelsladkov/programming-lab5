package command;

import util.StorageManager;

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

    @Override
    public String description() {
        return "This command clears the collection\n";
    }
}