package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader mainWindowLoader = new FXMLLoader();
        mainWindowLoader.setLocation(getClass().getResource("sample.fxml"));
        Parent mainRoot = mainWindowLoader.load();
        primaryStage.setTitle("Цифровые часы");
        primaryStage.setScene(new Scene(mainRoot, 1100, 150));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
