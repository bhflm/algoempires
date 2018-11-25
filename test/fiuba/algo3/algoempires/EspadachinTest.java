package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class EspadachinTest {
    @Test
    public void test01EspadachinRecienCreadoPuntosDeVidaOk() {
        Espadachin unEspadachin = new Espadachin();
        assertEquals(100, unEspadachin.getVida());
    }

    @Test
    public void test02EspadachinRecienCreadoCostoOk() {
        Espadachin unEspadachin = new Espadachin();
        assertEquals(50, unEspadachin.getCosto());
    }

    @Test
    public void test03EspadachinRecienCreadoOrigenOk() {
        Espadachin unEspadachin = new Espadachin();
        assertEquals("Cuartel", unEspadachin.getOrigen());
    }

    @Test
    public void test04EspadachinAtacaAAldeano(){
        Espadachin unEspadachin = new Espadachin();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionEspadachin =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);
        unEspadachin.modificarPosicion(posicionEspadachin);
        unAldeano.modificarPosicion(posicionAldeano);
        int vidaPreviaAldeano=unAldeano.getVida();
        unEspadachin.atacarA(unAldeano);
        assertEquals(vidaPreviaAldeano-unEspadachin.puntosDeAtaqueUnidad,unAldeano.getVida());
    }

    @Test
    public void test05EspadachinAtacaAAldeanoFueraDeRango(){
        boolean seLanzoError = false;
        Espadachin unEspadachin = new Espadachin();
        Aldeano unAldeano = new Aldeano();
        int rangoMaximo=unEspadachin.rangoDeAtaque;
        Posicion posicionEspadachin =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,(1+rangoMaximo)+1);
        unEspadachin.modificarPosicion(posicionEspadachin);
        unAldeano.modificarPosicion(posicionAldeano);
        try{
            unEspadachin.atacarA(unAldeano);
        }
        catch(AtaqueFueraDeRango e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test06EspadachinAtacaAUnCuartel(){
        Espadachin unEspadachin = new Espadachin();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionEspadachin=new Posicion(1,1);
        Posicion posicionCuartel=new Posicion(1,2);
        unEspadachin.modificarPosicion(posicionEspadachin);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaCuartel=unCuartel.getVida();
        unEspadachin.atacarA(unCuartel);
        assertEquals(vidaPreviaCuartel-unEspadachin.puntosDeAtaqueEdificio,unCuartel.getVida());

    }
}



