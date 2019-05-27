import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemovePersonnelPageController implements Initializable {
    public ComboBox typeOfPersonnel;
    public TextField getid;
    public Label resultlbl;
    public Label resultSerchlbl;
    public Button btn;

    Main m = new Main();

    public void removebtn(ActionEvent actionEvent) {
        if (typeOfPersonnel.getValue().equals("Doctor")) {
            for (int i = 0; i < m.t.doctors.size(); i++) {
                if (m.t.doctors.get(i).getId() == Integer.parseInt(getid.getText())) {
                    m.t.doctors.remove(i);
                    resultlbl.setText("REMOVED...");
                }
            }
        }
        else {
            for (int i = 0; i < m.t.nurses.size(); i++) {
                if (m.t.nurses.get(i).getId() == Integer.parseInt(getid.getText())) {
                    m.t.nurses.remove(i);
                    resultlbl.setText("REMOVED...");
                }
            }
        }
    }

    public void Backbtn(ActionEvent actionEvent) throws IOException {

        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PersonnelPage.fxml"));
        stage.setScene(new Scene(root, 270, 450));
        stage.setTitle("Personnel Page");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfPersonnelView = FXCollections.observableArrayList("Doctor", "Nurse");
        typeOfPersonnel.setItems(typeOfPersonnelView);
    }

    public void searchbtn(ActionEvent actionEvent) {
        if (typeOfPersonnel.getValue().equals("Doctor")) {
            for (int i = 0; i < m.t.doctors.size(); i++) {
                if (m.t.doctors.get(i).getId() == Integer.parseInt(getid.getText()))
                    resultSerchlbl.setText(m.t.doctors.get(i).toString());
            }
        }
        else {
            for (int i = 0; i < m.t.nurses.size(); i++) {
                if (m.t.nurses.get(i).getId() == Integer.parseInt(getid.getText()))
                    resultSerchlbl.setText(m.t.nurses.get(i).toString());
            }
        }
    }
}
