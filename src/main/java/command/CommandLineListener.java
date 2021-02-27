package main.java.command;

import java.io.InputStream;
import java.util.Scanner;

public class CommandLineListener {
    private InputStream stream;
    private Scanner scanner;
    private String line;
    public CommandLineListener(InputStream stream){
        this.stream=stream;
        scanner=new Scanner(stream);
    }
    public void setStream(InputStream stream){
        this.stream=stream;
        scanner=new Scanner(stream);
    }
    public void startRead(){
        while(!line.equals("stop")) {
            line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
