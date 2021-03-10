package data;

public class NullFieldException extends Exception{
    public NullFieldException(){
        super("This field can't be null");
    }
    public NullFieldException(String fieldName){
        super(fieldName+" can't be null");
    }
}
