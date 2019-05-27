import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPersonnelController implements Initializable {
    public AnchorPane btn;
    public ComboBox typeOfPersonnel;
    public Label resultLbl;
    public TextField getID;
    public TextField getAddress;
    public TextField getFamily;
    public TextField getName;

Main m = new Main();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfPersonnelView = FXCollections.observableArrayList("Doctor", "Nurse");
        typeOfPersonnel.setItems(typeOfPersonnelView);
    }

    public void savebtn(ActionEvent actionEvent) {

       // int personneltype;//1 for doctor 2 for nurse

        if (typeOfPersonnel.getValue().toString().equals("Doctor")){
            if(chechid()){
                m.t.doctors.add(new Doctor(getName.getText(),getFamily.getText(),getAddress.getText(),Integer.parseInt(getID.getText())));
                resultLbl.setText("save");
            }
            else
                resultLbl.setText("repetitive ID");
        }
        else
            if(chechid()){
                m.t.nurses.add(new Nurse(getName.getText(),getFamily.getText(),getAddress.getText(),Integer.parseInt(getID.getText())));
                resultLbl.setText("save");
            }
            else
                resultLbl.setText("repetitive ID");





    }

    public boolean chechid (){
        for (int i = 0; i < m.t.doctors.size(); i++) {
            if (m.t.doctors.get(i).getId() == Integer.parseInt(getID.getText()))
                return false;
        }

        for (int i = 0; i < m.t.nurses.size(); i++) {
            if (m.t.nurses.get(i).getId() == Integer.parseInt(getID.getText()))
                return false;
        }
        return true;
    }



    public void backbtn(ActionEvent actionEvent)throws Exception {

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
}
