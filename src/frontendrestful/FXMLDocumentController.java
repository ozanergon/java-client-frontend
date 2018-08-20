package frontendrestful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;


public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField idUser;
    @FXML
    private TextField address;
    @FXML
    private TextField gender;

    @FXML
    private void saveDataUser(ActionEvent event) {
        JSONObject json = new JSONObject();
        json.put("name", name.getText());
        json.put("idUser", Integer.getInteger(idUser.getText()));
        json.put("address", address.getText());
        json.put("gender", gender.getText());

        try {
            URL url = new URL("http://localhost:8080/TestRestful/webresources/user/saveDataUser");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            
            
            
            wr.write(json.toJSONString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if (in.readLine().equalsIgnoreCase("success")) {
                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("AllUser"));
                } catch (IOException ex) {

                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setAlwaysOnTop(true);
                stage.setIconified(false);
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.setMaximized(false);
                stage.show();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
