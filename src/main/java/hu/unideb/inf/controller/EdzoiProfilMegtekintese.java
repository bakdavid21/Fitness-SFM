package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.EdzoiProfil;
import hu.unideb.inf.model.Foglalkozasok;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

public class EdzoiProfilMegtekintese {

    @FXML
    private ChoiceBox<EdzoiProfil> ChoiceBox;

    @FXML
    private Label edzoNevLabel;

    @FXML
    private Label szuletesiDatumLabel;

    @FXML
    private Label vegzettsegEsTapasztalatokLabel;

    @FXML
    private Label FoglalkozasokLabel;

    @FXML
    private Label bemutatkozasLabel;

    @FXML
    private Rating FelhasznaloiPontozas;
    
    @FXML
    private TableView<?> VelemenyekTábla;
    
    @FXML
    private TableColumn<?, ?> Foglalkozas;

    @FXML
    private TableColumn<?, ?> KapottErtekeles;

    @FXML
    private TableColumn<?, ?> Velemeny;
    
    @FXML
    private Label label;
    
    @FXML
    private Button VisszaButton;
    
    ObservableList<EdzoiProfil> oblist = FXCollections.observableArrayList();
   
    
    
    private void initialize() throws ClassNotFoundException, SQLException {
        System.out.println("SEMMI");
        Connection con = getConnection();
        String keres = "select * from EdzoiProfil";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(keres);
        while(rs.next())
        {                                   
           oblist.add(new EdzoiProfil(rs.getString("NÉV")));
        } 
        ChoiceBox.setItems(oblist);
    }
    
    
    @FXML
    void comboBoxAction(ActionEvent event) throws ClassNotFoundException, SQLException {

    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/aa_fxml", "sa", "");
    }

    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Felhasználói Profil");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProfilMegtekintes(ActionEvent event) throws ClassNotFoundException, SQLException {
        
    }

}
