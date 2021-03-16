package util;

import command.Invoker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for listening command line? separating command name and arguments and invoker calling
 */
public class CommandLineListener {
    private InputStreamReader stream;
    private Scanner scanner;
    private String line;
    private Invoker invoker;
    private final Pattern commandNamePattern;
    private final Pattern argsPattern;

    /**
     * @param s - scanner, source of commands (usually System.in or File reader connected to script
     * @param i
     */
    public CommandLineListener(Scanner s, Invoker i){
        scanner=s;
        invoker=i;
        commandNamePattern = Pattern.compile("^\\w+");
        argsPattern = Pattern.compile("\\b(\\.*\\s*)*");
    }

    /**
     * starts reading loop
     * this loop reads commands ad calls invoker
     * loop is finished if input is empty or exit command is activated
     */
    public void startRead(){
        String command;
        String args;
        do {
            try {
                line = scanner.nextLine();
            }
            catch (NoSuchElementException e){
                break;
            }
            Matcher matcher = commandNamePattern.matcher(line);
            matcher.find();
            try{
                command=matcher.group();
            }
            catch (IllegalStateException e){
                System.out.println("Your input is not a command");
                continue;
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
            try {
                invoker.execute(command, args);
            }
            catch (NullPointerException e){
                System.out.println("Your input doesn't match any command");
            }
        } while(!invoker.isStopRequested()&&scanner.hasNext());
    }
}