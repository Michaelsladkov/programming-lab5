package command;


/**
 * Exit command
 * Stops command line listener. It stop's all app in console mode or interrupts script in script mode
 * @see util.CommandLineListener
 */
public class Exit implements Command{
    private final Invoker i;
    /**
     * Constructor for this command
     * @param invoker - Invoker, translated to this class to init new
     */
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
