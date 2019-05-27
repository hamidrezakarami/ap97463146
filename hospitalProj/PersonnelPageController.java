import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonnelPageController {

    public Button btn;

    public void addbtn(ActionEvent actionEvent)throws Exception {
       //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddPersonnel.fxml"));
        stage.setScene(new Scene(root, 300, 450));
        stage.setTitle("Add Personnel");
        stage.show();

    }

    public void viewPersonnelListbtn(ActionEvent actionEvent)throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPersonnelList.fxml"));
        stage.setScene(new Scene(root, 450, 450));
        stage.setTitle("View Personnel");
        stage.show();
    }

    public void Removebtn(ActionEvent actionEvent) throws IOException {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("RemovePersonnelPage.fxml"));
        stage.setScene(new Scene(root, 450, 450));
        stage.setTitle("Remove Personnel");
        stage.show();
    }

    public void backbtn(ActionEvent actionEvent) throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        stage.setScene(new Scene(root, 450, 450));
        stage.setTitle("Menu");
        stage.show();
    }
}
