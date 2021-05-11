/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockito_test;

import hu.unideb.inf.model.Foglalkozasok;
import org.junit.jupiter.api.Assertions;
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
        
        Assertions.assertNotNull(f.getGym());
    }
    
    @Test
    public void test002_FOglalkozasok()
    {
        Foglalkozasok f = new Foglalkozasok();
        
        Assertions.assertNull(f.getName());
                
    }
    
}
