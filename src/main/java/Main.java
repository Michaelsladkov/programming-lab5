
import command.Invoker;
import storrage.StorageManager;
import util.CommandLineListener;
import util.FileWorks;
import util.WorkerDecoder;
import util.WorkerFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WorkerFactory workerFactory = new WorkerFactory(0);
        WorkerDecoder decoder = new WorkerDecoder();
        StorageManager manager = new StorageManager();
        Scanner s = new Scanner(System.in);
        workerFactory.setScanner(s);
        FileWorks fileWorks=new FileWorks(decoder);
        Invoker i = new Invoker(manager, workerFactory, decoder, fileWorks);
        CommandLineListener listener = new CommandLineListener(s, i);
        listener.startRead();
    }
}
