package example.exceptions;

public class MaterialFieldEmptyException extends Exception {
    public MaterialFieldEmptyException(){
        super(String.format("Add a material!"));
    }
}
