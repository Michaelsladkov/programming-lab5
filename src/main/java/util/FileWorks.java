package util;

import data.IncorrectValueException;
import data.NullFieldException;
import data.Worker;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * This class is responsible for operations with files
 */
public class FileWorks {
    private final WorkerDecoder decoder;
    private final StorageManager manager;
    private final WorkerFactory factory;
    private String outputFilePath = null;

    public FileWorks(WorkerDecoder decoder, StorageManager manager, WorkerFactory factory)
    {
        this.decoder=decoder;
        this.manager=manager;
        this.factory=factory;
    }

    /**
     * writes collection to workers.csv
     * @param collection collection to be written
     * @throws IOException if it is unable to write a file
     */
    public void saveCollection(Collection<Worker> collection) throws IOException{
        FileWriter outputFile;
        if (outputFilePath == null) outputFile = new FileWriter("workers.csv");
        else{
            outputFile=new FileWriter(outputFilePath);
        }
        for(Worker worker:collection){
            outputFile.write(decoder.getCSVLine(worker)+"\n");
        }
        outputFile.close();
        manager.hasBeenSaved();
    }

    /**
     * @param outputFile specify file to be used as output
     */
    public void setOutputFile(String outputFile){
        this.outputFilePath = outputFile;
    }

    /**
     * @param reader csv input file
     * @return collection of worker instances with fields value from the input file
     */
    public TreeSet<Worker> readCollection(FileReader reader){
        Scanner scanner = new Scanner(reader);
        int lineNumber=0;
        TreeSet<Worker> input = new TreeSet<>();
        while (scanner.hasNext()){
            try {
                input.add(factory.getFromCSV(scanner.nextLine(), ++lineNumber));
            }
            catch (IncorrectFileException e){
                System.out.println(e.getMessage());
            }
            catch (NullFieldException | IncorrectValueException e){
                System.out.println("In line "+lineNumber+" "+e.getMessage());
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