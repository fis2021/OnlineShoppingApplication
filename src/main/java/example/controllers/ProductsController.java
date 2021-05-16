package example.controllers;

import java.io.IOException;
import java.sql.SQLException;

import example.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import example.exceptions.DescriptionFieldEmptyException;
import example.exceptions.SizeFieldEmptyException;
import example.exceptions.ColorFieldEmptyException;
import example.exceptions.MaterialFieldEmptyException;
import example.exceptions.BrandFieldEmptyException;
import example.services.ProductService;

import static example.services.ProductService.checkIsUnic;
import static example.services.ProductService.checkIsUnic;

public class ProductsController {
  int cnt=0;
    @FXML
     TextField IdField;
    @FXML
     TextField DescriptionField;
    @FXML
    TextField SizeField;
    @FXML
     TextField MaterialField;
    @FXML
    TextField ColorField;
    @FXML
    TextField BrandField;
    @FXML
    Label ErrorField;


    @FXML
    void add_products_check() {

        try {
            while (checkIsUnic(cnt) == false) {
                cnt++;
            }
            ProductService.addProduct(DescriptionField.getText(), SizeField.getText(), ColorField.getText(), MaterialField.getText(), BrandField.getText(), cnt);
            ErrorField.setText("Product added successfully!");
        }
         catch (DescriptionFieldEmptyException| SizeFieldEmptyException| MaterialFieldEmptyException| ColorFieldEmptyException| BrandFieldEmptyException ex) {
                ErrorField.setText(ex.getMessage());

        }}

    @FXML
    private void goBack(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/seller.fxml"));
        Scene scene2 = new Scene(p, 600, 500);
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Seller");
        window.setScene(scene2);
        window.show();
    }



    @FXML
    public void editProductAction(ActionEvent actionEvent) {
        ProductService.editProduct((Integer.parseInt(IdField.getText())),DescriptionField.getText(), SizeField.getText(), ColorField.getText(), MaterialField.getText(), BrandField.getText());
    }

    @FXML
    public void deleteProductAction(ActionEvent actionEvent) {
        ProductService.deleteProduct(Integer.parseInt(IdField.getText()));
   }
}



