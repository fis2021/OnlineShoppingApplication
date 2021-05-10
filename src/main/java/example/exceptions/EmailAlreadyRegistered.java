package example.exceptions;

public class EmailAlreadyRegistered extends Exception {

    private String email;

    public EmailAlreadyRegistered(String email) {
        super(String.format("An account with this email %s already exists!", email));
        this.email = email;
    }

    public String getUsername() {
        return email;
    }
}
