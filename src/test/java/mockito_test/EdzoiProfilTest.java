package mockito_test;

import hu.unideb.inf.model.EdzoiProfil;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author david
 */
public class EdzoiProfilTest 
{   
    @Test
    public void test001_EdzoiProfil()
    {
        List<String>tapasztalatok = List.of("edző");
        List<String>foglalkozasok = List.of("TRX");
        EdzoiProfil e = new EdzoiProfil("Próba Ádám", "1985.02.04", tapasztalatok, foglalkozasok, "Ádám vagyok");
        
        assertEquals(e.getNev(),"Próba Ádám");
        assertEquals(e.getSzuletesiDatum(),"1985.02.04");
        assertEquals(e.getTapasztalatok(),tapasztalatok);
        assertEquals(e.getFoglalkozasok(),foglalkozasok);
        assertEquals(e.getBemutatkozas(),"Ádám vagyok");
        
    }
    
    @Test
    public void test002_EdzoiProfil()
    {
        List<String>tapasztalatok = List.of("edző");
        List<String>foglalkozasok = List.of("TRX");
        EdzoiProfil e = new EdzoiProfil("Próba Ádám", "1985.02.04", tapasztalatok, foglalkozasok, "Ádám vagyok");
        
        e.setNev("Próba Dávid");
        e.setSzuletesiDatum("1967.04.05");
        e.setBemutatkozas("Dávid vagyok");
        assertEquals(e.getNev(),"Próba Dávid");
        assertEquals(e.getSzuletesiDatum(),"1967.04.05");
        assertEquals(e.getTapasztalatok(),tapasztalatok);
        assertEquals(e.getFoglalkozasok(),foglalkozasok);
        assertEquals(e.getBemutatkozas(),"Dávid vagyok");
        
    }
    
    @Test
    public void test003_EdzoiProfil()
    {
        List<String>tapasztalatok = new ArrayList<String>();
        tapasztalatok.add("edző");
        List<String>foglalkozasok = new ArrayList<String>();
        foglalkozasok.add("TRX");
        EdzoiProfil e = new EdzoiProfil("Próba Ádám", "1985.02.04", tapasztalatok, foglalkozasok, "Ádám vagyok");
        
        e.addTapasztalatok("Szia");
        e.addFoglalkozasok("Hello");
        assertEquals(e.getNev(),"Próba Ádám");
        assertEquals(e.getSzuletesiDatum(),"1985.02.04");
        assertEquals(e.getBemutatkozas(),"Ádám vagyok");
        assertEquals(e.getTapasztalatok(),List.of("edző", "Szia"));
        assertEquals(e.getFoglalkozasok(),List.of("TRX", "Hello"));
        
    }
    
    
}
