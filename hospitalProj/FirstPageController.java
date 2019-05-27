

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstPageController {
    public Button btn;

    public void AddPatientFX(ActionEvent actionEvent) throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        ////////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddPage.fxml"));
        stage.setScene(new Scene(root, 700, 603));
        stage.setTitle("Add Patient");
        stage.show();
    }

    public void payFx(ActionEvent actionEvent) throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PayPage.fxml"));
        stage.setScene(new Scene(root, 300, 400));
        stage.setTitle("Pay");
        stage.show();
    }

    public void exitFx(ActionEvent actionEvent) {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        ////////////////////////////////////
    }

    public void viewPatientListFx(ActionEvent actionEvent) throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        ////////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPatientList.fxml"));
        stage.setScene(new Scene(root, 704, 603));
        stage.setTitle("View page");
        stage.show();
    }


    public void backbtn(ActionEvent actionEvent) throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setScene(new Scene(root, 150, 270));
        stage.setTitle("Menu");
        stage.show();
    }
}
