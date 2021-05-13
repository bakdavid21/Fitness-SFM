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

import hu.unideb.inf.model.Foglalkozasok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class Terembeosztas {

    @FXML
    private TextArea hetfo10;

    @FXML
    private TextArea kedd8;

    @FXML
    private TextArea kedd10;

    @FXML
    private TextArea hetfo12;

    @FXML
    private TextArea kedd12;

    @FXML
    private TextArea hetfo14;

    @FXML
    private TextArea kedd14;

    @FXML
    private TextArea szerda8;

    @FXML
    private TextArea szerda10;

    @FXML
    private TextArea szerda12;

    @FXML
    private TextArea szerda14;

    @FXML
    private TextArea kedd16;

    @FXML
    private TextArea hetfo16;

    @FXML
    private TextArea hetfo18;

    @FXML
    private TextArea kedd18;

    @FXML
    private TextArea szerda18;

    @FXML
    private TextArea szerda16;

    @FXML
    private TextArea csutortok8;

    @FXML
    private TextArea pentek8;

    @FXML
    private TextArea szombat8;

    @FXML
    private TextArea vasarnap8;

    @FXML
    private TextArea csutortok10;

    @FXML
    private TextArea pentek10;

    @FXML
    private TextArea szombat10;

    @FXML
    private TextArea vasarnap10;

    @FXML
    private TextArea csutortok12;

    @FXML
    private TextArea csutortok14;

    @FXML
    private TextArea csutortok16;

    @FXML
    private TextArea pentek12;

    @FXML
    private TextArea csutortok18;

    @FXML
    private TextArea pentek14;

    @FXML
    private TextArea szombat14;

    @FXML
    private TextArea szombat12;

    @FXML
    private TextArea vasarnap12;

    @FXML
    private TextArea vasarnap14;

    @FXML
    private TextArea szombat16;

    @FXML
    private TextArea pentek16;

    @FXML
    private TextArea pentek18;

    @FXML
    private TextArea szombat18;

    @FXML
    private TextArea vasarnap16;

    @FXML
    private TextArea vasarnap18;

    @FXML
    private TextArea hetfo8;

    @FXML
    private TextArea hetfo20;

    @FXML
    private TextArea kedd20;

    @FXML
    private TextArea szerda20;

    @FXML
    private TextArea csutortok20;

    @FXML
    private TextArea pentek20;

    @FXML
    private TextArea szombat20;

    @FXML
    private TextArea vasarnap20;
    
    ObservableList<Foglalkozasok> oblist = FXCollections.observableArrayList();
    ObservableList<String> oblist2 = FXCollections.observableArrayList();

    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/aa_fxml", "sa", "");
    }
    
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
        hetfo8.setDisable(true);
        kedd8.setDisable(true);
        szerda8.setDisable(true);
        csutortok8.setDisable(true);
        pentek8.setDisable(true);
        szombat8.setDisable(true);
        vasarnap8.setDisable(true);
        hetfo10.setDisable(true);
        kedd10.setDisable(true);
        szerda10.setDisable(true);
        csutortok10.setDisable(true);
        pentek10.setDisable(true);
        szombat10.setDisable(true);
        vasarnap10.setDisable(true);
        hetfo12.setDisable(true);
        kedd12.setDisable(true);
        szerda12.setDisable(true);
        csutortok12.setDisable(true);
        pentek12.setDisable(true);
        szombat12.setDisable(true);
        vasarnap12.setDisable(true);
        hetfo14.setDisable(true);
        kedd14.setDisable(true);
        szerda14.setDisable(true);
        csutortok14.setDisable(true);
        pentek14.setDisable(true);
        szombat14.setDisable(true);
        vasarnap14.setDisable(true);
        hetfo16.setDisable(true);
        kedd16.setDisable(true);
        szerda16.setDisable(true);
        csutortok16.setDisable(true);
        pentek16.setDisable(true);
        szombat16.setDisable(true);
        vasarnap16.setDisable(true);
        hetfo18.setDisable(true);
        kedd18.setDisable(true);
        szerda18.setDisable(true);
        csutortok18.setDisable(true);
        pentek18.setDisable(true);
        szombat18.setDisable(true);
        vasarnap18.setDisable(true);
        hetfo20.setDisable(true);
        kedd20.setDisable(true);
        szerda20.setDisable(true);
        csutortok20.setDisable(true);
        pentek20.setDisable(true);
        szombat20.setDisable(true);
        vasarnap20.setDisable(true);
    }
}

