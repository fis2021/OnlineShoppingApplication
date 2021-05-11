package example.exceptions;

public class ColorFieldEmptyException extends Exception {
    public ColorFieldEmptyException(){
        super(String.format("Add a color!"));
    }
}
