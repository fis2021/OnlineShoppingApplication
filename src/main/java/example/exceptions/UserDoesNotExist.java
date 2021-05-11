package example.exceptions;

public class UserDoesNotExist extends Exception {
    public UserDoesNotExist() {
        super(String.format("Incorrect user"));
    }
}
