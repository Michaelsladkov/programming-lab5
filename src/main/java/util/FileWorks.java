package util;

import data.Worker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

public class FileWorks {
    private FileInputStream inputFile;
    private FileOutputStream outputFile;
    public FileWorks()
    {

    }

    public void createOutputFile(){
        try {
            outputFile = new FileOutputStream("output.csv");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void saveCollection(Collection<Worker> collection){

    }
}
