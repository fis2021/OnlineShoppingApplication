package example.exceptions;

public class ProductAlreadySoldException extends Exception {
    public ProductAlreadySoldException() {
        super(String.format("The product has been sold!"));
    }
}
