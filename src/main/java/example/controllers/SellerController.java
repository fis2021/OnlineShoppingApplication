package example.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SellerController {

    @FXML
    AnchorPane content;

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

    @FXML
    private void editProductAction(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/edit_product.fxml"));
        Scene scene2 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Choose a product:");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void deleteProductAction(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/delete_product.fxml"));
        Scene scene20 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Choose a product:");
        window.setScene(scene20);
        window.show();
    }


    public void viewProducts(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(getClass().getResource("/ListViewSeller.fxml").toString().replace("%20", " ")));
        AnchorPane root = loader.load();
        content.getChildren().setAll(root);


    }


    public void viewRequests(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(getClass().getResource("/ListViewRequests.fxml").toString().replace("%20", " ")));
        AnchorPane root = loader.load();
        content.getChildren().setAll(root);
    }
}
