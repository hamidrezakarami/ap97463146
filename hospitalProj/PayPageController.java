
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

import java.net.URL;
import java.util.ResourceBundle;

public class PayPageController implements Initializable {
    public Label searchresultLbl;
    public ComboBox typeofroom;
    public TextField getID;
    public Label payLbl;
    public Button btn;


    Main m = new Main();

    //////////////hanoz dorost nist
    public void Searchbtn(ActionEvent actionEvent) {
        boolean check = true;

        if (typeofroom.getValue().toString().equals("Emergency")) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < m.t.floor[0].eroom[i].beds.size(); j++) {
                    if (m.t.floor[0].eroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        searchresultLbl.setText(m.t.floor[0].eroom[i].beds.get(j).patient.toString());
                        check = false;
                        break;
                    }
                    if (check)
                        searchresultLbl.setText("Cant found");
                }
            }
        } else if (typeofroom.getValue().toString().equals("ICU")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < m.t.floor[1].icuroom[i].beds.size(); j++) {
                    if (m.t.floor[1].icuroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        searchresultLbl.setText(m.t.floor[1].icuroom[i].beds.get(j).patient.toString());
                        check = false;
                        break;
                    }
                    if (check)
                        searchresultLbl.setText("Cant found");
                }
            }
        } else if (typeofroom.getValue().toString().equals("Sterilize")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < m.t.floor[1].sroom[i].beds.size(); j++) {
                    if (m.t.floor[1].sroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        searchresultLbl.setText(m.t.floor[1].sroom[i].beds.get(j).patient.toString());
                        check = false;
                        break;
                    }
                    if (check)
                        searchresultLbl.setText("Cant found");

                }
            }
        } else
            searchresultLbl.setText("you should select Type of room");


    }

    public void payBtn(ActionEvent actionEvent) {

        if (typeofroom.getValue().toString().equals("Emergency")) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < m.t.floor[0].eroom[i].beds.size(); j++) {
                    if (m.t.floor[0].eroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        m.t.floor[0].eroom[i].beds.remove(j);
                        payLbl.setText("payed & ...");
                        break;
                    }
                }
            }
        } else if (typeofroom.getValue().toString().equals("ICU")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < m.t.floor[1].icuroom[i].beds.size(); j++) {
                    if (m.t.floor[1].icuroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        m.t.floor[1].icuroom[i].beds.remove(j);
                        payLbl.setText("payed & ...");
                        break;
                    }
                }
            }
        } else if (typeofroom.getValue().toString().equals("Sterilize")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < m.t.floor[1].sroom[i].beds.size(); j++) {
                    if (m.t.floor[1].sroom[i].beds.get(j).patient.getId() == Integer.parseInt(getID.getText())) {
                        m.t.floor[1].sroom[i].beds.remove(j);
                        payLbl.setText("payed & ...");
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfRoomView = FXCollections.observableArrayList("Emergency", "ICU", "Sterilize");
        typeofroom.setItems(typeOfRoomView);
    }

    public void backbtn(ActionEvent actionEvent) throws Exception {

        //////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        stage.setScene(new Scene(root, 270, 450));
        stage.setTitle("Patient Page");
        stage.show();
    }
}
