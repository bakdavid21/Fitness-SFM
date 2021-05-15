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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class KepernyoEdzo {
    
    @FXML
    private Button EdzoiProfilLetrehozasaButton;
    
    @FXML
    private VBox vbox;
    

    @FXML
    void EdzoiProfilLetrehozasaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/EdzoiProfilLetrehozasa.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) EdzoiProfilLetrehozasaButton.getScene().getWindow();
        stage2.close();
        Scene scene = new Scene(loader.load());
        stage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Edzői profil létrehozása");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Button FoglalkozasFelviteleButton;

    @FXML
    void FoglalkozasFelviteleButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Foglalkozasfelvitele.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) FoglalkozasFelviteleButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Edzői felület");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Button VisszaButton;

    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Kezdokepernyo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Fitness Terem alkalmazás");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button foglalkozasKereseseButton;
    
    @FXML
    void foglalkozasKereseseButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KeresesEdzo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) foglalkozasKereseseButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        stage.setTitle("Edzői felület");
        stage.setScene(scene);
        stage.show();
    }
}

