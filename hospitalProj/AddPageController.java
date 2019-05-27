

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

public class AddPageController implements Initializable {

    public ComboBox typeOfRoom;
    public ComboBox numOfRoom;
    public TextField getIdForAddFx;
    public TextField getFnameForAddFx;
    public TextField getNameForAddFx;
    public Label resultLbl;
    public Button btn;

    Main m = new Main();
//AddPageController (Main m1){
//    m = m1;
//}

    //Tools t = new Tools();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfRoomView = FXCollections.observableArrayList("Emergency", "ICU", "Sterilize");

        typeOfRoom.setItems(typeOfRoomView);


    }


    public void refresh ()
    {

        if (typeOfRoom.getValue().toString().equals("Emergency")) {
            ObservableList<String> numOfRoomView = FXCollections.observableArrayList("101", "102", "103", "104", "105", "106");
            numOfRoom.setItems(numOfRoomView);
        } else if (typeOfRoom.getValue().toString().equals("ICU")) {
            ObservableList<String> numOfRoomView = FXCollections.observableArrayList("201", "202", "203");
            numOfRoom.setItems(numOfRoomView);
        } else {
            ObservableList<String> numOfRoomView = FXCollections.observableArrayList("301", "302", "303");
            numOfRoom.setItems(numOfRoomView);
        }
    }

    public void saveBtnFx(ActionEvent actionEvent) {
        int roomid, roomtype, floornum;
        if (typeOfRoom.getValue().toString().equals("Emergency")) {
            floornum = 0;
            roomtype = 1;
            if (numOfRoom.getValue().toString().equals("101"))
                roomid = 0;
            else if (numOfRoom.getValue().toString().equals("102"))
                roomid = 1;
            else if (numOfRoom.getValue().toString().equals("103"))
                roomid = 2;
            else if (numOfRoom.getValue().toString().equals("104"))
                roomid = 3;
            else if (numOfRoom.getValue().toString().equals("105"))
                roomid = 4;
            else
                roomid = 5;
        } else if (typeOfRoom.getValue().toString().equals("ICU")) {
            floornum = 1;
            roomtype = 2;
            if (numOfRoom.getValue().toString().equals("201"))
                roomid = 0;
            else if (numOfRoom.getValue().toString().equals("202"))
                roomid = 1;
            else
                roomid = 2;
        } else {
            floornum = 1;
            roomtype = 3;
            if (numOfRoom.getValue().toString().equals("301"))
                roomid = 0;
            else if (numOfRoom.getValue().toString().equals("302"))
                roomid = 1;
            else
                roomid = 2;
        }
        boolean has = false;
        if (floornum == 0) {
            if (m.t.floor[floornum].eroom[roomid].isEmpty()) {

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < m.t.floor[0].eroom[i].beds.size(); j++) {
                        if (Integer.parseInt(getIdForAddFx.getText()) == m.t.floor[0].eroom[i].beds.get(j).patient.getId()) {
                            has = true;
                        }
                    }
                }
                if (has == false) {
                    Bed b = new Bed();
                    b.getPatient(getNameForAddFx.getText(), getFnameForAddFx.getText(), Integer.parseInt(getIdForAddFx.getText()),roomid);
                    m.t.floor[floornum].eroom[roomid].beds.add(b);
                    resultLbl.setText("saved");
                } else
                    resultLbl.setText("id tekrari");

            } else
                resultLbl.setText("fuulllllllll");
        } else if (roomtype == 2) {
            Bed b = new Bed();
            if (m.t.floor[floornum].icuroom[roomid].isEmpty()) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < m.t.floor[1].icuroom[i].beds.size(); j++) {
                        if (Integer.parseInt(getIdForAddFx.getText()) == m.t.floor[1].icuroom[i].beds.get(j).patient.getId()) {
                            has = true;
                        }
                    }
                }
                if (has == false) {
                    b.getPatient(getNameForAddFx.getText(), getFnameForAddFx.getText(), Integer.parseInt(getIdForAddFx.getText()),roomid);
                    m.t.floor[floornum].icuroom[roomid].beds.add(b);
                    resultLbl.setText("saved");
                } else
                    resultLbl.setText("tekrari");
            } else
                resultLbl.setText("fuulllllllll");
        } else {
            Bed b = new Bed();
            if (m.t.floor[floornum].sroom[roomid].isEmpty()) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < m.t.floor[1].sroom[i].beds.size(); j++) {
                        if (Integer.parseInt(getIdForAddFx.getText()) == m.t.floor[1].sroom[i].beds.get(j).patient.getId()) {
                            has = true;
                        }
                    }
                }
                if (has == false) {
                    b.getPatient(getNameForAddFx.getText(), getFnameForAddFx.getText(), Integer.parseInt(getIdForAddFx.getText()),roomid);
                    m.t.floor[floornum].sroom[roomid].beds.add(b);
                    resultLbl.setText("saved");
                } else
                    resultLbl.setText("tecrari");
            } else
                resultLbl.setText("fuulllllllll");
        }


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