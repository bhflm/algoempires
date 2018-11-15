package fiuba.algo3.algoempires;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class JuegoTest {

    @Test
    public void test01CreoJuegoConDosJugadoresDevuelveJugadorOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        assertEquals("Foo",unJuego.getNombreActual());
    }

    @Test
    public void test02CreoJuegoConDosJugadoresCambiaTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        unJuego.cambiarTurno();
        assertEquals("Bar",unJuego.getNombreActual());
    }

    @Test
    public void test03CreoJuegoConDosJugadoresCambiaTurnoDosVecesOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        unJuego.cambiarTurno();
        unJuego.cambiarTurno();
        assertEquals("Foo",unJuego.getNombreActual());
    }

    @Test
    public void test04CreoJuegoConDosJugadoresMueveAldeanoMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Aldeano unAldeano = new Aldeano();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unAldeano);

        Direccion moverDerecha = new DireccionDerechaHorizontal();
        Posicion nuevaPos = new Posicion(3,2);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unAldeano,moverDerecha);

        assertEquals(nuevaPos,unAldeano.getPosicion());
    }

    @Test
    public void test05CreoJuegoConDosJugadoresMueveArqueroMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Arquero unArquero = new Arquero();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unArquero);
        unMapa.UbicarUnidadEnMapa(unaPos,unArquero);

        Direccion moverDerecha = new DireccionIzquierdaHorizontal();
        Posicion nuevaPos = new Posicion(1,2);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unArquero,moverDerecha);

        assertEquals(nuevaPos,unArquero.getPosicion());
    }


    @Test
    public void test06CreoJuegoConDosJugadoresMueveArmaDeAsedioMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        ArmaDeAsedio unArmaAsedio = new ArmaDeAsedio();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unArmaAsedio);
        unMapa.UbicarUnidadEnMapa(unaPos,unArmaAsedio);

        Direccion moverDerecha = new DireccionInferiorVertical();
        Posicion nuevaPos = new Posicion(2,1);
        unJuego.getActual().moverUnidad(unJuego,unMapa,unArmaAsedio,moverDerecha);

        assertEquals(nuevaPos,unArmaAsedio.getPosicion());
    }

    @Test
    public void test07CreoJuegoConDosJugadoresMueveEspadachinMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionSuperiorVertical();
        Posicion nuevaPos = new Posicion(2,3);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test08CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaInferiorEnELMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaInferior();
        Posicion nuevaPos = new Posicion(1,1);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test09CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaInferiorEnELMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaInferior();
        Posicion nuevaPos = new Posicion(3,1);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }


    @Test
    public void test10CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaSuperiorEnELMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaSuperior();
        Posicion nuevaPos = new Posicion(3,3);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test11CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaSuperiorEnELMismoTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaSuperior();
        Posicion nuevaPos = new Posicion(1,3);

        unJuego.getActual().moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }















}
