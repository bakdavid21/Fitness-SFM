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
public class KepernyoFelhasznalo {
    
    @FXML
    private Button EdzokMegtekinteseButton;

    @FXML
    void EdzokMegtekinteseButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/EdzoiProfilMegtekintese.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) EdzokMegtekinteseButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Edzői profilok megtekintése");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Button FoglalkozasKereseseButton;

    @FXML
    void FoglalkozasKereseseButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Kereses.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) FoglalkozasKereseseButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Foglalkozások keresése");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private Button TerembeosztasokMegtekinteseButton;

    @FXML
    void TerembeosztasokMegtekinteseButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Konditerem.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) TerembeosztasokMegtekinteseButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Terembeosztások megtekintése");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private Button VelemenyekButton;

    @FXML
    void VelemenyekButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Velemenyek.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VelemenyekButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Vélemények megtekintése");
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

}

