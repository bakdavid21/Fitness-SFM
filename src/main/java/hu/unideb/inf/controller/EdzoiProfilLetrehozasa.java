/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.EdzoiProfil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
        
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
    private Button VisszaButton;
    
    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoEdzo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Edzői Profil");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void mentesButtonAction(ActionEvent event) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        EdzoiProfil edzo = new EdzoiProfil();
        edzo.setNev(Nev.getText());
        List<String> foglalkozas = List.of(Foglalkozasok1.getText(), Foglalkozasok2.getText(), Foglalkozasok3.getText());
        edzo.setFoglalkozasok(foglalkozas);
        List<String> tapasztalat = List.of(VegzettsegEsTapasztalat1.getText(), VegzettsegEsTapasztalat2.getText(), VegzettsegEsTapasztalat3.getText());
        edzo.setTapasztalatok(tapasztalat);
        edzo.setSzuletesiDatum(SzuletesiDatum.getValue().toString());
        edzo.setBemutatkozas(Bemutatkozas.getText());
        entityManager.getTransaction().begin();
        entityManager.persist(edzo);
        entityManager.getTransaction().commit(); 
    }

}
