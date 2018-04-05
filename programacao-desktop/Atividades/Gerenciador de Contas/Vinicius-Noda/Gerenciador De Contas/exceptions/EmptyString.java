package exceptions;

public class EmptyString extends Exception{

    public EmptyString(String message){
        super("Empty "+message+" not expected!");
    }
}