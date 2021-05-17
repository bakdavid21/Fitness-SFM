/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockito_test;

import hu.unideb.inf.model.Foglalkozasok;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author varad
 */
public class FoglalkozasokTest 
{   
    @Test
    public void test001_Foglalkozasok()
    {
        Foglalkozasok f = new Foglalkozasok("Próba Ádám", "proba", "Nagy Terem", "Gimnasztika", "2021.05.02", "10:00-12:00", 12);
        
        assertEquals(f.getName(),"Próba Ádám");
        assertEquals(f.getGym(),"proba");
        assertEquals(f.getLocation(),"Nagy Terem");
        assertEquals(f.getExercise(),"Gimnasztika");
        assertEquals(f.getDateOfExercise(),"2021.05.02");
        assertEquals(f.getTime(),"10:00-12:00");
        assertEquals(f.getAmountOfPeople(),12);
        
    }
    
    @Test
    public void test002_Foglalkozasok()
    {
        Foglalkozasok f = new Foglalkozasok("Próba Ádám", "proba", "Nagy Terem", "Gimnasztika", "2021.05.02", "10:00-12:00", 12);
        
        f.setName("Próba Dávid");
        f.setGym("probaa");
        f.setLocation("kisterem");
        f.setExercise("TRX");
        f.setDateOfExercise("2021.05.14");
        f.setTime("10:00-11:00");
        f.setAmountOfPeople(10);
        assertEquals(f.getName(),"Próba Dávid");
        assertEquals(f.getGym(),"probaa");
        assertEquals(f.getLocation(),"kisterem");
        assertEquals(f.getExercise(),"TRX");
        assertEquals(f.getDateOfExercise(),"2021.05.14");
        assertEquals(f.getTime(),"10:00-11:00");
        assertEquals(f.getAmountOfPeople(),10);
        
    }
    
    
}
