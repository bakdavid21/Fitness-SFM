package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

public class EdzoiProfilMegtekintese {

    @FXML
    private ChoiceBox<String> ChoiceBox;

    @FXML
    private TextField EdzoNev;

    @FXML
    private TextField SzuletesiDatum;

    @FXML
    private TextArea Tapasztalatok;

    @FXML
    private TextArea Foglalkozasok;

    @FXML
    private TextArea Bemutatkozas;

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
    void Vissza(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Felhasználói Profil");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ProfilMegtekintes(ActionEvent event) {

    }

}
