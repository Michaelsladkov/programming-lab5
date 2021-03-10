package main.java;

import main.java.command.Invoker;
import main.java.storrage.StorageManager;
import main.java.util.CommandLineListener;
import main.java.util.FileWorks;
import main.java.util.WorkerDecoder;
import main.java.util.WorkerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WorkerFactory workerFactory = new WorkerFactory(0);
        WorkerDecoder decoder = new WorkerDecoder();
        StorageManager manager = new StorageManager();
        Scanner s = new Scanner(System.in);
        workerFactory.setScanner(s);
        Invoker i = new Invoker(manager, workerFactory, decoder);
        CommandLineListener listener = new CommandLineListener(s, i);
        FileWorks fileWorks=new FileWorks();
        listener.startRead();
    }
}
