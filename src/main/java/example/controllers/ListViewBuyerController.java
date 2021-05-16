package example.controllers;

import example.services.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;


public class ListViewBuyerController<Array> {
    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private ListView<String> screen;




    @FXML
    public void initialize() {
        
        AtomicReference<String> p = new AtomicReference<>("");
        ProductService.getProducts().forEach(product -> {
            p.set(product.getDescription() + "  " + product.getSize() + "  " + product.getColor() + "  " + product.getMaterial() + "  " + product.getBrand()+" "+product.getId());
            items.add(String.valueOf(p));
        });
        screen.getItems().addAll(items);


    }


    @FXML
    private void displaySelected(MouseEvent mouseEvent) {
//        String product=items.getSelectionModel().getSelectedItem;
//        if(product==null||product.isEmpty()) display.setText("Nothing was selected.");
//        else display.setText(product+" ");
    }


    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent p= FXMLLoader.load(getClass().getResource("/buyer.fxml"));
        Scene scene22=new Scene(p,600,500);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Buyer page");
        window.setScene(scene22);
        window.show();
    }
}

