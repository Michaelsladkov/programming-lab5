package main.java;

import main.java.command.Invoker;
import main.java.storrage.StorageManager;
import main.java.util.CommandLineListener;
import main.java.util.WorkerFactory;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WorkerFactory workerFactory = new WorkerFactory(0);
        StorageManager manager = new StorageManager();
        Scanner s = new Scanner(System.in);
        Invoker i = new Invoker(manager, workerFactory);
        CommandLineListener listener = new CommandLineListener(s, i);
        listener.startRead();
    }
}
