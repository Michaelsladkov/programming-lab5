package command;

@ThisIsACommand
public class Exit implements Command{
    private Invoker i;
    Exit(Invoker invoker){
        i=invoker;
    }

    @Override
    public void execute(String args) {
        i.isStopRequested=true;
    }
}
