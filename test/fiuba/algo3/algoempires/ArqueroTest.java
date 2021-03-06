package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Entidades.Arquero;
import fiuba.algo3.algoempires.Entidades.Cuartel;
import fiuba.algo3.algoempires.Excepciones.AtaqueFueraDeRango;
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

        int danioProducidoPorArquero = 15;

        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionArquero =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);
        unArquero.modificarPosicion(posicionArquero);
        unAldeano.modificarPosicion(posicionAldeano);
        int vidaPreviaAldeano=unAldeano.getVida();
        unArquero.atacarA(unAldeano);
        assertEquals(vidaPreviaAldeano-danioProducidoPorArquero,unAldeano.getVida());
    }

    @Test
    public void test05ArqueroAtacaAAldeanoFueraDeRango(){
        boolean seLanzoError = false;
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        int rangoMaximo=unArquero.getRangoDeAtaque();
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

        int danioProducidoPorArqueroEdificio = 10;

        Arquero unArquero = new Arquero();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionArquero=new Posicion(1,1);
        Posicion posicionCuartel=new Posicion(3,3);
        unArquero.modificarPosicion(posicionArquero);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaCuartel=unCuartel.getVida();
        unArquero.atacarA(unCuartel);
        assertEquals(vidaPreviaCuartel-danioProducidoPorArqueroEdificio,unCuartel.getVida());

    }



}

