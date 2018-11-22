package fiuba.algo3.algoempires;
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
        Espadachin unEspadachin = unCuartel.crearEspadachin();
        assert(unEspadachin instanceof Espadachin);
    }

    @Test
    public void test05CuartelCreaArquero() {
        Cuartel unCuartel = new Cuartel();
        Arquero unArquero = unCuartel.crearArquero();
        assert(unArquero instanceof Arquero);
    }

    @Test
    public void test06CuartelConstruyendoseEstaEnEstadoConstruyendose() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos);

        assertTrue(cuartel.estado instanceof EstadoEdificioConstruyendose);
    }

    @Test
    public void test07CuartelConstruyendoseEstaEnEstadoNormalUnaVezConstruido() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos);

        MiAldeano.trabajar();
        MiAldeano.trabajar(); //Pasan 3 turnos

        assertTrue(cuartel.estado instanceof EstadoEdificioNormal);
    }

    @Test
    public void test08CuartelConstruyendoseNoPuedeSerAtacado() {
        Aldeano MiAldeano = new Aldeano();
        Espadachin unEspadachin = new Espadachin();

        Mapa mapa = new Mapa(20,20);
        Posicion pos1 = new Posicion(1, 2);
        Posicion pos2 = new Posicion(2,2);

        Cuartel cuartel = MiAldeano.construirCuartel(mapa, pos1);
        unEspadachin.modificarPosicion(pos2);

        boolean seLanzoError = false;

        try{
            unEspadachin.atacarA(cuartel);
        }
        catch(EdificioConstruyendoseException e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

}



