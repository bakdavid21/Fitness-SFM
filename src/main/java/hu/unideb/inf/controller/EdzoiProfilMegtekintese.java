package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.EdzoiProfil;
import hu.unideb.inf.model.Foglalkozasok;
import hu.unideb.inf.model.VelemenyirasModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
/**
 *
 * @author Peti
 */

public class EdzoiProfilMegtekintese {

    @FXML
    private ChoiceBox<String> ChoiceBox;

    @FXML
    private Label edzoNevLabel;

    @FXML
    private Label szuletesiDatumLabel;

    @FXML
    private Label vegzettsegEsTapasztalatokLabel;

    @FXML
    private Label FoglalkozasokLabel;

    @FXML
    private Label bemutatkozasLabel;

    @FXML
    private Rating FelhasznaloiPontozas;
    
    @FXML
    private TableView<VelemenyirasModel> VelemenyekTábla;
    
    @FXML
    private TableColumn<VelemenyirasModel, String> Foglalkozas;

    @FXML
    private TableColumn<VelemenyirasModel, Double> Ertekeles;

    @FXML
    private TableColumn<VelemenyirasModel, String> Velemeny;
    
    @FXML
    private Label label;
    
    @FXML
    private Button VisszaButton;
    
    ObservableList<EdzoiProfil> oblist = FXCollections.observableArrayList();
    List<EdzoiProfil> oblist2 = new ArrayList();
    ObservableList<String> oblist3 = FXCollections.observableArrayList();
    ObservableList<VelemenyirasModel> oblist4 = FXCollections.observableArrayList();
   
    String nev;
    String edzonev;
    
    private void initialize() throws ClassNotFoundException, SQLException {
        
    }
    
    
    @FXML
    void comboBoxAction(ActionEvent event) throws ClassNotFoundException, SQLException {

    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/aa_fxml", "sa", "");
    }

    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoFelhasznalo.fxml"));
        Stage stage = new Stage();
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Felhasználói Profil");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void ProfilMegtekintes(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        
        
        nev = ChoiceBox.getValue().toString().length() != 0 ? " NÉV = '" + ChoiceBox.getValue().toString() + "'" : " NÉV IS NOT NULL";
        edzonev = ChoiceBox.getValue().toString().length() != 0 ? " EDZONEV = '" + ChoiceBox.getValue().toString()+ "'" : " EDZONEV IS NOT NULL";
        
        if(ChoiceBox.getValue().toString().length() == 0 )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Keresés Hiba");
            alert.setHeaderText(null);
            alert.setContentText("Legalább egy keresési szempontot meg kell adnod!");

            alert.showAndWait();
        }
        else
        {
            try
            {
                edzoNevLabel.setText("");
                szuletesiDatumLabel.setText("");
                bemutatkozasLabel.setText("");
                oblist3.clear();
                oblist4.clear();
                oblist2.clear();
                
                Connection con = getConnection();

                String keres = "select * from EDZOIPROFIL where" + nev;

                System.out.println(keres);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(keres);

                while(rs.next())
                {                                   
                    oblist2.add(new EdzoiProfil(rs.getString("NÉV"), rs.getString("SZULETESIDATUM"), rs.getString("BEMUTATKOZAS")));
                    System.out.println(rs.getString("NÉV"));
                    System.out.println(oblist2.size());
                    System.out.println(oblist2);
                } 

                if(oblist2.isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Keresés Hiba");
                    alert.setHeaderText(null);
                    alert.setContentText("Nem található edzői profil!");

                    alert.showAndWait();
                }
                else
                {
                    var tomb = oblist2.toString().split(",");
                    for (var i : tomb) {
                        System.out.println(i);
                    }
                    String nev = tomb[1].toString().substring(5);
                    edzoNevLabel.setText(nev);
                    String szuletesidatum = tomb[2].toString().substring(16);
                    szuletesiDatumLabel.setText(szuletesidatum);
                    String bemutatkozas = tomb[5].toString().substring(14, tomb[5].length()-2);
                    bemutatkozasLabel.setText(bemutatkozas);
                }
                
                String keres2 = "select * from VELEMENYEK where " + edzonev;
                System.out.println(keres2);
                Connection con2 = getConnection();
                Statement st2 = con2.createStatement();
                ResultSet rs2 = st2.executeQuery(keres2);

                while(rs2.next())
                {                             
                      oblist4.add(new VelemenyirasModel(rs2.getString("FOGLALKOZAS"), rs2.getDouble("ERTEKELES") , rs2.getString("VELEMENY")));

                } 
                if(oblist4.isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Keresés Hiba");
                    alert.setHeaderText(null);
                    alert.setContentText("Nem található vélemény!");

                    alert.showAndWait();
                }
                else
                {
                    Foglalkozas.setCellValueFactory(new PropertyValueFactory<> ("foglalkozas"));
                    Ertekeles.setCellValueFactory(new PropertyValueFactory<> ("ertekeles"));

                    Velemeny.setCellValueFactory(new PropertyValueFactory<> ("velemeny")); 

                    VelemenyekTábla.setItems(oblist4);
                    int szo = oblist4.toString().indexOf("ertekeles") + "ertekeles".length() +1;
                    int szo2 = oblist4.toString().indexOf("velemeny")-2;
                    System.out.println(oblist4.toString().substring(szo, szo2));
                    FelhasznaloiPontozas.setRating(Double.parseDouble(oblist4.toString().substring(szo, szo2)));
                }

            }
            catch (SQLException | ClassNotFoundException ex)
            {
                  System.out.println(ex.getMessage());
            }            
        
    }
    }
    @FXML
    void ProfilBetöltése(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("SEMMI");
        Connection con = getConnection();
        String keres = "select NÉV from EdzoiProfil";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(keres);
        String[] tomb;
        int i = 1;
        while(rs.next())
        {                                   
            oblist.add(new EdzoiProfil(rs.getString("NÉV")));
            tomb = oblist.toString().split(",");
            String nev = tomb[i].toString().substring(5);
            System.out.println(tomb[i].toString().substring(5));
            i+=6;
            oblist3.add(nev); 
        }  
        ChoiceBox.setItems(oblist3);
    }


}
