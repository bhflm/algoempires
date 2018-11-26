package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.ArmaDeAsedio;
import fiuba.algo3.algoempires.Entidades.Cuartel;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArmaDeAsedioTest {
    @Test
    public void test01ArmaDeAsedioRecienCreadoPuntosDeVidaOk() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();
        assertEquals(150,unArmaDeAsedio.getVida());
    }
    @Test
    public void test02ArmaDeAsedioRecienCreadoCostoOk() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();
        assertEquals(200,unArmaDeAsedio.getCosto());
    }
    @Test
    public void test03ArmaDeAsedioRecienCreadoOrigenOk() {
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();
        assertEquals("Castillo",unArmaDeAsedio.getOrigen());
    }

    @Test
    public void test04ArmaDeAsedioAtacaAUnCuartel(){

        int danioProducidoPorArmaDeAsedioContraEdificios = 75;

        ArmaDeAsedio unArquero = new ArmaDeAsedio();
        Cuartel unCuartel = new Cuartel();
        Posicion posicionArmaDeAsedio=new Posicion(1,1);
        Posicion posicionCuartel=new Posicion(3,3);
        unArquero.modificarPosicion(posicionArmaDeAsedio);
        unCuartel.modificarPosicion(posicionCuartel);
        int vidaPreviaCuartel=unCuartel.getVida();
        unArquero.atacarA(unCuartel);
        assertEquals(vidaPreviaCuartel-danioProducidoPorArmaDeAsedioContraEdificios,unCuartel.getVida());

    }

    @Test
    public void test05ArmaDeAsedioAtacaACuartelFueraDeRango(){
        boolean seLanzoError = false;
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();
        Cuartel unCuartel = new Cuartel();
        int rangoMaximo=unArmaDeAsedio.getRangoDeAtaque();
        Posicion posicionArmaDeAsedio =new Posicion(1,1);
        Posicion posicionCuartel= new Posicion(1,(1+rangoMaximo)+1);
        unArmaDeAsedio.modificarPosicion(posicionArmaDeAsedio);
        unCuartel.modificarPosicion(posicionCuartel);
        try{
            unArmaDeAsedio.atacarA(unCuartel);
        }
        catch(AtaqueFueraDeRango e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

}
