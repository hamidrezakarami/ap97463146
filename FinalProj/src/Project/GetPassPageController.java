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

public class GetPassPageController implements Initializable {
    public Button btn;
    public TextField getUseName;
    public TextField getPassword;
    public Label titleLbl;
    public Label resultLbl;
    public ComboBox logInAsCombo;
    Main m = new Main();
    FileClass f = new FileClass();
    static int number;

    public void enterBtn(ActionEvent actionEvent) {
        boolean found = false;

        if (getPassword.getText().equals("") || getUseName.getText().equals(""))
            resultLbl.setText("!! Please complet text field !!");
        else {
            if (logInAsCombo.getValue().toString().equals("Student")) {
                for (int i = 0; i < m.studentlist.size(); i++) {
                    if (getPassword.getText().equals(m.studentlist.get(i).getPassword())) {
                        if (getUseName.getText().equals(String.valueOf(m.studentlist.get(i).getStudentid()))) {
                            number = i;
                            found = true;
                            try {
                                //////////////////////////////////for close page
                                Stage s = (Stage) btn.getScene().getWindow();
                                s.close();
                                /////////////////////////////////
                                Stage stage = new Stage();
                                Parent root = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                                stage.setScene(new Scene(root, 634, 638));
                                stage.setTitle("STUDENT PAGE");
                                stage.show();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    }
                }

            } else if (logInAsCombo.getValue().toString().equals("Teacher")) {
                for (int i = 0; i < m.teacherlist.size(); i++) {
                    if (getPassword.getText().equals(m.teacherlist.get(i).getPassword())) {
                        if (getUseName.getText().equals(String.valueOf(m.teacherlist.get(i).getPersonnleid()))) {
                            found = true;
                            number = i;
                            try {
                                //////////////////////////////////for close page
                                Stage s = (Stage) btn.getScene().getWindow();
                                s.close();
                                /////////////////////////////////
                                Stage stage = new Stage();
                                Parent root = FXMLLoader.load(getClass().getResource("TeacherPage.fxml"));
                                stage.setScene(new Scene(root, 516, 388));
                                stage.setTitle("TEACHER PAGE");
                                stage.show();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    }
                }
            } else {

                    if (m.manager.getPassword().equals(getPassword.getText())) {
                        Stage s = (Stage) btn.getScene().getWindow();
                        s.close();
                        try {
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
            if (found == false)
                resultLbl.setText("your user name or password is incorrect");
        }
    }

    public void exitBtn(ActionEvent actionEvent) {
        f.saveToFile();
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeOfPersonnelView = FXCollections.observableArrayList("Student", "Teacher", "Manager");
        logInAsCombo.setItems(typeOfPersonnelView);
    }
}
