/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Peti
 */
public class KepernyoFelhasznalo {

    @FXML
    void EdzőkMegtekintése(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/EdzoiProfilMegtekintese.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Edzői profilok megtekintése");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FoglalkozasKeresese(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Kereses.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Foglalkozások keresése");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void TerembeosztasokMegtekintese(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Terembeosztasok.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Terembeosztások megtekintése");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void Velemenyek(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Velemenyek.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Vélemények megjelenitése");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void Vissza(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Kezdokepernyo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Fitness Terem alkalmazás");
        stage.setScene(scene);
        stage.show();

    }

}

