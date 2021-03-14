package command;

import util.CommandLineListener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ThisIsACommand
public class ExecuteScript implements Command {
    private Invoker invoker;
    private static Set<String> scriptFiles;
    ExecuteScript(Invoker i){
        invoker=i;
    }

    @Override
    public void execute(String args) {
        FileReader scriptReader;
        Scanner scriptScanner;
        CommandLineListener listener;
        try {
            scriptReader = new FileReader(args);
            if(!scriptFiles.add(args)){
                System.out.println("forbidden recursion detected");
                return;
            }
            scriptScanner=new Scanner(scriptReader);
        }
        catch (FileNotFoundException e){
            System.out.println("No such file.");
            return;
        }
        listener=new CommandLineListener(scriptScanner, invoker);
        listener.startRead();
    }
}
