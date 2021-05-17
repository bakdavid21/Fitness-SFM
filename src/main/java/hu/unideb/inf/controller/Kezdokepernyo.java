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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Peti
 */
public class Kezdokepernyo {
    
    @FXML
    private Button edzoButton;
    
    @FXML
    void edzoButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoEdzo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) edzoButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Edzői felület");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Button felhasznaloButton;
    
    @FXML
    void felhasznaloButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) felhasznaloButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Felhasználói felület");
        stage.setScene(scene);
        stage.show();
    }

}
