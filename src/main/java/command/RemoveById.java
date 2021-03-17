package command;

import util.StorageManager;

public class RemoveById implements Command{
    private final StorageManager manager;
    RemoveById(StorageManager storageManager){
        manager=storageManager;
    }

    @Override
    public void execute(String args) {
        if(args.length()==0){
            System.out.println("id is required");
            return;
        }
        int id;
        try{
            id=Integer.parseInt(args);
        } catch (NumberFormatException e){
            System.out.println("Your input is not an id");
            return;
        }
        try {
            manager.remove(manager.getById(id));
            System.out.println("Element removed");
        } catch (NullPointerException e){
            System.out.println("No worker with this id found");
        }
    }

    @Override
    public String description() {
        return "This command gets worker id and remove worker with that id from collection\n";
    }
}