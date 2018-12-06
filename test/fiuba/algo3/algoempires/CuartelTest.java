package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.EdificioConstruyendoseException;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {
    @Test
    public void test01CuartelRecienCreadoPuntosDeVidaOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(250, unCuartel.getVida());
    }

    @Test
    public void test02CuartelRecienCreadoCostoOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(50, unCuartel.getCosto());
    }

    @Test
    public void test03CuartelRecienCreadoDimensionOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(2, unCuartel.getDimension());
    }

    @Test
    public void test04CuartelCreaEspadachin() {
        Cuartel unCuartel = new Cuartel();
        Mapa mapa = new Mapa(20,20);

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (4,3);

        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Espadachin unEspadachin = unCuartel.crearEspadachin(mapa);

        assert(unEspadachin instanceof Espadachin);
    }

    @Test
    public void test05CuartelCreaArquero() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (4,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Arquero unArquero = unCuartel.crearArquero(mapa);
        assert(unArquero instanceof Arquero);
    }

    @Test
    public void test06CuartelConstruyendoseEstaEnEstadoConstruyendose() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos);
        EstadoEdificio estadoCuartel = cuartel.getEstado();
        assertTrue(estadoCuartel instanceof EstadoEdificioConstruyendose);
    }

    @Test
    public void test07CuartelConstruyendoseEstaEnEstadoNormalUnaVezConstruido() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos);

        MiAldeano.trabajar();
        MiAldeano.trabajar(); //Pasan 3 turnos

        EstadoEdificio estadoCuartel = cuartel.getEstado();


        assertTrue(estadoCuartel instanceof EstadoEdificioNormal);
    }

    @Test
    public void test10CuartelCreaArqueroEnPosicionIndicada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (4,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Arquero unArquero = unCuartel.crearArquero(mapa);
        assert(mapa.GetUbicableEn(pos2) instanceof Arquero);
    }

    @Test
    public void test11CuartelCreaEspadachinEnPosicionIndicada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (1,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Espadachin unEspadachin = unCuartel.crearEspadachin(mapa);
        assert(mapa.GetUbicableEn(pos2) instanceof Espadachin);
    }

}