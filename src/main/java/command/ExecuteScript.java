package command;

import util.CommandLineListener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ExecuteScript command
 * Takes text file and read commands from it
 */
public class ExecuteScript implements Command {
    private final Invoker invoker;
    private static final HashSet<String> scriptFiles=new HashSet<>();

    /**
     * Constructor for this command
     * @param invoker - Invoker, translated to this class to init new
     * @see CommandLineListener
     */
    ExecuteScript(Invoker invoker){
        this.invoker=invoker;
    }

    @Override
    public void execute(String args) {
        FileReader scriptReader;
        try {
            scriptReader = new FileReader(args);
            if(!scriptFiles.add(args)){
                System.out.println("forbidden recursion detected");
                return;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("No such file.");
            return;
        }
        CommandLineListener listener = new CommandLineListener(new Scanner(scriptReader), invoker);
        listener.startRead();
        scriptFiles.clear();
    }

    @Override
    public String description() {
        return "This command reads your file and execute commands from it\n" +
                "Recursive scripts are restricted\n";
    }
}