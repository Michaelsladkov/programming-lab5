package command;

import storrage.StorageManager;

@ThisIsACommand
public class RemoveById implements Command{
    private StorageManager manager;
    RemoveById(StorageManager m){
        manager=m;
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
            return;
        }
    }
}