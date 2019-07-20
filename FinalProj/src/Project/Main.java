package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    String h;

    static ArrayList<Corse> corselist = new ArrayList<>();
    static ArrayList<Teacher> teacherlist = new ArrayList<>();
    static ArrayList<Student> studentlist = new ArrayList<>();
    static Manager manager = new Manager();
    public FileClass f = new FileClass();
        @Override
    public void start(Stage primaryStage) throws Exception {
f.creatFile();
f.read();
        Parent root = FXMLLoader.load(getClass().getResource("GetPassPage.Fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 335, 220));
        primaryStage.show();

    }


}
