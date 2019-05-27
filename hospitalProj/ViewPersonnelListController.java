import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewPersonnelListController implements Initializable {
    public Button btn;
    public ListView listviewfx;
    public ListView listview;

    Main m = new Main();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i = 0 ; i < m.t.doctors.size() ; i++) {
            listviewfx.getItems().addAll(m.t.doctors.get(i).toString());
        }
        for(int i = 0 ; i < m.t.nurses.size() ; i++) {
            listviewfx.getItems().addAll(m.t.nurses.get(i).toString());
        }

    }
}
