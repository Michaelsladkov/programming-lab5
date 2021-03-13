package util;

import data.Worker;

import java.io.*;
import java.util.Collection;
import java.util.TreeSet;

public class FileWorks {
    private FileWriter outputFile;
    private WorkerDecoder decoder;
    public FileWorks(WorkerDecoder d)
    {
        decoder=d;
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
    }

    /*public TreeSet<Worker> readCollection(FileReader reader){
        while((String line=reader.))
    }*/
}