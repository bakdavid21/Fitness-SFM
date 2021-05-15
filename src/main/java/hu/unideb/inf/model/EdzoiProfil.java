/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Peti
 */
@Table(name = "EdzoiProfil")
@Entity
public class EdzoiProfil implements Serializable {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public EdzoiProfil(String nev, String szuletesiDatum, List<String> tapasztalatok, List<String> foglalkozasok, String bemutatkozas) 
    {
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
        this.tapasztalatok = tapasztalatok;
        this.foglalkozasok = foglalkozasok;
        this.bemutatkozas = bemutatkozas;
    }

    @Override
    public String toString() {
        return "EdzoiProfil{" + "id=" + id + ", nev=" + nev + ", szuletesiDatum=" + szuletesiDatum + ", tapasztalatok=" + tapasztalatok + ", foglalkozasok=" + foglalkozasok + ", bemutatkozas=" + bemutatkozas + '}';
    }

    public EdzoiProfil(String nev) 
    {
        this.nev = nev;
    }   

    public EdzoiProfil(String nev, String szuletesiDatum, String bemutatkozas) {
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
        this.bemutatkozas = bemutatkozas;
    }

    public EdzoiProfil(long id, String nev, String szuletesiDatum, String bemutatkozas) {
        this.id = id;
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
        this.bemutatkozas = bemutatkozas;
    }
    

    
    public EdzoiProfil(String nev, String szuletesiDatum) 
    {
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
    }   
    
    public EdzoiProfil() 
    {
    }
    
     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "név",  nullable = false, unique = false)
    private String nev;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
   
    @Column (name = "szuletesidatum",  nullable = false, unique = false)
    private String szuletesiDatum;

    @ElementCollection
    @Column (name = "tapasztalatok",  nullable = false, unique = false)
     private List<String> tapasztalatok;
    
    @ElementCollection
    @Column (name = "foglalkozasok",  nullable = false, unique = false)
    private List<String> foglalkozasok;
    
    @Column (name = "bemutatkozas", nullable = false, unique = false)
    private String bemutatkozas;
    

    
    public String getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(String szuletesiDatum) {
        this.szuletesiDatum =  szuletesiDatum;
    }

    public List<String> getTapasztalatok() {
        return tapasztalatok;
    }

    public void setTapasztalatok(List<String> tapasztalatok) {
        this.tapasztalatok = tapasztalatok;
    }

    public List<String> getFoglalkozasok() {
        return foglalkozasok;
    }

    public void setFoglalkozasok(List<String> foglalkozasok) {
        this.foglalkozasok = foglalkozasok;
    }

    public String getBemutatkozas() {
        return bemutatkozas;
    }

    public void setBemutatkozas(String bemutatkozas) {
        this.bemutatkozas = bemutatkozas;
    }
    
    public void addTapasztalatok(String tapasztalat) {
        tapasztalatok.add(tapasztalat);
        
    }
    
    public void addFoglalkozasok(String foglalkozas) {
        foglalkozasok.add(foglalkozas);
    }

}
