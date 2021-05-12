package example.controllers;

import example.exceptions.EmailAlreadyRegistered;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import example.exceptions.UsernameAlreadyExistsException;
import example.exceptions.PasswordFieldEmptyException;
import example.exceptions.UsernameFieldEmptyException;
import example.exceptions.FullNameFieldEmptyException;
import example.exceptions.AddressFieldEmptyException;
import example.exceptions.EmailFieldEmptyException;
import example.services.UserService;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Buyer", "Seller");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), fullNameField.getText(), addressField.getText(), emailField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException| EmailAlreadyRegistered| PasswordFieldEmptyException| UsernameFieldEmptyException| FullNameFieldEmptyException| AddressFieldEmptyException| EmailFieldEmptyException e) {
            registrationMessage.setText(e.getMessage());
        }

    }

    public void onToLogin(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene0=new Scene(p,600,500);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Login page");
        window.setScene(scene0);
        window.show();
    }
}
