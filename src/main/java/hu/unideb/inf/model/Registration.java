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
 * @author Peti
 */
@Table(name = "Registration")
@Entity
public class Registration implements Serializable {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }
    
    @Column (name = "név",  nullable = false, unique = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    @Column (name = "konditerem",  nullable = false, unique = false)
    private String gym;
    
    @Column (name = "helyszin",  nullable = false, unique = false)
    private String location;
    
    @Column (name = "foglalkozas",  nullable = false, unique = false)
    private String exercise;
    
    @Column (name = "foglalkozasnapja", nullable = false, unique = false)
    private String dateOfExercise;
    
    @Column (name = "idopont",  nullable = false, unique = false)
    private String time;
    
    @Column (name = "hanyfo",  nullable = false, unique = false)
    private int amountOfPeople;

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getDateOfExercise() {
        return dateOfExercise;
    }

    public void setDateOfExercise(String dateOfExercise) {
        this.dateOfExercise = dateOfExercise;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
 }

}
