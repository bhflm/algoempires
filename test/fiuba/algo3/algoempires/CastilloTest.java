package fiuba.algo3.algoempires;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CastilloTest {

    @Test
    public void test01CastilloCreadoPuntosDeVidaOk() {
        Castillo unCastillo = new Castillo();
        assertEquals(1000,unCastillo.getVida());
    }

    @Test
    public void test02CastilloCreaArmaDeAsedioOk(){
        Castillo unCastillo = new Castillo();
        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio();
        assert(unArmaDeAsedio instanceof ArmaDeAsedio);
    }
    @Test
    public void test03CastilloAtacaAAldeano(){
        Castillo unCastillo = new Castillo();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionCastillo =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);
        unCastillo.modificarPosicion(posicionCastillo);
        unAldeano.modificarPosicion(posicionAldeano);
        int vidaPreviaAldeano=unAldeano.getVida();
        unCastillo.atacarA(unAldeano);
        assertEquals(vidaPreviaAldeano-unCastillo.getPuntosDeAtaqueUnidad(),unAldeano.getVida());
    }

    @Test
    public void test04CastilloAtacaACuartel(){
        Castillo unCastillo = new Castillo();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionCastillo =new Posicion(1,1);
        Posicion posicionCuartel= new Posicion(1,2);
        unCastillo.modificarPosicion(posicionCastillo);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaAldeano=unCuartel.getVida();
        unCastillo.atacarA(unCuartel);
        assertEquals(vidaPreviaAldeano-unCastillo.getPuntosDeAtaqueUnidad(),unCuartel.getVida());
    }

    @Test
    public void test05CastilloAtacaAAldeanoFueraDeRango(){
        boolean seLanzoError=false;
        Castillo unCastillo = new Castillo();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionCastillo =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,4+3+1);
        unCastillo.modificarPosicion(posicionCastillo);
        unAldeano.modificarPosicion(posicionAldeano);
        try{unCastillo.atacarA(unAldeano);}
        catch(AtaqueFueraDeRango e){seLanzoError=true;}
        assertTrue(seLanzoError);
    }





    @Test
    public void test06CastilloAtacaACuartel(){
        Castillo unCastillo = new Castillo();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionCastillo =new Posicion(1,1);
        Posicion posicionCuartel= new Posicion(1,2);
        unCastillo.modificarPosicion(posicionCastillo);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaAldeano=unCuartel.getVida();
        unCastillo.atacarA(unCuartel);
        assertEquals(vidaPreviaAldeano-unCastillo.getPuntosDeAtaqueEdificio(),unCuartel.getVida());
    }

}
