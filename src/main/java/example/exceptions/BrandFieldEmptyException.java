package example.exceptions;

public class BrandFieldEmptyException extends Exception {
    public BrandFieldEmptyException(){
        super(String.format("Add a brand!"));
    }
}
