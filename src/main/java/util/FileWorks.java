package util;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;
import storrage.StorageManager;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class FileWorks {
    private FileWriter outputFile;
    private WorkerDecoder decoder;
    private StorageManager manager;
    private WorkerFactory factory;
    public FileWorks(WorkerDecoder d, StorageManager m, WorkerFactory f)
    {
        decoder=d;
        manager=m;
        factory=f;
    }


    public void saveCollection(Collection<Worker> collection) throws IOException{
        outputFile = new FileWriter("workers.csv");
        if(outputFile==null){
            throw new OutputWasntCreatedException();
        }
        for(Worker w:collection){
            outputFile.write(decoder.getCSVLine(w)+"\n");
        }
        outputFile.close();
        manager.hasBeenSaved();
    }

    public TreeSet<Worker> readCollection(FileReader reader){
        Scanner scanner = new Scanner(reader);
        int lineNumber=0;
        TreeSet<Worker> input=new TreeSet<>();
        while (scanner.hasNext()){
            try {
                input.add(factory.getFromCSV(scanner.nextLine(), ++lineNumber));
            }
            catch (IncorrectFileException e){
                System.out.println(e.getMessage());
            }
            catch (NullFieldException e){
                System.out.println("In line "+lineNumber+e.getMessage());
            }
            catch (IncorrectValueException e){
                System.out.println("In line "+lineNumber+e.getMessage());
            }
        }
        scanner.close();
        try {
            reader.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        return input;
    }
}