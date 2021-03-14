package command;

import data.Worker;
import util.StorageManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

@ThisIsACommand
public class PrintFieldDescendingSalary implements Command{
    private StorageManager manager;
    PrintFieldDescendingSalary(StorageManager m){
        manager=m;
    }

    @Override
    public void execute(String args) {
        ArrayList<Long> salaries=new ArrayList<>();
        for(Worker w:manager.getCollection()){
            salaries.add(w.getSalary());
        }
        salaries.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1<o2){
                    return 1;
                }
                if(o1>o2){
                    return -1;
                }
                return 0;
            }
        });
        for(long a:salaries){
            System.out.println(a);
        }
    }
}
