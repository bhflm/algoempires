package fiuba.algo3.algoempires;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void test01CreoElMapaConDimensionesValidas(){
        Mapa MiMapa =new Mapa(20,30);
        assertEquals(20,MiMapa.getLargoHorizontal());
        assertEquals(30,MiMapa.getLargoVertical());
    }

    @Test
    public void test02CreoElMapaConDimensionesNegativas(){
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(-20, -30);
            }
        catch(DimensionInvalidaMapa e){

            seLanzoError = true;
                                        }
        assertTrue(seLanzoError);
    }
    @Test
    public void test03CreoElMapaConDimensionesValidasYnoSaltaExcepcion(){
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(2, 99);
        }
        catch(DimensionInvalidaMapa e ){

            seLanzoError = true;
        }
        assertFalse(seLanzoError);
    }

    @Test
    public void test04CreoElMapaConDimensionesNulas(){
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(0, 0);
        }
        catch(DimensionInvalidaMapa e){

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }
    @Test
    public void test05CreoElMapaConUnaDimensioneHorizontalNula(){
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(0, 50);
        }
        catch(DimensionInvalidaMapa e){

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test06CreoElMapaConUnaDimensioneVerticalNula(){
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(12, 0);
        }
        catch(DimensionInvalidaMapa e){

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }
}