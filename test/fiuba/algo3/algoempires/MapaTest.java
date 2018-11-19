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
    public void test11CreoElMapaConUnAldeanoYloDesplazoFueraDelMapa() {
        boolean seLanzoError = false;
        Movible MiAldeano = new Aldeano();
        Posicion posicionAldeano = new Posicion(1, 5);
        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionAldeano, MiAldeano);
        Posicion nuevaPosicionAldeano = new Posicion(-1, 5);
        try {
            MiMapa.MoverUnidad(nuevaPosicionAldeano, MiAldeano);
        } catch (MovimientoFueraDelMapa e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    public void test12CreoElMapaYUbicoUnaPlazaCentralEnPosicionValida() {
        Ubicable unaPlazaCentral = new PlazaCentral();
        Posicion posicionPlazaCentral1 = new Posicion(1, 1);
        Posicion posicionPlazaCentral2 = new Posicion(1, 2);
        Posicion posicionPlazaCentral3 = new Posicion(2, 1);
        Posicion posicionPlazaCentral4 = new Posicion(2, 2);

        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionPlazaCentral1, unaPlazaCentral);
        Ubicable plazaEnMapa1 = MiMapa.GetUbicableEn(posicionPlazaCentral1);
        Ubicable plazaEnMapa2 = MiMapa.GetUbicableEn(posicionPlazaCentral2);
        Ubicable plazaEnMapa3 = MiMapa.GetUbicableEn(posicionPlazaCentral3);
        Ubicable plazaEnMapa4 = MiMapa.GetUbicableEn(posicionPlazaCentral4);

        assertEquals(plazaEnMapa1, unaPlazaCentral);
        assertEquals(plazaEnMapa2, unaPlazaCentral);
        assertEquals(plazaEnMapa3, unaPlazaCentral);
        assertEquals(plazaEnMapa4, unaPlazaCentral);
    }

    @Test
    public void test13CreoElMapaYUbicoUnCuartelEnPosicionValida() {
        Ubicable unCuartel = new Cuartel();
        Posicion posicionCuartel1 = new Posicion(2, 1);
        Posicion posicionCuartel2 = new Posicion(2, 2);
        Posicion posicionCuartel3 = new Posicion(3, 1);
        Posicion posicionCuartel4 = new Posicion(3, 2);

        Mapa MiMapa = new Mapa(5, 5);
        MiMapa.UbicarUnidadEnMapa(posicionCuartel1, unCuartel);
        Ubicable cuartelEnMapa1 = MiMapa.GetUbicableEn(posicionCuartel1);
        Ubicable cuartelEnMapa2 = MiMapa.GetUbicableEn(posicionCuartel2);
        Ubicable cuartelEnMapa3 = MiMapa.GetUbicableEn(posicionCuartel3);
        Ubicable cuartelEnMapa4 = MiMapa.GetUbicableEn(posicionCuartel4);

        assertEquals(cuartelEnMapa1, unCuartel);
        assertEquals(cuartelEnMapa2, unCuartel);
        assertEquals(cuartelEnMapa3, unCuartel);
        assertEquals(cuartelEnMapa4, unCuartel);
    }

    @Test
    public void test14CreoElMapaYUbicoUnaPlazaCentralEnPosicionInvalida() {
        boolean seLanzoError = false;
        Ubicable unaPlazaCentral = new PlazaCentral();
        Posicion posicionPlazaCentral1 = new Posicion(5, 4);

        Mapa MiMapa = new Mapa(5, 5);
        try {
            MiMapa.UbicarUnidadEnMapa(posicionPlazaCentral1, unaPlazaCentral);
        } catch (UbicacionFueraDelMapaException e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test15CreoElMapaYUbicoUnaPlazaCentralEnPosicionBordeValida() {
        boolean seLanzoError = false;
        Ubicable unaPlazaCentral = new PlazaCentral();
        Posicion posicionPlazaCentral1 = new Posicion(4, 4);

        Mapa MiMapa = new Mapa(5, 5);
        try {
            MiMapa.UbicarUnidadEnMapa(posicionPlazaCentral1, unaPlazaCentral);
        } catch (UbicacionFueraDelMapaException e) {
            seLanzoError = true;
        }
        assertFalse(seLanzoError);
    }

    @Test
    public void test16CreoElMapaYUbicoAldeanoEnPosicionDondeYaTengoUnAldeano() {
        Ubicable Juan = new Aldeano();
        Ubicable Pedro = new Aldeano();
        boolean seLanzoError=false;
        Posicion posicionAldeano = new Posicion(1, 5);
        Mapa miMapa = new Mapa(5, 5);
        miMapa.UbicarUnidadEnMapa(posicionAldeano, Juan);
        try{
            miMapa.UbicarUnidadEnMapa(posicionAldeano,Pedro);
        }
        catch(UbicacionOcupadaPorOtraUnidad e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test17CreoElMapaYMuevoAldeanoEnUnaPosicionDondeYaTengoUnAldeano() {
        Movible Juan = new Aldeano();
        Movible Pedro = new Aldeano();
        boolean seLanzoError=false;
        Posicion posicionAldeanoJuan = new Posicion(1, 5);
        Posicion posicionAldeanoPedro=new Posicion(2,5);
        Mapa miMapa = new Mapa(5, 5);
        miMapa.UbicarUnidadEnMapa(posicionAldeanoJuan, Juan);
        miMapa.UbicarUnidadEnMapa(posicionAldeanoPedro, Pedro);
        try{
            miMapa.MoverUnidad(posicionAldeanoJuan,Pedro);
        }
        catch(UbicacionOcupadaPorOtraUnidad e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }








}