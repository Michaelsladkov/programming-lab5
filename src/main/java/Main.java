package main.java;

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
        Invoker i = new Invoker(manager, workerFactory, decoder);
        CommandLineListener listener = new CommandLineListener(s, i);
        FileWorks fileWorks=new FileWorks();
        listener.startRead();
    }
}
