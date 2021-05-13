package hu.unideb.inf.controller;

import hu.unideb.inf.model.VelemenyirasModel;
import static java.lang.String.valueOf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.controlsfx.control.Rating;

public class Velemenyiras {

    @FXML
    private TextField becenevVelemenyiras;

    @FXML
    private TextField edzonevVelemenyiras;

    @FXML
    private TextField foglalkozasnevVelemenyiras;

    @FXML
    private TextArea velemenyVelemenyiras;

    @FXML
    private Rating rating;

    
    @FXML
    private Button mentesVelemenyiras;
    
    
    
    @FXML
    void mentesVelemenyirasAction(ActionEvent event) 
    {
        Stage stage2 = (Stage) mentesVelemenyiras.getScene().getWindow();
        stage2.close();        

        VelemenyirasModel velemeny = new VelemenyirasModel();  
        
        if(becenevVelemenyiras.getText().length() == 0 || edzonevVelemenyiras.getText().length() == 0 || foglalkozasnevVelemenyiras.getText().length() == 0 || velemenyVelemenyiras.getText().length() == 0 || rating.getRating() < 0)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setContentText("Töltsd ki az összes mezőt!");

            alert.showAndWait();
        }
        else
        {
            final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
            final EntityManager entityManager = entityManagerFactory.createEntityManager();
            velemeny.setBeceNev(becenevVelemenyiras.getText());
            velemeny.setEdzoNev(edzonevVelemenyiras.getText());
            velemeny.setFoglalkozas(foglalkozasnevVelemenyiras.getText());
            velemeny.setErtekeles(rating.getRating());
            velemeny.setVelemeny(velemenyVelemenyiras.getText());
        
            entityManager.getTransaction().begin();
            entityManager.persist(velemeny);
            entityManager.getTransaction().commit(); 
        }
        
        System.out.println(rating.getRating());
    }

}

