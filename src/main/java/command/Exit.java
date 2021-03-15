package command;

public class Exit implements Command{
    private Invoker i;
    Exit(Invoker invoker){
        i=invoker;
    }

    @Override
    public void execute(String args) {
        i.requestExit(this);
    }

    @Override
    public String description() {
        return "This command stops running of this application\n";
    }
}
