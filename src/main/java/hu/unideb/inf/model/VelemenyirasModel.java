/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author varad
 */

@Table(name = "Velemenyek")
@Entity
public class VelemenyirasModel implements Serializable
{
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column (name = "becenev", nullable = false, unique = false)
    private String becenev;
    
    @Column (name = "edzonev",  nullable = false, unique = false)
    private String edzonev;
    
    @Column (name = "foglalkozas",  nullable = false, unique = false)
    private String foglalkozas;
    
    @Column (name = "ertekeles",  nullable = false, unique = false)
    private double ertekeles;
    
    @Column (name = "velemeny",  nullable = false, unique = false)
    private String velemeny;

    public VelemenyirasModel(String becenev, String edzonev, String foglalkozas, double ertekeles, String velemeny) 
    {
        this.becenev = becenev;
        this.edzonev = edzonev;
        this.foglalkozas = foglalkozas;
        this.ertekeles = ertekeles;
        this.velemeny = velemeny;
    }

    public VelemenyirasModel(String edzonev)
    {
        this.edzonev = edzonev;
    }
    
    public VelemenyirasModel(String foglalkozas, double ertekeles, String velemeny) {
        this.foglalkozas = foglalkozas;
        this.ertekeles = ertekeles;
        this.velemeny = velemeny;
    }

    @Override
    public String toString() {
        return "VelemenyirasModel{" + "id=" + id + ", becenev=" + becenev + ", edzonev=" + edzonev + ", foglalkozas=" + foglalkozas + ", ertekeles=" + ertekeles + ", velemeny=" + velemeny + '}';
    }

    public VelemenyirasModel() 
    {
        
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getBeceNev() 
    {
        return becenev;
    }

    public void setBeceNev(String beceNev) 
    {
        this.becenev = beceNev;
    }

    public String getEdzoNev() 
    {
        return edzonev;
    }

    public void setEdzoNev(String edzoNev) 
    {
        this.edzonev = edzoNev;
    }

    public String getFoglalkozas() 
    {
        return foglalkozas;
    }

    public void setFoglalkozas(String foglalkozas)
    {
        this.foglalkozas = foglalkozas;
    }

    public double getErtekeles()
    {
        return ertekeles;
    }

    public void setErtekeles(double ertekeles) 
    {
        this.ertekeles = ertekeles;
    }

    public String getVelemeny() 
    {
        return velemeny;
    }

    public void setVelemeny(String velemeny)
    {
        this.velemeny = velemeny;
    }
}
