package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Entidades.Espadachin;
import fiuba.algo3.algoempires.Entidades.PlazaCentral;
import fiuba.algo3.algoempires.Excepciones.TopePoblacionException;
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


    @Test
    public void test03JugadorCreaUnidadesSubePoblacionOk() {
        Jugador unJugador = new Jugador("Foo");
        Aldeano unAldeano;

        for (int i = 0; i < 10; i++) {
            unAldeano = new Aldeano();
            unJugador.agregarUnidad(unAldeano);
        }

        int POBLACION_TEST = unJugador.getPoblacion();

        assertEquals(10, POBLACION_TEST);
    }

    @Test
    public void test04JugadorNoPuedeCrearMasDe50Unidades() {
        Jugador unJugador = new Jugador("Foo");
        Aldeano unAldeano;
        Boolean seLanzoError = false;
        try {
            for (int i = 0; i <= 51; i++) {
                unAldeano = new Aldeano();
                unJugador.agregarUnidad(unAldeano);
            }
        } catch (TopePoblacionException e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test05UnidadAtacadaSiguePerteneciendoAJugador() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        unJugador.agregarUnidad(unEspadachin);

        Espadachin otroEspadachin = new Espadachin();
        otroJugador.agregarUnidad(otroEspadachin);

        unEspadachin.atacarA(otroEspadachin);
        otroJugador.removerUnidadesMuertas();

        assertTrue(otroJugador.perteneceUnidad(otroEspadachin));
    }

    @Test
    public void test06UnidadMuertaDejaDePertenecerAJugador() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        unJugador.agregarUnidad(unEspadachin);

        Espadachin otroEspadachin = new Espadachin();
        otroJugador.agregarUnidad(otroEspadachin);

        //le saco toda la vida
        for (int i = 0; i<4; i++) {
            unEspadachin.atacarA(otroEspadachin);
        }
        otroJugador.removerUnidadesMuertas();

        assertFalse(otroJugador.perteneceUnidad(otroEspadachin));
    }

    @Test
    public void test07UnidadMuertaDejaDePertenecerAJugadorPeroUnidadesVivasSiguenPerteneciendo() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        unJugador.agregarUnidad(unEspadachin);

        Espadachin otroEspadachin = new Espadachin();
        Aldeano unAldeano = new Aldeano();
        Aldeano unAldeano1 = new Aldeano();
        Aldeano unAldeano2 = new Aldeano();

        otroJugador.agregarUnidad(otroEspadachin);
        otroJugador.agregarUnidad(unAldeano);
        otroJugador.agregarUnidad(unAldeano1);
        otroJugador.agregarUnidad(unAldeano2);

        //le saco toda la vida
        for (int i = 0; i<4; i++) {
            unEspadachin.atacarA(otroEspadachin);
        }

        otroJugador.removerUnidadesMuertas();

        assertTrue(!otroJugador.perteneceUnidad(otroEspadachin) & otroJugador.perteneceUnidad(unAldeano) & otroJugador.perteneceUnidad(unAldeano1) & otroJugador.perteneceUnidad(unAldeano2));
    }


    @Test
    public void test08EdificioAtacadoSiguePerteneciendoAJugador() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        Posicion pos1 = new Posicion (5,5);
        unEspadachin.modificarPosicion(pos1);
        unJugador.agregarUnidad(unEspadachin);

        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion pos2 = new Posicion (4,3);
        plazaCentral.modificarPosicion(pos2);
        otroJugador.agregarEdificio(plazaCentral);

        unEspadachin.atacarA(plazaCentral);
        otroJugador.removerEdificiosDestruidos();

        assertTrue(otroJugador.perteneceUnidad(plazaCentral));
    }

    @Test
    public void test09EdificioDestruidoDejaDePertenecerAJugador() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        Posicion pos1 = new Posicion (5,5);
        unEspadachin.modificarPosicion(pos1);
        unJugador.agregarUnidad(unEspadachin);

        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion pos2 = new Posicion (4,3);
        plazaCentral.modificarPosicion(pos2);
        otroJugador.agregarEdificio(plazaCentral);

        //le saco toda la vida
        for (int i = 0; i<30; i++) {
            unEspadachin.atacarA(plazaCentral);
        }
        otroJugador.removerEdificiosDestruidos();

        assertFalse(otroJugador.perteneceUnidad(plazaCentral));
    }

    @Test
    public void test10UnidadMuertaDejaDePertenecerAJugadorPeroUnidadesVivasSiguenPerteneciendo() {
        Jugador unJugador = new Jugador("Foo1");
        Jugador otroJugador = new Jugador("Foo2");

        Espadachin unEspadachin = new Espadachin();
        unJugador.agregarUnidad(unEspadachin);

        Espadachin otroEspadachin = new Espadachin();
        Aldeano unAldeano = new Aldeano();
        Aldeano unAldeano1 = new Aldeano();
        Aldeano unAldeano2 = new Aldeano();

        otroJugador.agregarUnidad(otroEspadachin);
        otroJugador.agregarUnidad(unAldeano);
        otroJugador.agregarUnidad(unAldeano1);
        otroJugador.agregarUnidad(unAldeano2);

        //le saco toda la vida
        for (int i = 0; i<4; i++) {
            unEspadachin.atacarA(otroEspadachin);
        }

        otroJugador.removerUnidadesMuertas();

        assertTrue(!otroJugador.perteneceUnidad(otroEspadachin) & otroJugador.perteneceUnidad(unAldeano) & otroJugador.perteneceUnidad(unAldeano1) & otroJugador.perteneceUnidad(unAldeano2));
    }
}