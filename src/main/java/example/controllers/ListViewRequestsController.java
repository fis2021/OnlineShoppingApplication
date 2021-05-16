package example.controllers;

import example.services.RequestService;
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


public class ListViewRequestsController<Array> {
    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private ListView<String> screen;




    @FXML
    public void initialize() {
        
        AtomicReference<String> p = new AtomicReference<>("");
        RequestService.getRequests().forEach(request -> {
            p.set(String.valueOf(request.getIdr()));
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
        Parent p= FXMLLoader.load(getClass().getResource("/seller.fxml"));
        Scene scene22=new Scene(p,600,500);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Seller page");
        window.setScene(scene22);
        window.show();
    }

    public void sendRequest(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/request_product.fxml"));
        Scene scene22 = new Scene(p, 600, 500);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Choose a product:");
        window.setScene(scene22);
        window.show();
    }
}

