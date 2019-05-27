

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    Tools t = new Tools();


    @Override
    public void start(Stage primaryStage) throws Exception {

    t.creatTest();
    t.read();
        t.creatFile();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 150, 270));
        primaryStage.show();

    }


}
