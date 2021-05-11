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
@Table(name = "Foglalkozasok")
@Entity
public class Foglalkozasok implements Serializable {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Foglalkozasok(String name, String gym, String location, String exercise, Object dateOfExercise, Object time, int amountOfPeople) 
    {
        this.name = name;
        this.gym = gym;
        this.location = location;
        this.exercise = exercise;
        this.dateOfExercise = (String) dateOfExercise;
        this.time = (String) time;
        this.amountOfPeople = amountOfPeople;
    }

    public Foglalkozasok() 
    {
    }

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

    @Override
    public String toString() {
        return "Foglalkozasok{" + "id=" + id + ", name=" + name + ", gym=" + gym + ", location=" + location + ", exercise=" + exercise + ", dateOfExercise=" + dateOfExercise + ", time=" + time + ", amountOfPeople=" + amountOfPeople + '}';
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

    public Object getDateOfExercise() {
        return dateOfExercise;
    }

    public void setDateOfExercise(String dateOfExercise) {
        this.dateOfExercise = dateOfExercise;
    }

    public Object getTime() {
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
