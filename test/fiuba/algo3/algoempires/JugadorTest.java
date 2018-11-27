package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Entidades.Aldeano;
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
    public void test03JugadorCreaUnidadesSubePoblacionOk(){
        Jugador unJugador = new Jugador("Foo");
        Aldeano unAldeano;

        for(int i=0; i<10; i++){
            unAldeano = new Aldeano();
            unJugador.agregarUnidad(unAldeano);
        }

        int POBLACION_TEST = unJugador.getPoblacion();

        assertEquals(10,POBLACION_TEST);
    }

    @Test
    public void test04JugadorNoPuedeCrearMasDe50Unidades() {
        Jugador unJugador = new Jugador("Foo");
        Aldeano unAldeano;
        Boolean seLanzoError = false;
        try{
            for(int i=0; i<=51; i++){
                unAldeano = new Aldeano();
                unJugador.agregarUnidad(unAldeano);
            }
        }catch(TopePoblacionException e){
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }


}
