package command;

import util.StorageManager;
import util.FileWorks;

import java.io.IOException;

@ThisIsACommand
public class Save implements Command {
    private FileWorks fileWorks;
    private StorageManager manager;
    Save( FileWorks f, StorageManager m){
        fileWorks=f;
        manager=m;
    }

    @Override
    public void execute(String args) {
        try {
            fileWorks.saveCollection(manager.getCollection());
            System.out.println("Collection saved successfully");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}