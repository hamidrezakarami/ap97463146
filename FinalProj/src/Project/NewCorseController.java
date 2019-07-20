package Project;

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

public class NewCorseController implements Initializable {

    public TextField getCourseId;
    public TextField getInformation;
    Main m = new Main();
    Teacher t;

    public ComboBox numberOfClassCombo;
    public ComboBox departmentCombo;
    public TextField getCorseName;
    public TextField getTeacherId;
    public Button btn;
    public Label resultLbl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfPersonnelView = FXCollections.observableArrayList("101", "102");
        numberOfClassCombo.setItems(typeOfPersonnelView);
    }

    public void saveBtnFx(ActionEvent actionEvent) {
        boolean istrue = true;
        if (getTeacherId.getText().equals("") || getCorseName.getText().equals("") || getCourseId.getText().equals("")) {
            resultLbl.setText("!! Please complet text field !!");
        } else {
            if (m.teacherlist.size() == 0)
                resultLbl.setText("We Dont Have Teacher");
            else {
                for (int i = 0; i < m.corselist.size(); i++) {
                    if (m.corselist.get(i).getCourseid() == Integer.parseInt(getCourseId.getText()))
                        istrue = false;
                }
                for (int i = 0; i < m.teacherlist.size(); i++) {
                    if (istrue) {
                        if (Long.parseLong(getTeacherId.getText()) == m.teacherlist.get(i).getPersonnleid()) {
                            t = m.teacherlist.get(i);
                            m.corselist.add(new Corse(Integer.parseInt(numberOfClassCombo.getValue().toString()), getCorseName.getText(), t, Integer.parseInt(getCourseId.getText()),getInformation.getText(),0));
                            m.teacherlist.get(i).corses.add(new Corse(Integer.parseInt(numberOfClassCombo.getValue().toString()), getCorseName.getText(), t, Integer.parseInt(getCourseId.getText()),getInformation.getText(),0));
                            resultLbl.setText("Course Successfuly Saved");
                        } else {
                            resultLbl.setText("!! Teacher can not found !!");
                        }
                    } else
                        resultLbl.setText("!! Course ID have been choised !!");
                }
            }
        }
    }

    public void backBtn(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Managerpage.fxml"));
            stage.setScene(new Scene(root, 200, 337));
            stage.setTitle("Manager Page");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
