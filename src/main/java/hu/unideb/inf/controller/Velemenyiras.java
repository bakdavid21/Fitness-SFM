package hu.unideb.inf.controller;


import hu.unideb.inf.model.EdzoiProfil;
import hu.unideb.inf.model.VelemenyirasModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import static java.lang.String.valueOf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private ChoiceBox<String> velemenyirasChoiceBox;

    
    @FXML
    private Button mentesVelemenyiras;
    
    String keres;
    
    ObservableList<String> oblist = FXCollections.observableArrayList();
    StringBuilder sb = new StringBuilder();
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException 
    {
        Connection con = getConnection();
        keres = "select * from FOGLALKOZASOK";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(keres);
        
        while(rs.next())
        {     
            if(!(oblist.contains(rs.getString("NÉV"))))
            {
                oblist.add(rs.getString("NÉV"));
            }
        }  
        velemenyirasChoiceBox.setItems(oblist);
    }
    
    
    @FXML
    void mentesVelemenyirasAction(ActionEvent event) throws ClassNotFoundException, SQLException, SQLException, SQLException 
    {    
        VelemenyirasModel velemeny = new VelemenyirasModel();  
        
        if(becenevVelemenyiras.getText().length() == 0 || velemenyirasChoiceBox.getValue() == null || foglalkozasnevVelemenyiras.getText().length() == 0 || velemenyVelemenyiras.getText().length() == 0)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setContentText("Töltsd ki az összes mezőt!");
            alert.showAndWait();
        }
        else
        { 
            sb.delete(0, sb.length());
            Connection con = getConnection();
            keres = "select * from FOGLALKOZASOK where NÉV = '" + velemenyirasChoiceBox.getValue() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(keres);
            System.out.println(keres);
            
            while(rs.next())
            {       
                if(sb.indexOf(rs.getString("FOGLALKOZAS")) == -1)
                {
                    sb.append(rs.getString("FOGLALKOZAS") + "\n");
                }
            }  
            
            System.out.println(sb.toString());
            
            if(sb == null || sb.indexOf(foglalkozasnevVelemenyiras.getText()) == -1)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Hiba");
                alert.setHeaderText(null);
                alert.setContentText(velemenyirasChoiceBox.getValue() + " nem tart ilyen foglalkozást! Az ő általa tartott foglalkozás(ok):\n\n" + sb.toString());
                alert.showAndWait(); 
            }
            else
            {
                Stage stage2 = (Stage) mentesVelemenyiras.getScene().getWindow();
                stage2.close();
                final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
                final EntityManager entityManager = entityManagerFactory.createEntityManager();
                velemeny.setBeceNev(becenevVelemenyiras.getText());            
                velemeny.setEdzoNev(velemenyirasChoiceBox.getValue());
                velemeny.setFoglalkozas(foglalkozasnevVelemenyiras.getText());
                if(rating.getRating() < 0)
                {
                    velemeny.setErtekeles(0);
                }
                else if(rating.getRating() > 5)
                {
                    velemeny.setErtekeles(5);
                }
                else
                {
                    velemeny.setErtekeles(rating.getRating());
                }
                velemeny.setVelemeny(velemenyVelemenyiras.getText());

                entityManager.getTransaction().begin();
                entityManager.persist(velemeny);
                entityManager.getTransaction().commit(); 
                
                sb.delete(0, sb.length());
            }
        }       
        System.out.println(rating.getRating());
    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/bb_fxml", "sa", "");
    }
}

