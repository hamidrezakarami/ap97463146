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

public class ReportCourseController implements Initializable {

    Main m = new Main();


    public Button btn;
    public ListView courseList;
    public TextField getIdForSearch;
    public Label resulrLbl;


    public void backBtn(ActionEvent actionEvent) {
        try {
            //////////////////////////////////for close page
            Stage s = (Stage) btn.getScene().getWindow();
            s.close();
            /////////////////////////////////
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Managerpage.fxml"));
            stage.setScene(new Scene(root, 200, 338));
            stage.setTitle("Manager Page");
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < m.corselist.size(); i++) {
            courseList.getItems().addAll(m.corselist.get(i));
        }
    }

    public void showCourseBtn(ActionEvent actionEvent) {
    }
}
