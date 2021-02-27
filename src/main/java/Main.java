package main.java;

import main.java.command.CommandLineListener;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        CommandLineListener listener = new CommandLineListener(System.in);
        listener.startRead();
    }
}
