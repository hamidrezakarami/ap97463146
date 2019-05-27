


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewPatientListController implements Initializable {

    public ListView patientListFx;
    public Button btn;


    Main m = new Main();

//    public void btn(ActionEvent actionEvent) {
//        patientListFx.getItems().addAll("utfff");
//        patientListFx.getItems().addAll("hhhh");
//    }

    public void backbtn(ActionEvent actionEvent)throws Exception {

        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        stage.setScene(new Scene(root, 270, 450));
        stage.setTitle("Add Patient");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int num = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < m.t.floor[0].eroom[i].beds.size(); j++) {
                patientListFx.getItems().addAll(num + "." + m.t.floor[0].eroom[i].beds.get(j).patient.toString() + "Emergency\t\t10" + (i + 1));
                num++;
            }

        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m.t.floor[1].icuroom[i].beds.size(); j++) {
                patientListFx.getItems().addAll(num + "." + m.t.floor[1].icuroom[i].beds.get(j).patient.toString() + "ICU\t\t20" + (i + 1));
                num++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m.t.floor[1].sroom[i].beds.size(); j++) {
                patientListFx.getItems().addAll(num + "." + m.t.floor[1].sroom[i].beds.get(j).patient.toString() + "\t\tStreise\t\t30" + (i + 1));
                num++;
            }
        }
    }
}
