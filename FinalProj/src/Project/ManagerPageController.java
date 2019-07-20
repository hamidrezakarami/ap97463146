package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManagerPageController {
    public Button btn;

    public void newCorseFx(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("NewCorse.fxml"));
            stage.setScene(new Scene(root, 287, 340));
            stage.setTitle("NEW CORSE");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void addTeacherFx(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AddTeacher.fxml"));
            stage.setScene(new Scene(root, 352, 300));
            stage.setTitle("ADD TEACHER");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void addStudentFx(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
            stage.setScene(new Scene(root, 340, 300));
            stage.setTitle("ADD STUDENT");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void reportCorseFx(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ReportCourse.fxml"));
            stage.setScene(new Scene(root, 510, 270));
            stage.setTitle("REPORT COURSES");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void backToMenuBtn(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GetPassPage.Fxml"));
            stage.setScene(new Scene(root, 510, 270));
            stage.setTitle("REPORT COURSES");
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
