package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private Rating edzorating;

    
    @FXML
    private Button mentesVelemenyiras;
    
    
    
    @FXML
    void mentesVelemenyirasAction(ActionEvent event) {
        Stage stage2 = (Stage) mentesVelemenyiras.getScene().getWindow();
        stage2.close();
    }

}

