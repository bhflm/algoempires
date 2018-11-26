package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.*;
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

        Espadachin unEspadachin = unCuartel.crearEspadachin(mapa, pos2);

        assert(unEspadachin instanceof Espadachin);
    }

    @Test
    public void test05CuartelCreaArquero() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (4,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Arquero unArquero = unCuartel.crearArquero(mapa, pos2);
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

//    @Test
//    public void test08CuartelConstruyendoseNoPuedeSerAtacado() {
//        Aldeano MiAldeano = new Aldeano();
//        Espadachin unEspadachin = new Espadachin();
//
//        Mapa mapa = new Mapa(20,20);
//        Posicion pos1 = new Posicion(1, 2);
//        Posicion pos2 = new Posicion(2,2);
//
//        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos1);
//        unEspadachin.modificarPosicion(pos2);
//
//        boolean seLanzoError = false;
//
//        try{
//            unEspadachin.atacarA(cuartel);
//        }
//        catch(EdificioConstruyendoseException e){
//            seLanzoError=true;
//        }
//        assertTrue(seLanzoError);
//    }

    @Test
    public void test09CuartelNoPuedeCrearArqueroSiLaPosicionOcupada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();
        Espadachin unEspadachin = new Espadachin();

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion (3,3);

        mapa.UbicarUnidadEnMapa(pos1, unCuartel);
        mapa.UbicarUnidadEnMapa(pos2, unEspadachin);
        boolean SeLanzoError = false;

        try{
            Arquero unArquero = unCuartel.crearArquero(mapa, pos2);
        } catch (UbicacionOcupadaPorOtraUnidad e) {
            SeLanzoError = true;
        }

        assertTrue(SeLanzoError);
    }

    @Test
    public void test10CuartelNoPuedeCrearEspadachinSiLaPosicionOcupada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();
        Espadachin unEspadachin = new Espadachin();

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion (3,2);

        mapa.UbicarUnidadEnMapa(pos1, unCuartel);
        mapa.UbicarUnidadEnMapa(pos2, unEspadachin);
        boolean SeLanzoError = false;

        try{
            Espadachin otroEspadachin = unCuartel.crearEspadachin(mapa, pos2);
        } catch (UbicacionOcupadaPorOtraUnidad e) {
            SeLanzoError = true;
        }
        assertTrue(SeLanzoError);
    }

    @Test
    public void test11CuartelCreaArqueroEnPosicionIndicada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (4,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Arquero unArquero = unCuartel.crearArquero(mapa, pos2);
        assert(mapa.GetUbicableEn(pos2) instanceof Arquero);
    }

    @Test
    public void test12CuartelCreaEspadachinEnPosicionIndicada() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(2,2);
        Posicion pos2 = new Posicion (1,3);
        mapa.UbicarUnidadEnMapa(pos1, unCuartel);

        Espadachin unEspadachin = unCuartel.crearEspadachin(mapa, pos2);
        assert(mapa.GetUbicableEn(pos2) instanceof Espadachin);
    }

    @Test
    public void test13CuartelNoPuedeCrearEspadachinFueraDeSuRango() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion (4,4);

        mapa.UbicarUnidadEnMapa(pos1, unCuartel);
        boolean SeLanzoError = false;

        try{
            Espadachin unEspadachin = unCuartel.crearEspadachin(mapa, pos2);
        } catch (PosicionInvalidaException e) {
            SeLanzoError = true;
        }
        assertTrue(SeLanzoError);
    }

    @Test
    public void test14CuartelNoPuedeCrearArqueroFueraDeSuRango() {
        Mapa mapa = new Mapa(20,20);
        Cuartel unCuartel = new Cuartel();

        Posicion pos1 = new Posicion(8,3);
        Posicion pos2 = new Posicion (14,14);

        mapa.UbicarUnidadEnMapa(pos1, unCuartel);
        boolean SeLanzoError = false;

        try{
            Arquero unArquero = unCuartel.crearArquero(mapa, pos2);
        } catch (PosicionInvalidaException e) {
            SeLanzoError = true;
        }
        assertTrue(SeLanzoError);
    }

}



