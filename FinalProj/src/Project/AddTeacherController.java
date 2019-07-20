package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTeacherController {

    Main m = new Main();


    public Button btn;
    public Label resultLbl;
    public TextField getName;
    public TextField getSurName;
    public TextField getId;
    public TextField getPassword;

    public void saveBtn(ActionEvent actionEvent) {
        boolean istrue = true;
        if (getName.getText().equals("") || getSurName.getText().equals("") || getId.getText().equals("") || getPassword.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {
            if (m.teacherlist.size() == 0) {
                m.teacherlist.add(new Teacher(getName.getText(), getSurName.getText(), getPassword.getText(), Long.parseLong(getId.getText())));
                resultLbl.setText("Teacher Successfuly Saved");
            } else {
                for (int i = 0; i < m.teacherlist.size(); i++) {
                    if (Long.parseLong(getId.getText()) == m.teacherlist.get(i).getPersonnleid()) {
                        istrue = false;
                    }
                }
                if (istrue) {
                    m.teacherlist.add(new Teacher(getName.getText(), getSurName.getText(), getPassword.getText(), Long.parseLong(getId.getText())));
                    resultLbl.setText("Teacher Successfuly Saved");
                } else {
                    resultLbl.setText("!! This ID has already been choised !!");
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
            stage.setScene(new Scene(root, 200, 336));
            stage.setTitle("Manager Page");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

