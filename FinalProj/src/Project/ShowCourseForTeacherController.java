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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowCourseForTeacherController implements Initializable {

    Main m = new Main();
    TeacherPageController t = new TeacherPageController();

    public Button btn;
    public ListView studentlist;
    public Label resultLbl;
    public TextField getScore;
    public TextField getStudentId;
    public Label courseName;

    int num = t.coursenumber;

    public void addScoreBtn(MouseEvent mouseEvent) {
        if (getScore.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {

        }
    }

    boolean found;

    public void removeStudentBtn(ActionEvent actionEvent) {
        found = false;
        if (getStudentId.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {
            for (int i = 0; i < m.corselist.get(num).studentlist.size(); i++) {
                if (m.corselist.get(num).studentlist.get(i).getStudentid() == Long.parseLong(getStudentId.getText())) {
                    found = true;
                    m.corselist.get(num).studentlist.remove(i);
                    for (int j = 0; j < m.studentlist.size(); j++) {
                        if (m.studentlist.get(j).getStudentid() == Long.parseLong(getStudentId.getText())) {
                            for (int k = 0; k < m.studentlist.get(j).corses.size(); k++) {
                                if (m.studentlist.get(j).corses.get(k).getCourseid() == m.corselist.get(num).getCourseid()) {
                                    m.studentlist.get(j).corses.remove(k);
                                    resultLbl.setText("Student Successfuly Removed");
                                }
                            }
                        }
                    }
                }
            }if (!found)
                resultLbl.setText("Can not found Student");
        }
    }

    public void backToLastPage(ActionEvent actionEvent) {
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TeacherPage.fxml"));
            stage.setScene(new Scene(root, 516, 387));
            stage.setTitle("TEACHER PAGE");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseName.setText(m.corselist.get(num).getName());
        for (int i = 0; i < m.corselist.get(num).studentlist.size(); i++) {
            studentlist.getItems().addAll(m.corselist.get(num).studentlist.get(i).toString());
        }

    }
}
