package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudentController {

    Main m = new Main();


    public Label resultLbl;
    public Button btn;
    public TextField getName;
    public TextField getSurName;
    public TextField getStudentId;
    public TextField getPassword;

    public void saveBtn(ActionEvent actionEvent) {
        boolean istrue = true;
        if (getName.getText().equals("") || getSurName.getText().equals("") || getStudentId.getText().equals("") || getPassword.getText().equals("")) {
            resultLbl.setText("!! Please complet text field !!");
        } else {
            if (m.studentlist.size() == 0) {
                m.studentlist.add(new Student(getName.getText(), getSurName.getText(), getPassword.getText(), Long.parseLong(getStudentId.getText())));
                resultLbl.setText("Student Successfuly Saved");
            } else {
                for (int i = 0; i < m.studentlist.size(); i++) {
                    if (Long.parseLong(getStudentId.getText()) == m.studentlist.get(i).getStudentid()) {
                        istrue = false;
                    }
                }
                if (istrue) {
                    m.studentlist.add(new Student(getName.getText(), getSurName.getText(), getPassword.getText(), Long.parseLong(getStudentId.getText())));
                    resultLbl.setText("Student Successfuly Saved");
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
            stage.setScene(new Scene(root, 200, 335));
            stage.setTitle("Manager Page");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
