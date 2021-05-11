package example.exceptions;

public class SizeFieldEmptyException extends Exception {
    public SizeFieldEmptyException(){
        super(String.format("Add a size!"));
    }
}
