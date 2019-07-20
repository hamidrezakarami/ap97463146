package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {
    public TextField getCourseId;
    Main m = new Main();

    GetPassPageController g = new GetPassPageController();
    public AnchorPane btn;
    public ListView allCourseList;
    public ListView myCourseList;
    public Label studentName;
    public Label StudentId;
    public Label resultLbl;
    private int num = g.number;


    boolean found;
    boolean has;

    public void addCourseBtn(ActionEvent actionEvent) {
        found = false;
        has = false;
        if (getCourseId.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {
            for(int i = 0 ; i<m.studentlist.get(num).corses.size(); i++){
                if(m.studentlist.get(num).corses.get(i).getCourseid() == Integer.parseInt(getCourseId.getText()))
                    has = true;
            }
            for (int i = 0; i < m.corselist.size(); i++) {
                if (m.corselist.get(i).getCourseid() == Integer.parseInt(getCourseId.getText()) && !has) {
                    found = true;
                    //for (int k = 0 ; k < m.teacherlist.size() ; k++){
                    //if (m.teacherlist.get(k).getPersonnleid() == m.corselist.get(i).teacher.getPersonnleid()){

                    m.studentlist.get(num).corses.add(m.corselist.get(i));
                    m.corselist.get(i).studentlist.add(m.studentlist.get(num));
                    myCourseList.getItems().addAll(m.studentlist.get(num).corses.get(i));
                    resultLbl.setText("Course Successfuly Saved");
                }
            }
            if (!found) {
                resultLbl.setText("!! Course can not found !!");
            }
            if(has)
                resultLbl.setText("!! this course have been added !!");
        }
    }

    public void removeCourseBtn(ActionEvent actionEvent) {
        found = false;
        if (getCourseId.getText().equals("")) {
            resultLbl.setText("!! Please complete text field !!");
        } else {
            for (int i = 0; i < m.studentlist.get(num).corses.size(); i++) {
                if (m.studentlist.get(num).corses.get(i).getCourseid() == Integer.parseInt(getCourseId.getText())) {
                    found = true;
                    m.studentlist.get(num).corses.remove(i);
                    m.corselist.get(i).studentlist.remove(m.studentlist.get(num));

                    resultLbl.setText("Course Successfuly Removed"+m.studentlist.get(num).corses.get(i).saveToFile());
                }
            }
            if (!found)
                resultLbl.setText("!! Course can not found !!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentName.setText(m.studentlist.get(num).getName() + m.studentlist.get(num).getSurname());
        StudentId.setText(String.valueOf(m.studentlist.get(num).getStudentid()));
        for (int i = 0; i < m.corselist.size(); i++) {
            allCourseList.getItems().addAll(m.corselist.get(i).toString());
        }
        for (int i = 0 ; i < m.studentlist.get(num).corses.size() ; i++){
            myCourseList.getItems().addAll(m.studentlist.get(num).corses.get(i));
        }
    }

    public void backToMenuBtn(ActionEvent actionEvent) {
        ////////////////////////////////for close page
        Stage s = (Stage) btn.getScene().getWindow();
        s.close();
        /////////////////////////////////
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GetPassPage.fxml"));
            stage.setScene(new Scene(root, 335, 221));
            stage.setTitle("Menu");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
