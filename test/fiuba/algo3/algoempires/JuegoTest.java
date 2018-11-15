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
        Mapa unMapa = new Mapa(4,3);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unAldeano);

        Direccion moverDerecha = new DireccionDerechaHorizontal();
        Posicion nuevaPos = new Posicion(1,2);


        unJuego.getActual().moverUnidad(unJuego,unMapa,unAldeano,moverDerecha);

        assertEquals(nuevaPos,unAldeano.getPosicion());
    }



}
