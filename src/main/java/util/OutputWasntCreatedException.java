package util;

public class OutputWasntCreatedException extends RuntimeException{
    public OutputWasntCreatedException(){
        super("Output stream is null");
    }
}
