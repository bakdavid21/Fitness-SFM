/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

/**
 *
 * @author Peti
 */
import hu.unideb.inf.model.Foglalkozasok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Kondi1 {

    @FXML
    private TextArea hetfo10;

    @FXML
    private TextArea kedd8;

    @FXML
    private TextArea kedd10;

    @FXML
    private TextArea hetfo12;

    @FXML
    private TextArea kedd12;

    @FXML
    private TextArea hetfo14;

    @FXML
    private TextArea kedd14;

    @FXML
    private TextArea szerda8;

    @FXML
    private TextArea szerda10;

    @FXML
    private TextArea szerda12;

    @FXML
    private TextArea szerda14;

    @FXML
    private TextArea kedd16;

    @FXML
    private TextArea hetfo16;

    @FXML
    private TextArea hetfo18;

    @FXML
    private TextArea kedd18;

    @FXML
    private TextArea szerda18;

    @FXML
    private TextArea szerda16;

    @FXML
    private TextArea csutortok8;

    @FXML
    private TextArea pentek8;

    @FXML
    private TextArea szombat8;

    @FXML
    private TextArea vasarnap8;

    @FXML
    private TextArea csutortok10;

    @FXML
    private TextArea pentek10;

    @FXML
    private TextArea szombat10;

    @FXML
    private TextArea vasarnap10;

    @FXML
    private TextArea csutortok12;

    @FXML
    private TextArea csutortok14;

    @FXML
    private TextArea csutortok16;

    @FXML
    private TextArea pentek12;

    @FXML
    private TextArea csutortok18;

    @FXML
    private TextArea pentek14;

    @FXML
    private TextArea szombat14;

    @FXML
    private TextArea szombat12;

    @FXML
    private TextArea vasarnap12;

    @FXML
    private TextArea vasarnap14;

    @FXML
    private TextArea szombat16;

    @FXML
    private TextArea pentek16;

    @FXML
    private TextArea pentek18;

    @FXML
    private TextArea szombat18;

    @FXML
    private TextArea vasarnap16;

    @FXML
    private TextArea vasarnap18;

    @FXML
    private TextArea hetfo8;

    @FXML
    private TextArea hetfo20;

    @FXML
    private TextArea kedd20;

    @FXML
    private TextArea szerda20;

    @FXML
    private TextArea csutortok20;

    @FXML
    private TextArea pentek20;

    @FXML
    private TextArea szombat20;

    @FXML
    private TextArea vasarnap20;
    
    
    String kondi = " KONDITEREM = '1'";
    ObservableList<Foglalkozasok> oblist = FXCollections.observableArrayList();
    List<String> hetfo = new ArrayList();
    List<String> kedd = new ArrayList();
    List<String> szerda = new ArrayList();
    List<String> csutortok = new ArrayList();
    List<String> pentek = new ArrayList();
    List<String> szombat = new ArrayList();
    List<String> vasarnap = new ArrayList();
    
    
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        String keres = "select * from FOGLALKOZASOK where " + kondi;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(keres);
        
        while (rs.next()) {
            oblist.add(new Foglalkozasok(rs.getString("NÉV"), rs.getString("KONDITEREM"), rs.getString("HELYSZIN"), rs.getString("FOGLALKOZAS"), rs.getString("FOGLALKOZASNAPJA"), rs.getString("IDOPONT"), rs.getInt("HANYFO")));
            switch(rs.getString("FOGLALKOZASNAPJA")) {
                case "Hétfő" : 
                    hetfo.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Kedd" : 
                    kedd.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Szerda" : 
                    szerda.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Csütörtök" : 
                    csutortok.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Péntek" : 
                    pentek.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Szombat" : 
                    szombat.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                case "Vasárnap" : 
                    vasarnap.add(rs.getString("IDOPONT") + "Foglalkozás:" + rs.getString("FOGLALKOZAS") + "-" + "Helyszín:" + rs.getString("HELYSZIN")+"-" + "Edző:" + rs.getString("NÉV") + "\n");
                    break;
                default :
                    break;
                }
            }
            for (int i = 0; i<hetfo.size(); i++) {
                switch (hetfo.get(i).substring(0, 11)) {
                    case "08:00-10:00" :
                        hetfo8.appendText(hetfo.get(i).substring(11));
                        break;
                    case "10:00-12:00" :
                        hetfo10.appendText(hetfo.get(i).substring(11));
                        break;
                    case "12:00-14:00" :
                        hetfo12.appendText(hetfo.get(i).substring(11));
                        break;
                    case "14:00-16:00" :
                        hetfo14.appendText(hetfo.get(i).substring(11));
                        break;
                    case "16:00-18:00" :
                        hetfo16.appendText(hetfo.get(i).substring(11));
                        break;
                    case "18:00-20:00" :
                        hetfo18.appendText(hetfo.get(i).substring(11));
                        break;
                    case "20:00-22:00" :
                        hetfo20.appendText(hetfo.get(i).substring(11));
                        break;    
                }
            }
            for (int j = 0; j<kedd.size(); j++) {
                switch (kedd.get(j).substring(0, 11)) {
                    case "08:00-10:00" :
                        kedd8.appendText(kedd.get(j).substring(11));
                        break;
                    case "10:00-12:00" :
                        kedd10.appendText(kedd.get(j).substring(11));
                        break;
                    case "12:00-14:00" :
                        kedd12.appendText(kedd.get(j).substring(11));
                        break;
                    case "14:00-16:00" :
                        kedd14.appendText(kedd.get(j).substring(11));
                        break;
                    case "16:00-18:00" :
                        kedd16.appendText(kedd.get(j).substring(11));
                        break;
                    case "18:00-20:00" :
                        kedd18.appendText(kedd.get(j).substring(11));
                        break;
                    case "20:00-22:00" :
                        kedd20.appendText(kedd.get(j).substring(11));
                        break;    
                }
            }
            for (int k = 0; k<szerda.size(); k++) {
                switch (szerda.get(k).substring(0, 11)) {
                    case "08:00-10:00" :
                        szerda8.appendText(szerda.get(k).substring(11));
                        break;
                    case "10:00-12:00" :
                        szerda10.appendText(szerda.get(k).substring(11));
                        break;
                    case "12:00-14:00" :
                        szerda12.appendText(szerda.get(k).substring(11));
                        break;
                    case "14:00-16:00" :
                        szerda14.appendText(szerda.get(k).substring(11));
                        break;
                    case "16:00-18:00" :
                        szerda16.appendText(szerda.get(k).substring(11));
                        break;
                    case "18:00-20:00" :
                        szerda18.appendText(szerda.get(k).substring(11));
                        break;
                    case "20:00-22:00" :
                        szerda20.appendText(szerda.get(k).substring(11));
                        break;    
                }
            }
            for (int l = 0; l<csutortok.size(); l++) {
                switch (csutortok.get(l).substring(0, 11)) {
                    case "08:00-10:00" :
                        csutortok8.appendText(csutortok.get(l).substring(11));
                        break;
                    case "10:00-12:00" :
                        csutortok10.appendText(csutortok.get(l).substring(11));
                        break;
                    case "12:00-14:00" :
                        csutortok12.appendText(csutortok.get(l).substring(11));
                        break;
                    case "14:00-16:00" :
                        csutortok14.appendText(csutortok.get(l).substring(11));
                        break;
                    case "16:00-18:00" :
                        csutortok16.appendText(csutortok.get(l).substring(11));
                        break;
                    case "18:00-20:00" :
                        csutortok18.appendText(csutortok.get(l).substring(11));
                        break;
                    case "20:00-22:00" :
                        csutortok20.appendText(csutortok.get(l).substring(11));
                        break;    
            }
            for (int i = 0; i<pentek.size(); i++) {
                switch (pentek.get(i).substring(0, 11)) {
                    case "08:00-10:00" :
                        pentek8.appendText(pentek.get(i).substring(11));
                        break;
                    case "10:00-12:00" :
                        pentek10.appendText(pentek.get(i).substring(11));
                        break;
                    case "12:00-14:00" :
                        pentek12.appendText(pentek.get(i).substring(11));
                        break;
                    case "14:00-16:00" :
                        pentek14.appendText(pentek.get(i).substring(11));
                        break;
                    case "16:00-18:00" :
                        pentek16.appendText(pentek.get(i).substring(11));
                        break;
                    case "18:00-20:00" :
                        pentek18.appendText(pentek.get(i).substring(11));
                        break;
                    case "20:00-22:00" :
                        pentek20.appendText(pentek.get(i).substring(11));
                        break;    
                }
            }
            for (int i = 0; i<szombat.size(); i++) {
                switch (szombat.get(i).substring(0, 11)) {
                    case "08:00-10:00" :
                        szombat8.appendText(szombat.get(i).substring(11));
                        break;
                    case "10:00-12:00" :
                        szombat10.appendText(szombat.get(i).substring(11));
                        break;
                    case "12:00-14:00" :
                        szombat12.appendText(szombat.get(i).substring(11));
                        break;
                    case "14:00-16:00" :
                        szombat14.appendText(szombat.get(i).substring(11));
                        break;
                    case "16:00-18:00" :
                        szombat16.appendText(szombat.get(i).substring(11));
                        break;
                    case "18:00-20:00" :
                        szombat18.appendText(szombat.get(i).substring(11));
                        break;
                    case "20:00-22:00" :
                        szombat20.appendText(szombat.get(i).substring(11));
                        break;    
                }
            }
                for (int i = 0; i<vasarnap.size(); i++) {
                switch (vasarnap.get(i).substring(0, 11)) {
                    case "08:00-10:00" :
                        vasarnap8.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "10:00-12:00" :
                        vasarnap10.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "12:00-14:00" :
                        vasarnap12.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "14:00-16:00" :
                        vasarnap14.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "16:00-18:00" :
                        vasarnap16.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "18:00-20:00" :
                        vasarnap18.appendText(vasarnap.get(i).substring(11));
                        break;
                    case "20:00-22:00" :
                        vasarnap20.appendText(vasarnap.get(i).substring(11));
                        break;    
                }
            }
        }
    }
    private Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:file:~/bb_fxml", "sa", "");
    }
}

