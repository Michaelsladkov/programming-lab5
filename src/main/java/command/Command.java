package command;

public interface Command {
    void execute(String args);
    default String description(){
        return "this command don't have a description\n";
    };
}
