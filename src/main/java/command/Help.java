package command;

import java.util.HashMap;
import java.util.Map;

public class Help implements Command{
    private HashMap<String, Command> commands;
    Help(HashMap<String, Command> c){commands=c;}

    @Override
    public void execute(String args) {
        for(Map.Entry<String, Command> entry:commands.entrySet()){
            System.out.println(" -"+entry.getKey());
            System.out.println(entry.getValue().description());
        }
    }

    @Override
    public String description() {
        return "This command shows help about all commands\n";
    }
}
