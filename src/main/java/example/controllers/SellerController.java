package example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SellerController {
    @FXML
    private void signOut(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene4=new Scene(p,600,500);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Welcome!");
        window.setScene(scene4);
        window.show();
    }

 
    @FXML
    private void handleAddProductAction(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/add_products.fxml"));
        Scene scene2 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Add a product:");
        window.setScene(scene2);
        window.show();
    }

}
