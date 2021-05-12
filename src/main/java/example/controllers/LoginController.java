package example.controllers;

import example.exceptions.IncorrectPasswordException;
import example.exceptions.UserDoesNotExist;
import example.model.User;
import example.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;


public class LoginController {


    @FXML
    private javafx.scene.control.PasswordField PasswordField;
    @FXML
    private TextField EmailField;
    @FXML
    private Label login_test;


    @FXML
    private void login_check() {
    }


    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        Scene scene2 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Welcome!");
        window.setScene(scene2);
        window.show();
    }


    @FXML
    private void login_check(ActionEvent actionEvent) throws IOException {

        int count = 0;
        User user;
        try {
            user = UserService.checkCorrectPassword(EmailField.getText(), PasswordField.getText());
            Parent root;
            if(user.getRole().equals("Seller"))
                root = FXMLLoader.load(getClass().getResource("/seller.fxml"));
            else root = FXMLLoader.load(getClass().getResource("/buyer.fxml"));
            Scene scene = new Scene(root,600,500);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Welcome!");
            stage.setScene(scene);
            stage.show();

        } catch (UserDoesNotExist e) {
            count++;
//            login_test.setText(e.getMessage());
        } catch (IncorrectPasswordException e) {
            login_test.setText(e.getMessage());
        }



        try {
            if (count == 1) throw new UserDoesNotExist();
        } catch (UserDoesNotExist e) {
            login_test.setText(e.getMessage());
        }
    }


    public void onToRegistration(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/register.fxml"));
        Scene scene22=new Scene(p,600,500);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Register page");
        window.setScene(scene22);
        window.show();
    }
}

