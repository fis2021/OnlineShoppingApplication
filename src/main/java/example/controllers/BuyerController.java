package example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BuyerController {

    @FXML
    private void signOut(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene2=new Scene(p,600,500);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Welcome!");
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void handleBuyButton(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/fxml/tableview_products.fxml"));
        Scene scene1=new Scene(p,600,500);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    public void viewProducts(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/ListViewBuyer.fxml"));

        Scene scene15 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("These are the products available:");
        window.setScene(scene15);
        window.show();


    }



    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/buyer.fxml"));
        Scene scene22=new Scene(p,600,500);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Buyer page");
        window.setScene(scene22);
        window.show();
    }

    public void sendRequestForProduct(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/request_product.fxml"));
        Scene scene22 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Choose a product:");
        window.setScene(scene22);
        window.show();
    }
}
