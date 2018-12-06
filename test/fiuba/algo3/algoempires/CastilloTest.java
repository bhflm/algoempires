package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Entidades.ArmaDeAsedio;
import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastilloTest {

    @Test
    public void test01CastilloCreadoPuntosDeVidaOk() {
        Castillo unCastillo = new Castillo();
        assertEquals(1000, unCastillo.getVida());
    }

    @Test
    public void test02CastilloCreaArmaDeAsedioOk() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo();

        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(6, 6);
        mapa.UbicarUnidadEnMapa(pos1, unCastillo);

        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio(mapa);

        assert (unArmaDeAsedio instanceof ArmaDeAsedio);
    }

    @Test
    public void test03CastilloCreaArmaDeAsedioEnPosicionIndicada() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo();

        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(6, 3);
        mapa.UbicarUnidadEnMapa(pos1, unCastillo);

        ArmaDeAsedio armaDeAsedio = unCastillo.crearArmaDeAsedio(mapa);
        assert (mapa.GetUbicableEn(pos2) instanceof ArmaDeAsedio);
    }

    @Test
    public void test04CastilloNoPuedeCrearArmaDeAsedioSiLaPosicionOcupada() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        Posicion pos1 = new Posicion(1, 1);
        Posicion pos2 = new Posicion(1, 5);

        mapa.UbicarUnidadEnMapa(pos1, unCastillo);
        mapa.UbicarUnidadEnMapa(pos2, armaDeAsedio);
        boolean SeLanzoError = false;

        try {
            ArmaDeAsedio armaDeAsedio1 = unCastillo.crearArmaDeAsedio(mapa);
        } catch (UbicacionOcupadaPorOtraUnidad e) {
            SeLanzoError = true;
        }
    }

    @Test
    public void test05CastilloNoPuedeCrearArmaDeAsedioFueraDeRango() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo();

        Posicion pos1 = new Posicion(1, 1);
        Posicion pos2 = new Posicion(15, 15);

        mapa.UbicarUnidadEnMapa(pos1, unCastillo);
        boolean SeLanzoError = false;

        try {
            ArmaDeAsedio armaDeAsedio1 = unCastillo.crearArmaDeAsedio(mapa);
        } catch (PosicionInvalidaException e) {
            SeLanzoError = true;
        }
    }
}
