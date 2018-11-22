package fiuba.algo3.algoempires;

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

        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio(mapa, pos2);

        assert (unArmaDeAsedio instanceof ArmaDeAsedio);
    }

    @Test
    public void test03CastilloCreaArmaDeAsedioEnPosicionIndicada() {
        Mapa mapa = new Mapa(20, 20);
        Castillo unCastillo = new Castillo();

        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(6, 3);
        mapa.UbicarUnidadEnMapa(pos1, unCastillo);

        ArmaDeAsedio armaDeAsedio = unCastillo.crearArmaDeAsedio(mapa, pos2);
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
            ArmaDeAsedio armaDeAsedio1 = unCastillo.crearArmaDeAsedio(mapa, pos2);
        } catch (UbicacionOcupadaPorOtraUnidad e) {
            SeLanzoError = true;
        }
    }
}
