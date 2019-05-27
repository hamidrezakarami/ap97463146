import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    public Button btn;

    Main m = new Main();

    public void patientmenubtn(ActionEvent actionEvent)throws Exception {
        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        ////////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        stage.setScene(new Scene(root, 270, 450));
        stage.setTitle("Patient Page");
        stage.show();
    }

    public void personnelmenubtn(ActionEvent actionEvent) throws Exception {//////////////////////////////////for close page
        Stage stage1 = (Stage) btn.getScene().getWindow();
        stage1.close();

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PersonnelPage.fxml"));
        stage.setScene(new Scene(root, 704, 603));
        stage.setTitle("Personnel Page");
        stage.show();
    }

    public void exitbtn(ActionEvent actionEvent) throws Exception {
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();

        m.t.savePatientToFile();
        m.t.savePersonnelToFile();
    }
}
