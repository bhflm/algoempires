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
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");

        unJuego.iniciarJuego(unJugador,otroJugador);
        assertEquals(unJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test02CreoJuegoConDosJugadoresCambiaTurnoOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);
        unJuego.cambiarTurno();
        assertEquals(otroJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test03CreoJuegoConDosJugadoresCambiaTurnoDosVecesOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);
        unJuego.cambiarTurno();
        unJuego.cambiarTurno();
        assertEquals(unJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test04CreoJuegoConDosJugadoresMueveAldeanoMismoTurnoOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Aldeano unAldeano = new Aldeano();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unAldeano);

        Direccion moverDerecha = new DireccionDerechaHorizontal();
        Posicion nuevaPos = new Posicion(3,2);

        unJugador.moverUnidad(unJuego,unMapa,unAldeano,moverDerecha);

        assertEquals(nuevaPos,unAldeano.getPosicion());
    }

    @Test
    public void test05CreoJuegoConDosJugadoresMueveArqueroMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Arquero unArquero = new Arquero();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unArquero);
        unMapa.UbicarUnidadEnMapa(unaPos,unArquero);

        Direccion moverDerecha = new DireccionIzquierdaHorizontal();
        Posicion nuevaPos = new Posicion(1,2);

        unJugador.moverUnidad(unJuego,unMapa,unArquero,moverDerecha);

        assertEquals(nuevaPos,unArquero.getPosicion());
    }


    @Test
    public void test06CreoJuegoConDosJugadoresMueveArmaDeAsedioMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        ArmaDeAsedio unArmaAsedio = new ArmaDeAsedio();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unArmaAsedio);
        unMapa.UbicarUnidadEnMapa(unaPos,unArmaAsedio);

        Direccion moverDerecha = new DireccionInferiorVertical();
        Posicion nuevaPos = new Posicion(2,1);
        unJugador.moverUnidad(unJuego,unMapa,unArmaAsedio,moverDerecha);

        assertEquals(nuevaPos,unArmaAsedio.getPosicion());
    }

    @Test
    public void test07CreoJuegoConDosJugadoresMueveEspadachinMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionSuperiorVertical();
        Posicion nuevaPos = new Posicion(2,3);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test08CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaInferiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaInferior();
        Posicion nuevaPos = new Posicion(1,1);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test09CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaInferiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaInferior();
        Posicion nuevaPos = new Posicion(3,1);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }


    @Test
    public void test10CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaSuperiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaSuperior();
        Posicion nuevaPos = new Posicion(3,3);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test11CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaSuperiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaSuperior();
        Posicion nuevaPos = new Posicion(1,3);
        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);
    }


    @Test
    public void test12JugadorNoPuedeJugarEnTurnoQueNoCorresponde(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);

        boolean seLanzoError = false;

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaSuperior();
        Direccion moverAbajoDerecha = new DireccionDiagonalDerechaInferior();
        Posicion nuevaPos = new Posicion(1,3);
        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        try {
            unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverAbajoDerecha);
        }
        catch(JugadaInvalidaException e){
            seLanzoError = true;
        }
        assertTrue(seLanzoError);

    }









}
