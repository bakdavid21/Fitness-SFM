/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

/**
 *
 * @author Peti
 */
import hu.unideb.inf.MainApp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Velemenyek {

    @FXML
    private TableView<?> Velemenyek;

    @FXML
    private TableColumn<?, ?> VelemenyezoNeve;

    @FXML
    private TableColumn<?, ?> EdzoNeve;

    @FXML
    private TableColumn<?, ?> Foglalkozas;

    @FXML
    private TableColumn<?, ?> Ertekeles;

    @FXML
    private TableColumn<?, ?> Velemeny;

    @FXML
    void VelemenyIrasa(ActionEvent event) {

    }

    @FXML
    void Vissza(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Foglalkozások keresése");
        stage.setScene(scene);
        stage.show();
    }

}
