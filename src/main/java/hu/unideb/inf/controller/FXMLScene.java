/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextArea talalatText;
    
    String edzo;
    String ido;
    String foglalk;
    
    List<String> list = new ArrayList();
    
    private StringBuilder sb;
    
    //tabPane.autosize();

    @FXML
    void keres(ActionEvent event) 
    {    
        //List<String> list = new ArrayList();
        sb  = new StringBuilder("");
        edzo = edzoKeresText.getText().length() != 0 ? " NÉV = '" + edzoKeresText.getText() + "'" : " NÉV IS NOT NULL";
        ido = idopKeresText.getText().length() != 0 ? " AND IDOPONT = '" + idopKeresText.getText() + "'" : " AND IDOPONT IS NOT NULL";
        foglalk = foglalkKeresText.getText().length() != 0 ? " AND FOGLALKOZAS = '" + foglalkKeresText.getText() + "'" : " AND FOGLALKOZAS IS NOT NULL";

        try
        {
            Connection con = getConnection();
            String keres = "select * from REGISTRATION where " + edzo + ido + foglalk;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(keres);
            //ObservableList<String> row = FXCollections.observableArrayList();
            //row.add(rs.getString("NÉV"))
            while(rs.next())
            {                
                sb.append("Edző: " + rs.getString("NÉV")+ "\t");
                sb.append("Foglalkozás: " + rs.getString("FOGLALKOZAS")+ "\t");
                sb.append("Konditerem: " + rs.getString("Konditerem") + "\t");
                sb.append("Max létszám: " + rs.getString("HANYFO") + "\t" );
                sb.append("Terem/szoba : " + rs.getString("HELYSZIN") + "\t");;
                sb.append("Dátum: " + rs.getString("IDOPONT") + "\t");
                sb.append( "Foglalkozás napja: " + rs.getString("FOGLALKOZASNAPJA") + "\n\n");
            } 
            
            talalatText.setText(sb.toString());
        }
        catch (SQLException | ClassNotFoundException ex)
        {
              System.out.println(ex.getMessage());
        }
         
    }
    
    

    @FXML
    void ujra(ActionEvent event) 
    {
        talalatText.clear();
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
