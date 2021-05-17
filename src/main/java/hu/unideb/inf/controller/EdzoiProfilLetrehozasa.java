/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.EdzoiProfil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
    
    String file;
    
    File selectedFile;

    
    @FXML
    private void initialize()
    {
        System.out.println(System.getProperty("user.dir"));
        file = "images/noImage.png";
        image.setImage(new Image(file));
    }
    
    @FXML
    void FenykepFeltoltese(ActionEvent event) throws FileNotFoundException 
    {  
        FileChooser fc = new FileChooser();
        
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

        selectedFile = fc.showOpenDialog(null);
        
        if(selectedFile != null)
        {
            file = "file:///" + selectedFile.toString();
            file = file.replace("\\","/");
        
            System.out.println(selectedFile);
            System.out.println(file);
        
            image.setImage(new Image(file));
        }
        else
        {
            selectedFile = new File("images/noImage.png");
            file = "images/noImage.png";
            image.setImage(new Image(file));
        }        
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
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Edzői Profil");
        stage.setScene(scene);
        stage.show();
    }
    
    PreparedStatement preparedStatement;
    FileInputStream fileInputStream;
    
    @FXML
    void mentesButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        if (Nev.getText().length() == 0 || Foglalkozasok1.getText().length() == 0 || VegzettsegEsTapasztalat1.getText().length() == 0 || Bemutatkozas.getText().length() == 0 || SzuletesiDatum.getValue().toString().length() == 0) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Hibás paraméterezés");
            error.setHeaderText("Hiba");
            error.setContentText("Add meg a kért szempontokat!");
            error.show();
        }
        else {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Adatok ellenőrzése");
            confirmation.setHeaderText("Adatok ellenőrzése");
            confirmation.setContentText("Biztosan el akarod menteni?\n" 
                + "\n"
                + "név: " + Nev.getText()+ "\n" 
                + "születési dátum: " + SzuletesiDatum.getValue().toString() + "\n"
                + "foglalkozasok: " + Foglalkozasok1.getText()+ " , " + Foglalkozasok2.getText()+ " , " + Foglalkozasok1.getText()+ "\n"
                + "foglalkozás: " + VegzettsegEsTapasztalat1.getText()+ " , " + VegzettsegEsTapasztalat2.getText() +" , " + VegzettsegEsTapasztalat3.getText() + "\n"
                + "bemutatkozas " + Bemutatkozas.getText() + "\n"
                + "kép: " + file);
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.get() == ButtonType.OK){
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
                if(file.length() != 0)
                {
                    Connection conn = null;
                    PreparedStatement preparedStatement = null;
 
                    String createTableQuery = "create table if not exists IMAGESTORE("
                    + "NAME VARCHAR(255) NOT NULL, "
                    + "IMAGE BLOB NOT NULL, "
                    + "PRIMARY KEY (NAME) )";
 
                    String storeImageQuery ="insert into IMAGESTORE "
                                              + "values (?,?)";
            
                    conn = getConnection();
            
                    preparedStatement = conn.prepareStatement(createTableQuery);
 
                    preparedStatement.execute();
            
                    preparedStatement = conn.prepareStatement(storeImageQuery);
 
                    if(selectedFile != null)
                    {
                        fileInputStream = new FileInputStream(selectedFile);
                    }
                    else
                    {
                        fileInputStream = new FileInputStream("images/noImage.png");
                    }
                    preparedStatement.setString(1,Nev.getText());
            
                    preparedStatement.setBinaryStream(2, fileInputStream,fileInputStream.available());
            
                    preparedStatement.executeUpdate();
            
                    preparedStatement.close();
            
                    conn.close();
 
                }
        
                entityManager.getTransaction().begin();
                entityManager.persist(edzo);
                entityManager.getTransaction().commit(); 
                Nev.clear();
                Foglalkozasok1.clear();
                Foglalkozasok2.clear();
                Foglalkozasok3.clear();
                SzuletesiDatum.getEditor().clear();
                VegzettsegEsTapasztalat1.clear();
                VegzettsegEsTapasztalat2.clear();
                VegzettsegEsTapasztalat3.clear();
                Bemutatkozas.clear();
                image.setImage(null);
            }
        }
   }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/bb_fxml", "sa", "");
    }

}
