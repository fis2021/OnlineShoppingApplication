package example.exceptions;

public class ProductDoesNotExistException extends Exception {
    public ProductDoesNotExistException() {
        super(String.format("There are no such products!"));
    }
}
