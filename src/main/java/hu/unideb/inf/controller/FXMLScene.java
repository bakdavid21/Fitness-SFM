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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;

/**
 *
 * @author varad
 */
public class FXMLScene 
{
    
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
    private TextArea edzoText_1;

    @FXML
    private TextArea edzoText_2;

    @FXML
    private TextArea edzoText_3;

    @FXML
    private TextArea edzoText_4;

    @FXML
    private TextArea kondiText_1;

    @FXML
    private TextArea kondiText_2;

    @FXML
    private TextArea kondiText_3;

    @FXML
    private TextArea kondiText_4;

    @FXML
    private TextArea foglalkText_1;

    @FXML
    private TextArea foglalkText_2;

    @FXML
    private TextArea foglalkText_3;

    @FXML
    private TextArea foglalkText_4;

    @FXML
    private TextArea datumText_1;

    @FXML
    private TextArea datumText_2;

    @FXML
    private TextArea datumText_3;

    @FXML
    private TextArea datumText_4;

    @FXML
    private TextArea idopText_1;

    @FXML
    private TextArea idopText_2;

    @FXML
    private TextArea idopText_3;

    @FXML
    private TextArea idopText_4;

    @FXML
    private TextArea letszamText_1;

    @FXML
    private TextArea letszamText_2;

    @FXML
    private TextArea letszamText_3;

    @FXML
    private TextArea letszamText_4;
    
    @FXML
    void keres(ActionEvent event) 
    {    
       List<String> list = new ArrayList();
        
        try(Connection con = getConnection())
        {
            if(edzoKeresText.getLength() != 0)
            {
                String keres = "select * from REGISTRATION where NÉV = '" + edzoKeresText.getText() + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(keres);
                while(rs.next())
                {
                   list.add(rs.getString("NÉV"));
                   list.add(rs.getString("KONDITEREM"));
                   list.add(rs.getString("FOGLALKOZAS"));
                   list.add(rs.getString("IDOPONT"));
                   list.add(rs.getString("FOGLALKOZASNAPJA"));
                   list.add(rs.getString("HANYFO"));
                }
                
               System.out.println(Arrays.asList(list.toArray()));
               
               edzoText_1.setText(list.get(0));
               kondiText_1.setText(list.get(1));
               foglalkText_1.setText(list.get(2));
               datumText_1.setText(list.get(3));
               idopText_1.setText(list.get(4));
               letszamText_1.setText(list.get(5));

            } 
        }
        catch (SQLException | ClassNotFoundException ex)
        {
              System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    void ujra(ActionEvent event) {

    }

    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/aa_fxml", "sa", "");
    }
    
}
