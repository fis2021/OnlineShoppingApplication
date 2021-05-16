package example;


import example.services.RequestService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import example.services.FileSystemService;
import example.services.UserService;
import example.services.ProductService;
import java.nio.file.Files;
import java.nio.file.Path;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        ProductService.initDatabase();
        RequestService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("seller.fxml"));
        primaryStage.setTitle("Registration Example");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();



    }



    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
