package example.controllers;

import example.exceptions.*;
import example.model.Request;
import example.services.ProductService;
import example.services.RequestService;
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

import static example.services.ProductService.checkIsUnic;

public class RequestsController {

    @FXML
     TextField IdField;



    @FXML
    void sendRequest() {

        //RequestService.addRequest( Integer.parseInt.valueOf(IdField.getText()));

                               }

    @FXML
    private void goBack(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/buyer.fxml"));
        Scene scene2 = new Scene(p, 600, 500);
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Seller");
        window.setScene(scene2);
        window.show();
    }





}



