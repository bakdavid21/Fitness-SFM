/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;
import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Foglalkozasok;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Peti
 */
public class KeresesEdzo {
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
    private TextField napKeresText;

    @FXML
    private TextField letszamKeresText;
    
    @FXML
    private TableView<Foglalkozasok> tableView;

    @FXML
    private TableColumn<Foglalkozasok, String> edzoCol;

    @FXML
    private TableColumn<Foglalkozasok, String> foglalkCol;

    @FXML
    private TableColumn<Foglalkozasok, String> kondiCol;

    @FXML
    private TableColumn<Foglalkozasok, String> teremCol;

    @FXML
    private TableColumn<Foglalkozasok, String> idopCol;

    @FXML
    private TableColumn<Foglalkozasok, String> napCol;

    @FXML
    private TableColumn<Foglalkozasok, Integer> letszamCol;
    
    ObservableList<Foglalkozasok> oblist = FXCollections.observableArrayList();
    
    String edzo;
    String ido;
    String foglalk;
    String nap;
    String letszam;

    @FXML
    void keres(ActionEvent event) 
    {    
        tableView.getItems().clear();
        
        edzo = edzoKeresText.getText().length() != 0 ? " NÉV = '" + edzoKeresText.getText() + "'" : " NÉV IS NOT NULL";
        ido = idopKeresText.getText().length() != 0 ? " AND IDOPONT = '" + idopKeresText.getText() + "'" : " AND IDOPONT IS NOT NULL";
        foglalk = foglalkKeresText.getText().length() != 0 ? " AND FOGLALKOZAS = '" + foglalkKeresText.getText() + "'" : " AND FOGLALKOZAS IS NOT NULL";
        nap = napKeresText.getText().length() != 0 ? " AND FOGLALKOZASNAPJA = '" + napKeresText.getText() + "'" : " AND FOGLALKOZAS IS NOT NULL";
        letszam = letszamKeresText.getText().length() != 0 ? " AND HANYFO = '" + letszamKeresText.getText() + "'" : " AND FOGLALKOZAS IS NOT NULL";
        
        if(edzoKeresText.getText().length() == 0 && idopKeresText.getText().length() == 0 && foglalkKeresText.getText().length() == 0 && napKeresText.getText().length() == 0 && letszamKeresText.getText().length() == 0 )
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
                String keres = "select * from FOGLALKOZASOK where " + edzo + ido + foglalk + nap + letszam;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(keres);
                
                while(rs.next())
                {                                   
                    oblist.add(new Foglalkozasok(rs.getString("NÉV"), rs.getString("KONDITEREM"), rs.getString("HELYSZIN"), rs.getString("FOGLALKOZAS"), rs.getString("FOGLALKOZASNAPJA"), rs.getString("IDOPONT"), rs.getInt("HANYFO")));
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
        return DriverManager.getConnection("jdbc:h2:file:~/bb_fxml", "sa", "");
    }
    
    @FXML
    private Button VisszaButton;
    
    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoEdzo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        stage.setTitle("Edzői profil");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void torlesButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
        int pos = tableView.getSelectionModel().getSelectedIndex();

        Foglalkozasok fog = tableView.getItems().get(pos);
        
        System.out.println(fog.getTime());
        
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String torol = "DELETE FROM FOGLALKOZASOK WHERE NÉV = '" + fog.getName() + "' AND FOGLALKOZAS = '" + fog.getExercise() + "' AND HELYSZIN = '" + fog.getLocation() + "' AND IDOPONT = '" + fog.getTime()+ "' AND FOGLALKOZASNAPJA = '" + fog.getDateOfExercise() + "' AND HANYFO = '" + fog.getAmountOfPeople() + "' AND KONDITEREM = '" + fog.getGym() + "'";
        int deleteCount = stmt.executeUpdate(torol);
        
        fog = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(fog);
        
        System.out.println(fog);
    }

}

