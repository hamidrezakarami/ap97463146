package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherPageController implements Initializable {
    Main m = new Main();
    GetPassPageController g = new GetPassPageController();
    int num = g.number;
    public ListView courseList;
    public TextField getCourseId;
    public Button btn;
    public Label resultLbl;
    public Label teachetName;
    public Label teacherId;

    static int coursenumber;
    boolean found;
    public void showCourseBtn(ActionEvent actionEvent) {
        found = false;
        if (getCourseId.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {
            for (int i = 0 ; i <  m.teacherlist.get(num).corses.size() ; i++){
                if(m.teacherlist.get(num).corses.get(i).getCourseid() == Integer.parseInt(getCourseId.getText())){
                   found = true;
                   coursenumber = i;
                    Stage s = (Stage) btn.getScene().getWindow();
                    s.close();
                    try {
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("ShowCourseForTeacher.fxml"));
                        stage.setScene(new Scene(root, 500, 500));
                        stage.setTitle("Course");
                        stage.show();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }if(!found)
                resultLbl.setText("!! Course can not found !!");
        }
    }

    public void backBtn(ActionEvent actionEvent) {
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GetPassPage.fxml"));
            stage.setScene(new Scene(root, 334, 220));
            stage.setTitle("Menu");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teachetName.setText(m.teacherlist.get(num).getName()+ " " +m.teacherlist.get(num).getSurname());
        teacherId.setText(String.valueOf(m.teacherlist.get(num).getPersonnleid()));
        for (int i = 0 ; i < m.teacherlist.get(num).corses.size() ; i++){
            courseList.getItems().addAll(m.teacherlist.get(num).corses.get(i));
        }
    }
}
