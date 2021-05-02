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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
        
/**
 *
 * @author Peti
 */
public class EdzoiProfilLetrehozasa {
  


    @FXML
    private TextField Nev;

    @FXML
    private DatePicker SzuletesiDatum;

    @FXML
    private TextField VegzettsegEsTapasztalat1;

    @FXML
    private TextField VegzettsegEsTapasztalat2;

    @FXML
    private TextField VegzettsegEsTapasztalat3;

    @FXML
    private TextField Foglalkozasok2;

    @FXML
    private TextField Foglalkozasok1;

    @FXML
    private TextField Foglalkozasok3;

    @FXML
    private TextArea Bemutatkozas;

    @FXML
    private ImageView image;

    @FXML
    void FenykepFeltoltese(ActionEvent event) {

    }

    @FXML
    void Vissza(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoEdzo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Edzői Profil");
        stage.setScene(scene);
        stage.show();
    }

}
