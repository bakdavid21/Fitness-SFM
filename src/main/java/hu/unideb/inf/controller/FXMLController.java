package hu.unideb.inf.controller;

import hu.unideb.inf.model.Registration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FXMLController {

    @FXML
    private TextField edzonev;

    @FXML
    private TextField konditeremnev;

    @FXML
    private TextField helyszin;

    @FXML
    private TextField foglalkozas;

    @FXML
    private TextField foglalkozasnapja;

    @FXML
    private TextField idopont;

    @FXML
    private TextField hanyfo;

    @FXML
    void mentes(ActionEvent event) {
        if(edzonev.getLength() == 0) {
             Alert error = new Alert(AlertType.ERROR);
             error.setTitle("Hibás paraméterezés");
             error.setHeaderText("Hiba");
             error.setContentText("Hiba");
             error.show();
        }
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        Registration s = new Registration();
            s.setName(edzonev.getText());
            s.setGym(konditeremnev.getText());
            s.setLocation(helyszin.getText());
            s.setExercise(foglalkozas.getText());
            s.setDateOfExercise(foglalkozasnapja.getText());
            s.setTime(idopont.getText());
            s.setAmountOfPeople(Integer.parseInt(hanyfo.getText()));
            entityManager.getTransaction().begin();
            entityManager.persist(s);
            entityManager.getTransaction().commit();
    }

}


