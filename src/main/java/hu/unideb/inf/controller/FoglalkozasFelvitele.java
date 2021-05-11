package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Foglalkozasok;
import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;



public class FoglalkozasFelvitele {
    ObservableList<String> foglalkozasnapjaList = FXCollections.observableArrayList( "Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    ObservableList<String> idopontList = FXCollections.observableArrayList("8:00-10:00", "10:00-12:00", "12:00-14:00", "14:00-16:00", "16:00-18:00", "18:00-20:00", "20:00-22:00");

   @FXML
    private TextField edzonev;

    @FXML
    private TextField konditeremnev;

    @FXML
    private TextField helyszin;

    @FXML
    private TextField foglalkozas;

    @FXML
    private ChoiceBox foglalkozasnapja;

    @FXML
    private ChoiceBox idopont;

    @FXML
    private TextField hanyfo;

    @FXML 
    private void initialize() {
        foglalkozasnapja.setValue(" ");
        idopont.setValue(" ");
        foglalkozasnapja.setItems(foglalkozasnapjaList);
        idopont.setItems(idopontList);
        
    }
    @FXML
    void mentes(ActionEvent event) {
        
        if(edzonev.getLength() == 0 || edzonev.toString().contains(" ") == false) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg az edző nevét!");
             error.show();
        }
        if(konditeremnev.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg a konditermet!");
             error.show();
        }
        if(helyszin.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg a helyszínt!");
             error.show();
        }
        if(foglalkozas.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg a foglalkozást!");
             error.show();
        }
        /*if(foglalkozasnapja.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg a napot!");
             error.show();
        }
       if(idopont.getLength()) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg az időpontot!");
             error.show();
        }  */
        if(hanyfo.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Add meg a létszámot");
             error.show();
        }
        
        
            
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Adatok ellenőrzése");
        confirmation.setHeaderText("Adatok ellenőrzése");
        confirmation.setContentText("Biztosan el akarod menteni?\n"
                + "név: " + edzonev.getText()+ "\n" 
                + "konditerem: " + konditeremnev.getText() + "\n"
                + "helyszín: " + helyszin.getText() + "\n"
                + "foglalkozás: " + foglalkozas.getText() + "\n"
                + "foglalkozás napja: " + foglalkozasnapja.getValue() + "\n"
                + "időpont: " + idopont.getValue() + "\n"
                + "hány fő részére: " + hanyfo.getText() + "\n");
            Optional<ButtonType> result = confirmation.showAndWait();
                if (result.get() == ButtonType.OK){
                    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
                    final EntityManager entityManager = entityManagerFactory.createEntityManager();
                Foglalkozasok s = new Foglalkozasok();
                s.setName(edzonev.getText());
                s.setGym(konditeremnev.getText());
                s.setLocation(helyszin.getText());
                s.setExercise(foglalkozas.getText());
                s.setDateOfExercise((String) foglalkozasnapja.getValue());
                s.setTime((String) idopont.getValue());
                s.setAmountOfPeople(Integer.parseInt(hanyfo.getText()));
                entityManager.getTransaction().begin();
                entityManager.persist(s);
                entityManager.getTransaction().commit();  
                } else {
    
            }
    }
           
    @FXML
    private Button VisszaButton;
    
    @FXML
    void VisszaButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/KepernyoEdzo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        Stage stage2 = (Stage) VisszaButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Edzői Profil");
        stage.setScene(scene);
        stage.show();
    }

}


