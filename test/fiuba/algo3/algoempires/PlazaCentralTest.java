package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlazaCentralTest {
    @Test
    public void test01PlazaCentralRecienCreadoPuntosDeVidaOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(450, unaPlazaCentral.getVida());
    }

    @Test
    public void test02PlazaCentralRecienCreadaCostoOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(1000, unaPlazaCentral.getCosto());
    }

    @Test
    public void test03PlazaCentralRecienCreadaDimensionOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(2, unaPlazaCentral.getDimension());
    }

    @Test
    public void test04PlazaCentralCreaAldeanoOk() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral unaPlazaCentral = new PlazaCentral();

        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(4, 3);
        mapa.UbicarUnidadEnMapa(pos1, unaPlazaCentral);

        Aldeano unAldeano = unaPlazaCentral.crearAldeano(mapa, pos2);
        assert (unAldeano instanceof Aldeano);
    }

    @Test
    public void test05PlazaCentralConstruyendoseEstaEnEstadoConstruyendose() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20, 20);
        Posicion pos = new Posicion(1, 2);
        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos);

        EstadoEdificio estadoPlaza = plazaCentral.getEstado();

        assertTrue(estadoPlaza instanceof EstadoEdificioConstruyendose);
    }

    @Test
    public void test06PlazaCentralConstruyendoseEstaEnEstadoNormalUnaVezConstruida() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20, 20);
        Posicion pos = new Posicion(1, 2);
        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos);

        MiAldeano.trabajar();
        MiAldeano.trabajar(); //Pasan 3 turnos

        EstadoEdificio estadoPlaza = plazaCentral.getEstado();

        assertTrue(estadoPlaza instanceof EstadoEdificioNormal);
    }

//    @Test
//    public void test07PlazaCentralConstruyendoseNoPuedeSerAtacado() {
//        Aldeano MiAldeano = new Aldeano();
//        Espadachin unEspadachin = new Espadachin();
//
//        Mapa mapa = new Mapa(20, 20);
//        Posicion pos1 = new Posicion(1, 2);
//        Posicion pos2 = new Posicion(2, 2);
//
//        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos1);
//        unEspadachin.modificarPosicion(pos2);
//
//        boolean seLanzoError = false;
//
//        try {
//            unEspadachin.atacarA(plazaCentral);
//        } catch (EdificioConstruyendoseException e) {
//            seLanzoError = true;
//        }
//        assertTrue(seLanzoError);
//    }

    @Test
    public void test08PlazaCentralCreaAldeanoEnPosicionIndicada() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral unaPlazaCentral = new PlazaCentral();

        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(4, 3);
        mapa.UbicarUnidadEnMapa(pos1, unaPlazaCentral);

        Aldeano unAldeano = unaPlazaCentral.crearAldeano(mapa, pos2);
        assert (mapa.GetUbicableEn(pos2) instanceof Aldeano);
    }

    @Test
    public void test09PlazaCentralNoPuedeCrearAldeanoSiLaPosicionOcupada() {
        Mapa mapa = new Mapa(20,20);
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        Espadachin unEspadachin = new Espadachin();

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion (3,2);

        mapa.UbicarUnidadEnMapa(pos1, unaPlazaCentral);
        mapa.UbicarUnidadEnMapa(pos2, unEspadachin);
        boolean SeLanzoError = false;

        try{
            Aldeano unAldeano = unaPlazaCentral.crearAldeano(mapa, pos2);
        } catch (UbicacionOcupadaPorOtraUnidad e) {
            SeLanzoError = true;
        }
        assertTrue(SeLanzoError);
    }

    @Test
    public void test10PlazaCentralNoPuedeCrearAldeanoFueraDeRango() {
        Mapa mapa = new Mapa(20,20);
        PlazaCentral unaPlazaCentral = new PlazaCentral();

        Posicion pos1 = new Posicion(2,3);
        Posicion pos2 = new Posicion (9,12);

        mapa.UbicarUnidadEnMapa(pos1, unaPlazaCentral);
        boolean SeLanzoError = false;

        try{
            Aldeano unAldeano = unaPlazaCentral.crearAldeano(mapa, pos2);
        } catch (PosicionInvalidaException e) {
            SeLanzoError = true;
        }
        assertTrue(SeLanzoError);
    }

}




