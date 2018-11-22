package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArqueroTest {
    @Test
    public void test01ArqueroRecienCreadoTienePuntosDeVidaOk() {
        Arquero unArquero = new Arquero();
        assertEquals(75, unArquero.getVida());
    }

    @Test
    public void test02ArqueroRecienCostoOk() {
        Arquero unArquero = new Arquero();
        assertEquals(75, unArquero.getCosto());
    }

    @Test
    public void test03ArqueroRecienCreadoOrigenOk() {
        Arquero unArquero = new Arquero();
        assertEquals("Cuartel", unArquero.getOrigen());
    }

    @Test
    public void test04ArqueroAtacaAAldeano(){
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionArquero =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);
        unArquero.modificarPosicion(posicionArquero);
        unAldeano.modificarPosicion(posicionAldeano);
        int vidaPreviaAldeano=unAldeano.getVida();
        unArquero.atacarA(unAldeano);
        assertEquals(vidaPreviaAldeano-unArquero.puntosDeAtaqueUnidad,unAldeano.getVida());
    }

    @Test
    public void test05ArqueroAtacaAAldeanoFueraDeRango(){
        boolean seLanzoError = false;
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        int rangoMaximo=unArquero.rangoDeAtaque;
        Posicion posicionArquero =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,(1+rangoMaximo)+1);
        unArquero.modificarPosicion(posicionArquero);
        unAldeano.modificarPosicion(posicionAldeano);
        int vidaPreviaAldeano=unAldeano.getVida();
        try{
            unArquero.atacarA(unAldeano);
        }
        catch(AtaqueFueraDeRango e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test06ArqueroAtacaAUnCuartel(){
        Arquero unArquero = new Arquero();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionArquero=new Posicion(1,1);
        Posicion posicionCuartel=new Posicion(3,3);
        unArquero.modificarPosicion(posicionArquero);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaCuartel=unCuartel.getVida();
        unArquero.atacarA(unCuartel);
        assertEquals(vidaPreviaCuartel-unArquero.puntosDeAtaqueEdificio,unCuartel.getVida());

    }

    @Test
    public void test07ArqueroAtacaAldeanoYLoMata(){
        Mapa unMapa = new Mapa(4,4);
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionArquero =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);

        unArquero.modificarPosicion(posicionArquero);
        unAldeano.modificarPosicion(posicionAldeano);

        unMapa.UbicarUnidadEnMapa(posicionAldeano,unAldeano);
        unMapa.UbicarUnidadEnMapa(posicionArquero,unArquero);

        for (int i =0 ; i <=4; i++){
            unArquero.atacarA(unAldeano);
        }

        LimpiadorDeUnidadesMapa unLimpiador = new LimpiadorDeUnidadesMapa();
        unLimpiador.limpiarCelda(unMapa, unAldeano);

        Ubicable celdaLibre = unMapa.GetUbicableEn(posicionAldeano);

        assert(celdaLibre instanceof EspacioLibre);
    }

}



