/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;


import hu.unideb.inf.model.Registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author varad
 */
public class FXMLScene 
{

    @FXML
    private TabPane tabPane;
    
    @FXML
    private Button keresButton;

    @FXML
    private Button ujraButton;
    
    @FXML
    private TextField edzoKeresText;

    @FXML
    private TextField idopKeresText;

    @FXML
    private TextField foglalkKeresText;
    
    @FXML
    private TableView<Registration> tableView;

    @FXML
    private TableColumn<Registration, String> edzoCol;

    @FXML
    private TableColumn<Registration, String> foglalkCol;

    @FXML
    private TableColumn<Registration, String> kondiCol;

    @FXML
    private TableColumn<Registration, String> teremCol;

    @FXML
    private TableColumn<Registration, String> idopCol;

    @FXML
    private TableColumn<Registration, String> napCol;

    @FXML
    private TableColumn<Registration, Integer> letszamCol;
    
    ObservableList<Registration> oblist = FXCollections.observableArrayList();
    
    String edzo;
    String ido;
    String foglalk;

    @FXML
    void keres(ActionEvent event) 
    {    
        //List<String> list = new ArrayList();
        edzo = edzoKeresText.getText().length() != 0 ? " NÉV = '" + edzoKeresText.getText() + "'" : " NÉV IS NOT NULL";
        ido = idopKeresText.getText().length() != 0 ? " AND IDOPONT = '" + idopKeresText.getText() + "'" : " AND IDOPONT IS NOT NULL";
        foglalk = foglalkKeresText.getText().length() != 0 ? " AND FOGLALKOZAS = '" + foglalkKeresText.getText() + "'" : " AND FOGLALKOZAS IS NOT NULL";
        
        if(edzoKeresText.getText().length() == 0 && idopKeresText.getText().length() == 0 && foglalkKeresText.getText().length() == 0)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Keresés Hiba");
            alert.setHeaderText(null);
            alert.setContentText("Legalább egy keresési szempontot meg kell adnod!");

            alert.showAndWait();
        }
        else
        {
            try
            {
                Connection con = getConnection();
                String keres = "select * from REGISTRATION where " + edzo + ido + foglalk;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(keres);
                
                while(rs.next())
                {                                   
                    oblist.add(new Registration(rs.getString("NÉV"), rs.getString("KONDITEREM"), rs.getString("HELYSZIN"), rs.getString("FOGLALKOZAS"), rs.getString("FOGLALKOZASNAPJA"), rs.getString("IDOPONT"), rs.getInt("HANYFO")));
                } 

                if(oblist.isEmpty())
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Keresés Hiba");
                    alert.setHeaderText(null);
                    alert.setContentText("Nem található a keresésnek megfelelő elem!");

                    alert.showAndWait();
                }
                else
                {
                    edzoCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                    foglalkCol.setCellValueFactory(new PropertyValueFactory<>("exercise"));
                    kondiCol.setCellValueFactory(new PropertyValueFactory<>("gym"));
                    teremCol.setCellValueFactory(new PropertyValueFactory<>("location"));
                    idopCol.setCellValueFactory(new PropertyValueFactory<>("time"));
                    napCol.setCellValueFactory(new PropertyValueFactory<>("dateOfExercise"));
                    letszamCol.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
            
                    tableView.setItems(oblist);
                }
            }
            catch (SQLException | ClassNotFoundException ex)
            {
                  System.out.println(ex.getMessage());
            }            
        }
    }    

    @FXML
    void ujra(ActionEvent event) 
    {
        tableView.getItems().clear();
        edzoKeresText.clear();
        idopKeresText.clear();
        foglalkKeresText.clear();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/aa_fxml", "sa", "");
    }
    
}
