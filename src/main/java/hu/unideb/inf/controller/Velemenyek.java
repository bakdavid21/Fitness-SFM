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
import hu.unideb.inf.model.VelemenyirasModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Velemenyek {

    @FXML
    private TableView<VelemenyirasModel> Velemenyek;

    @FXML
    private TableColumn<VelemenyirasModel, String> VelemenyezoNeve;

    @FXML
    private TableColumn<VelemenyirasModel, String> EdzoNeve;

    @FXML
    private TableColumn<VelemenyirasModel, String> Foglalkozas;

    @FXML
    private TableColumn<VelemenyirasModel, Double> Ertekeles;

    @FXML
    private TableColumn<VelemenyirasModel, String> Velemeny;
    
    ObservableList<VelemenyirasModel> oblist = FXCollections.observableArrayList();

    String keres = "select * from VELEMENYEK";
    

    @FXML 
    private void initialize() throws SQLException, ClassNotFoundException 
    {        
        Connection con = getConnection();
        DatabaseMetaData dbm = con.getMetaData();
        Statement st = con.createStatement();
        //ResultSet rs = st.executeQuery(keres);
        ResultSet rs = dbm.getTables(null, null, "VELEMENYEK", null);
        if(rs.next())
        {
            rs = st.executeQuery(keres);
            while(rs.next())
            {                                   
                DecimalFormat df = new DecimalFormat("#.##");
                oblist.add(new VelemenyirasModel(rs.getString("BECENEV"), rs.getString("EDZONEV"), rs.getString("FOGLALKOZAS"), rs.getDouble("ERTEKELES") , rs.getString("VELEMENY")));
            } 
        
            //VelemenyezoNeve.setCellValueFactory(new PropertyValueFactory<> ("becenev"));
            
            VelemenyezoNeve.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBeceNev()));
            EdzoNeve.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEdzoNev()));
            Foglalkozas.setCellValueFactory(new PropertyValueFactory<> ("foglalkozas"));
            Ertekeles.setCellValueFactory(new PropertyValueFactory<> ("ertekeles"));            
            Velemeny.setCellValueFactory(new PropertyValueFactory<> ("velemeny")); 

            Velemenyek.setItems(oblist);
        }
    }
    
    @FXML
    void VelemenyIrasa(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/Velemenyiras.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Vélemény írása");
        stage.setScene(scene);
        stage.show();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/bb_fxml", "sa", "");
    }
    
    @FXML
    private Button VisszaButton;
    
    
    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        stage.setResizable(false);
        
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Foglalkozások keresése");
        stage.setScene(scene);
        stage.show();
    }

}
