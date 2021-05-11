package example.exceptions;

public class AddressFieldEmptyException extends Exception {
    public AddressFieldEmptyException(){
        super(String.format("Add an address!"));
    }
}
