package command;

import data.Worker;
import util.StorageManager;
import util.WorkerDecoder;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public class MinByEndDate implements Command{
    private StorageManager manager;
    private WorkerDecoder decoder;
    MinByEndDate(StorageManager m, WorkerDecoder d){
        manager=m;
        decoder=d;
    }

    @Override
    public void execute(String args) {
        TreeSet<Worker> tmp = new TreeSet<>(manager.getCollection());
        Worker first;
        try {
            first = tmp.first();
        }catch (NoSuchElementException e) {
            System.out.println("collection is empty");
            return;
        }
        for (Worker w:tmp) {
            if (w.getEndDate().compareTo(first.getEndDate()) < 0) {
                first = w;
            }
        }
        decoder.describe(first);
    }

    @Override
    public String description() {
        return "Gives detailed description of worker with minimal value of endDate field\n";
    }
}