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
        assertEquals("Foo",unJuego.getActual());
    }

    @Test
    public void test02CreoJuegoConDosJugadoresCambiaTurnoOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        unJuego.cambiarTurno();
        assertEquals("Bar",unJuego.getActual());
    }

    @Test
    public void test03CreoJuegoConDosJugadoresCambiaTurnoDosVecesOk() {
        Juego unJuego = new Juego();
        unJuego.iniciarJuego("Foo","Bar");
        unJuego.cambiarTurno();
        unJuego.cambiarTurno();
        assertEquals("Foo",unJuego.getActual());
    }




}
