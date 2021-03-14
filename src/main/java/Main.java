
import command.Invoker;
import storrage.StorageManager;
import util.CommandLineListener;
import util.FileWorks;
import util.WorkerDecoder;
import util.WorkerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WorkerFactory workerFactory = new WorkerFactory(0);
        WorkerDecoder decoder = new WorkerDecoder();
        StorageManager manager = new StorageManager();
        Scanner s = new Scanner(System.in);
        workerFactory.setScanner(s);
        FileWorks fileWorks=new FileWorks(decoder, manager, workerFactory);
        Invoker i = new Invoker(manager, workerFactory, decoder, fileWorks);
        CommandLineListener listener = new CommandLineListener(s, i);
        if(args.length!=0){
            try {
                FileReader reader=new FileReader(args[0]);
                manager.load(fileWorks.readCollection(reader));
                workerFactory.setStartId(manager.getMaxId());
            }
            catch (FileNotFoundException e){
                System.out.println("No such file.");
            }
        }
        listener.startRead();
    }
}
