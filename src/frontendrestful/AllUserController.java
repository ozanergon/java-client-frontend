package frontendrestful;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AllUserController {

    @FXML
    private TableView<User> user;

    @FXML
    private TableColumn<User, String> idUser;
    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, String> gender;
    @FXML
    private TableColumn<User, String> address;
    @FXML
    private Button load;

    private ObservableList<User> data;
    

    @FXML
    public void initialize() throws IOException, ParseException {

        String urlStr = ConnToBackend.host+ConnToBackend.service+ConnToBackend.getUserList;
        URL urll = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = br.readLine();
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(line.toString());

        data = FXCollections.observableArrayList();
        for (int a = 0; a < json.size(); a++) {
            JSONObject obj2 = (JSONObject) json.get(a);
            data.add(new User(obj2.get("idUser").toString(), obj2.get("name").toString(), obj2.get("gender").toString(), obj2.get("address").toString()));
        }

        idUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        user.setItems(null);
        user.setItems(data);
    }
}
