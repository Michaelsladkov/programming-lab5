package command;

import util.StorageManager;

public class Info implements Command {
    private StorageManager s;
    Info(StorageManager manager){
        s=manager;
    }

    @Override
    public void execute(String args) {
        for(String line:s.getInfo()){
            System.out.println(line);
        }
    }
}
