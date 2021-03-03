package main.java.util;

import main.java.command.Invoker;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineListener {
    private InputStream stream;
    private Scanner scanner;
    private String line;
    private Invoker invoker;
    Pattern commandNamePattern;
    Pattern argsPattern;
    public CommandLineListener(Scanner s, Invoker i){
        scanner=s;
        invoker=i;
        commandNamePattern = Pattern.compile("^\\w+");
        argsPattern = Pattern.compile("\\b(\\w*\\s*)*");
    }

    public void setStream(InputStream stream){
        this.stream=stream;
        scanner=new Scanner(stream);
    }

    public void startRead(){
        String command;
        String args;
        do {
            line = scanner.nextLine();
            Matcher matcher = commandNamePattern.matcher(line);
            matcher.find();
            try{
                command=matcher.group();
            }
            catch (IllegalStateException e){
                System.out.println("Your input is not a command");
                command="";
            }
            line=line.substring(command.length());
            matcher = argsPattern.matcher(line);
            matcher.find();
            try{
                args=matcher.group();
            }
            catch (IllegalStateException e){
                args="";
            }
            invoker.execute(command,args);
        } while(!line.equals("stop"));
    }
}