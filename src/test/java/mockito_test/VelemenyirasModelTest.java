package mockito_test;

import hu.unideb.inf.model.VelemenyirasModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author david
 */
public class VelemenyirasModelTest 
{   
    @Test
    public void test001_VelemenyirasModel()
    {
        VelemenyirasModel v = new VelemenyirasModel("Próba Ádám", "Pisti", "edző", 5.0, "Jó");
        
        assertEquals(v.getBeceNev(),"Próba Ádám");
        assertEquals(v.getEdzoNev(),"Pisti");
        assertEquals(v.getFoglalkozas(),"edző");
        assertEquals(v.getErtekeles(),5.0);
        assertEquals(v.getVelemeny(),"Jó");
        
    }
    
    @Test
    public void test002_VelemenyirasModel()
    {
        VelemenyirasModel v = new VelemenyirasModel("Próba Ádám", "Pisti", "edző", 5.0, "Jó");
        
        v.setBeceNev("Dávid");
        v.setEdzoNev("Ádám");
        v.setFoglalkozas("ember");
        v.setErtekeles(3.4);
        v.setVelemeny("Rossz");
        
        assertEquals(v.getBeceNev(),"Dávid");
        assertEquals(v.getEdzoNev(),"Ádám");
        assertEquals(v.getFoglalkozas(),"ember");
        assertEquals(v.getErtekeles(),3.4);
        assertEquals(v.getVelemeny(),"Rossz");
        
    }
}
