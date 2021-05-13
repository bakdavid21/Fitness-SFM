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
    private Label vegzettsegEsTapasztalatokLabel1;

    @FXML
    private Label FoglalkozasokLabel1;

    @FXML
    private Label bemutatkozasLabel;

    @FXML
    private Rating FelhasznaloiPontozas;
    
    @FXML
    private Label vegzettsegEsTapasztalatokLabel2;

    @FXML
    private Label vegzettsegEsTapasztalatokLabel3;

    @FXML
    private Label FoglalkozasokLabel2;

    @FXML
    private Label FoglalkozasokLabel3;
    
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
    ObservableList<String> oblist5 = FXCollections.observableArrayList();
    ObservableList<String> oblist6 = FXCollections.observableArrayList();
   
    String nev;
    String edzonev;
    
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
        FelhasznaloiPontozas.setRating(0);
        FelhasznaloiPontozas.setDisable(true);
        
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
                oblist4.clear();
                oblist2.clear();
                oblist5.clear();
                oblist6.clear();
                FelhasznaloiPontozas.setRating(0);
                
                
                Connection con = getConnection();

                String keres = "select * from EDZOIPROFIL where" + nev;

                System.out.println(keres);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(keres);
                var id=0;

                while(rs.next())
                {                                   
                    oblist2.add(new EdzoiProfil(rs.getString("NÉV"), rs.getString("SZULETESIDATUM"), rs.getString("BEMUTATKOZAS")));
                    System.out.println(rs.getString("NÉV"));
                    System.out.println(oblist2.size());
                    System.out.println(oblist2);
                    id = rs.getInt("ID");
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
                String edzoid = " EDZOIPROFIL_ID = '" + id + "'";
                String keres3 = "SELECT * FROM EDZOIPROFIL_FOGLALKOZASOK where " + edzoid;
                System.out.println(keres3);
                Connection con3 = getConnection();
                Statement st3 = con3.createStatement();
                ResultSet rs3 = st3.executeQuery(keres3);
                
                while(rs3.next())
                {                             
                      oblist5.add(rs3.getString("FOGLALKOZASOK"));
                      System.out.println(oblist5);
                } 

                var tomb = oblist5.toString().split(",");
                FoglalkozasokLabel1.setText(tomb[0].substring(1));
                FoglalkozasokLabel2.setText(tomb[1]);
                FoglalkozasokLabel3.setText(tomb[2].substring(0, tomb[2].length()-1));
                
                String keres4 = "SELECT * FROM EDZOIPROFIL_TAPASZTALATOK where " + edzoid;
                System.out.println(keres4);
                Connection con4 = getConnection();
                Statement st4 = con4.createStatement();
                ResultSet rs4 = st4.executeQuery(keres4);
                while(rs4.next())
                {                             
                      oblist6.add(rs4.getString("tapasztalatok"));
                      System.out.println(oblist6);
                }
                var tomb2 = oblist6.toString().split(",");
                vegzettsegEsTapasztalatokLabel1.setText(tomb2[0].substring(1));
                vegzettsegEsTapasztalatokLabel2.setText(tomb2[1]);
                vegzettsegEsTapasztalatokLabel3.setText(tomb2[2].substring(0, tomb2[2].length()-1));
                
                

            }
            catch (SQLException | ClassNotFoundException ex)
            {
                  System.out.println(ex.getMessage());
            }            
        
        }
    }
}
