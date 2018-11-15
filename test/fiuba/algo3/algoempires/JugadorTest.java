package fiuba.algo3.algoempires;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void test01CreoJugadorOk() {
        Jugador unJugador = new Jugador("Juan");
        assertEquals("Juan", unJugador.getNombre());
    }

    @Test
    public void test02CreoJugadorConUnidadOk() {
        Jugador unJugador = new Jugador("Juan");
        Aldeano unAldeano = new Aldeano();
        unJugador.agregarUnidad(unAldeano);
        assert unJugador.perteneceUnidad(unAldeano);
    }



}
