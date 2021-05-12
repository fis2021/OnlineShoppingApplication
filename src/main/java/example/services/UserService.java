package example.services;

import example.exceptions.*;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.ObjectRepository;
import example.exceptions.IncorrectPasswordException;
import example.exceptions.UserDoesNotExist;
import example.model.User;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static example.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;
    private static String username;
    private static String password;
    private static String fullName;
    private static String address;
    private static String email;
    private static String role;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");
        NitriteCollection collection = database.getCollection("registration-example");
        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String fullName, String address, String email, String role) throws UsernameAlreadyExistsException, EmailAlreadyRegistered, UsernameFieldEmptyException, PasswordFieldEmptyException, AddressFieldEmptyException, FullNameFieldEmptyException, EmailFieldEmptyException {

        checkUserFieldIsNotEmpty(username);
        checkPasswordFieldIsNotEmpty(password);
		checkAddressFieldIsNotEmpty(address);
		checkFullNameFieldIsNotEmpty(fullName);
		checkEmailFieldIsNotEmpty(email);
        checkUserDoesNotAlreadyExist(username);
		checkEmailAlreadyRegistered(username);
        userRepository.insert(new User(username, encodePassword(email, password), fullName, address, email, role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
				}}

	private static void checkEmailAlreadyRegistered(String email) throws EmailAlreadyRegistered {
        for (User user : userRepository.find()) {
            if (Objects.equals(email, user.getEmail()))
                throw new EmailAlreadyRegistered(email);
				}}

    private static void checkUserFieldIsNotEmpty(String username) throws UsernameFieldEmptyException{
        if(username.equals(""))
            throw new UsernameFieldEmptyException();
    }

	 private static void checkPasswordFieldIsNotEmpty(String password) throws PasswordFieldEmptyException{
        if(password.equals(""))
            throw new PasswordFieldEmptyException();
    }
    
	 private static void checkAddressFieldIsNotEmpty(String address) throws AddressFieldEmptyException{
        if(address.equals(""))
            throw new AddressFieldEmptyException();
    }

	 private static void checkEmailFieldIsNotEmpty(String password) throws EmailFieldEmptyException{
        if(password.equals(""))
            throw new EmailFieldEmptyException();
    }
	 private static void checkFullNameFieldIsNotEmpty(String fullName) throws FullNameFieldEmptyException{
        if(fullName.equals(""))
            throw new FullNameFieldEmptyException();
    }

    public static User checkCorrectPassword(String email, String password) throws IncorrectPasswordException, UserDoesNotExist {
        for (User user : userRepository.find()) {
            if (Objects.equals(email, user.getEmail())) {
                if (Objects.equals(encodePassword(email, password), user.getPassword())) {
                    return user;
                } else {
                    throw new IncorrectPasswordException(password);
                }
            }


        }
		 throw new UserDoesNotExist();
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }}



