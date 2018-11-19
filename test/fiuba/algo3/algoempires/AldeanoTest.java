package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class AldeanoTest{
    @Test
    public void test01AldeanoRecienCreadoPuntosDeVidaOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(50, MiAldeano.getVida());
    }

    @Test
    public void test02AldeanoRecienCreadoCostoOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(25, MiAldeano.getCosto());
    }

    @Test
    public void test03AldeanoRecienCreadoOrigenOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals("Plaza central", MiAldeano.getOrigen());
    }

    @Test
    public void test04AldeanoSeDesplazaHaciaUnaNuevaPosicion(){
        Aldeano MiAldeano = new Aldeano();
        Posicion nuevaPosicion= new Posicion(2,5);
        MiAldeano.RealizarMovimiento(nuevaPosicion);
        Posicion PosicionDespuesDeMoverse =MiAldeano.getPosicion();
        assertEquals(nuevaPosicion,PosicionDespuesDeMoverse);
    }

    @Test
    public void test05AldeanoDisponibleGeneraOro(){
        Aldeano MiAldeano = new Aldeano();
        int oroRecaudado=MiAldeano.recaudarOro();
        assertEquals(oroRecaudado,20);

    }
    @Test
    public void test06AldeanoConstruyendoNoGeneraOro(){
        Aldeano MiAldeano = new Aldeano();
        MiAldeano.estado=new EstadoAldeanoConstruyendo();
        int oroRecaudado=MiAldeano.recaudarOro();
        assertEquals(oroRecaudado,0);

    }

    @Test
    public void test07AldeanoReparandoNoGeneraOro(){
        Aldeano MiAldeano = new Aldeano();
        MiAldeano.estado=new EstadoAldeanoReparando();
        int oroRecaudado=MiAldeano.recaudarOro();
        assertEquals(oroRecaudado,0);

    }
    @Test
    public void test08AldeanoReparaCuartel(){
        Aldeano MiAldeano = new Aldeano();
        Cuartel MiCuartel = new Cuartel();
        MiCuartel.Recibirdanio(60);
        MiAldeano.reparar(MiCuartel);
        int vidaPosRecuperacion= MiCuartel.getVida();
        assertEquals(vidaPosRecuperacion,240);
        int oroObtenido=MiAldeano.recaudarOro();
        System.out.println(oroObtenido);
    }

    @Test
    public void test09AldeanoConstruyeCuartel(){

    }

}
