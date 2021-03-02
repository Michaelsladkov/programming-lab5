package main.java;

import main.java.command.CommandLineListener;
import main.java.command.Invoker;
import main.java.storrage.StorageManager;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        StorageManager manager = new StorageManager();
        Scanner s = new Scanner(System.in);
        Invoker i = new Invoker(manager);
        CommandLineListener listener = new CommandLineListener(s, i);
        listener.startRead();
    }
}
