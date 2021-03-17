
import command.Invoker;
import util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WorkerDecoder decoder = new WorkerDecoder();
        StorageManager manager = new StorageManager();
        Scanner scanner = new Scanner(System.in);
        FieldsReader fieldsReader = new FieldsReader(scanner);
        WorkerFactory workerFactory = new WorkerFactory(0, fieldsReader);
        workerFactory.setScanner(scanner);
        FileWorks fileWorks = new FileWorks(decoder, manager, workerFactory);
        Invoker invoker = new Invoker(manager, workerFactory, decoder, fileWorks, fieldsReader);
        CommandLineListener listener = new CommandLineListener(scanner, invoker);
        if(args.length != 0){
            try {
                FileReader reader=new FileReader(args[0]);
                manager.load(fileWorks.readCollection(reader));
                workerFactory.setStartId(manager.getMaxId());
                System.out.println("Collection read successfully");
            }
            catch (FileNotFoundException e){
                System.out.println("No such file.");
            }
        }
        listener.startRead();
    }
}
