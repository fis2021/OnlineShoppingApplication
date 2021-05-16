package example.exceptions;

public class RequestAlreadyExistsException extends Exception {


    private final int id;

    public RequestAlreadyExistsException(int id) {
        super(String.format("A request with the same ID already exists!", id));
        this.id = id;
    }


}
