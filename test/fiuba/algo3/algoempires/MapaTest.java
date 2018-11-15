package fiuba.algo3.algoempires;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MapaTest {

    @Test
    public void test01CreoElMapaConDimensionesValidas() {
        Mapa MiMapa = new Mapa(20, 30);
        assertEquals(20, MiMapa.getLargoHorizontal());
        assertEquals(30, MiMapa.getLargoVertical());
    }

    @Test
    public void test02CreoElMapaConDimensionesNegativas() {
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(-20, -30);
        } catch (DimensionInvalidaMapa e) {

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test03CreoElMapaConDimensionesValidasYnoSaltaExcepcion() {
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(2, 99);
        } catch (DimensionInvalidaMapa e) {

            seLanzoError = true;
        }
        assertFalse(seLanzoError);
    }

    @Test
    public void test04CreoElMapaConDimensionesNulas() {
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(0, 0);
        } catch (DimensionInvalidaMapa e) {

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test05CreoElMapaConUnaDimensioneHorizontalNula() {
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(0, 50);
        } catch (DimensionInvalidaMapa e) {

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test06CreoElMapaConUnaDimensioneVerticalNula() {
        boolean seLanzoError = false;
        try {
            Mapa MiMapa = new Mapa(12, 0);
        } catch (DimensionInvalidaMapa e) {

            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test07CreoElMapaYUbicoAldeanoEnPosicionValida() {
        Ubicable Juan = new Aldeano();
        Posicion posicionAldeano = new Posicion(1, 5);
        Mapa miMapa = new Mapa(5, 5);
        miMapa.UbicarUnidadEnMapa(posicionAldeano, Juan);
        Ubicable aldeanoUbicadoEnElMapa = miMapa.GetUbicableEn(posicionAldeano);
        assertEquals(aldeanoUbicadoEnElMapa, Juan);
    }

    @Test
    public void test08CreoElMapaYUbicoUnEspadachinEnPosicionValida() {
        Ubicable unEspadachin = new Espadachin();
        Posicion posEspadachin = new Posicion(2, 2);
        Mapa unMapa = new Mapa(5, 5);
        unMapa.UbicarUnidadEnMapa(posEspadachin, unEspadachin);
        Ubicable espadachinUbicadoEnUnMapa = unMapa.GetUbicableEn(posEspadachin);
        assertEquals(espadachinUbicadoEnUnMapa, unEspadachin);
    }

    @Test
    public void test09CreoElMapaYUbicoUnArmaDeAsedioEnPosicionValida() {
        Ubicable unAriete = new ArmaDeAsedio();
        Posicion posicionAriete = new Posicion(1, 5);
        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionAriete, unAriete);
        Ubicable arieteUbicadoEnElMapa = MiMapa.GetUbicableEn(posicionAriete);
        assertEquals(arieteUbicadoEnElMapa, unAriete);
    }

    @Test
    public void test10CreoElMapaYUbicoUnArmaDeAsedioEnPosicionValida() {
        Ubicable unArquero = new Arquero();
        Posicion posicionArquero = new Posicion(1, 5);
        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionArquero, unArquero);
        Ubicable arqueroUbicadoEnElMapa = MiMapa.GetUbicableEn(posicionArquero);
        assertEquals(arqueroUbicadoEnElMapa, unArquero);
    }

    @Test
    public void test10CreoElMapaConUnAldeanoYloDesplazoDentroDelMapa() {
        Movible MiAldeano = new Aldeano();
        Posicion posicionAldeano = new Posicion(1, 5);
        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionAldeano, MiAldeano);
        Posicion nuevaPosicionAldeano = new Posicion(2, 5);
        MiMapa.MoverUnidad(nuevaPosicionAldeano, MiAldeano);
        assertEquals(MiAldeano.getPosicion(), nuevaPosicionAldeano);

    }

    @Test
    public void test11CreoElMapaConUnAldeanoYloDesplazoFueraDelMapa(){
        boolean seLanzoError=false;
        Movible MiAldeano=new Aldeano();
        Posicion posicionAldeano =new Posicion(1,5);
        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionAldeano,MiAldeano);
        Posicion nuevaPosicionAldeano=new Posicion(-1,5);
        try {
            MiMapa.MoverUnidad(nuevaPosicionAldeano,MiAldeano);
        }
        catch(MovimientoFueraDelMapa e) {
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }
}






