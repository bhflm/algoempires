package fiuba.algo3.algoempires;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Excepciones.EdificioReparandoseException;
import fiuba.algo3.algoempires.Excepciones.EdificioVidaMaximaException;
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
        EstadoUnidad unEstado = new EstadoAldeanoConstruyendo();
        Aldeano MiAldeano = new Aldeano();
        MiAldeano.setEstado(unEstado);
        int oroRecaudado=MiAldeano.recaudarOro();
        assertEquals(oroRecaudado,0);

    }

    @Test
    public void test07AldeanoReparandoNoGeneraOro(){
        EstadoUnidad unEstado = new EstadoAldeanoReparando();
        Aldeano MiAldeano = new Aldeano();
        MiAldeano.setEstado(unEstado);
        int oroRecaudado=MiAldeano.recaudarOro();
        assertEquals(oroRecaudado,0);

    }
    @Test
    public void test08AldeanoReparaCuartel(){
        Aldeano MiAldeano = new Aldeano();
        Cuartel MiCuartel = new Cuartel();
        MiCuartel.RecibirDanio(60);
        MiAldeano.reparar(MiCuartel);
        int vidaPosRecuperacion= MiCuartel.getVida();
        assertEquals(vidaPosRecuperacion,240);
    }

    @Test
    public void test09AldeanoReparaDosVecesLanzaExcepcionDeAldeanoOcupado(){
        Aldeano MiAldeano = new Aldeano();
        Cuartel MiCuartel = new Cuartel();
        MiCuartel.RecibirDanio(60);
        MiAldeano.reparar(MiCuartel);

        boolean seLanzoError = false;
        try {
            MiAldeano.reparar(MiCuartel);;
        } catch (AldeanoOcupadoException e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test11DosAldeanosReparandoMismoEdificioLanzaExcepcionDeEdificioReparandose(){
        Aldeano MiAldeano1 = new Aldeano();
        Aldeano MIAldeano2 = new Aldeano();
        Cuartel MiCuartel = new Cuartel();
        MiCuartel.RecibirDanio(60);

        MiAldeano1.reparar(MiCuartel);

        boolean seLanzoError = false;
        try {
            MIAldeano2.reparar(MiCuartel);;
        } catch (EdificioReparandoseException e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test12AldeanoReparaEnTurnosConsecutivos(){
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral miPlazaCentral = new PlazaCentral();
        miPlazaCentral.RecibirDanio(60);

        int vidaInicial = miPlazaCentral.getVida();
        MiAldeano.reparar(miPlazaCentral);
        MiAldeano.trabajar();
        int VidaFinal = miPlazaCentral.getVida();

        assertTrue(VidaFinal == (vidaInicial + 50));
    }

    @Test
    public void test13AldeanoReparaMasVecesNoExcedeVidaMaxima(){
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral miPlazaCentral = new PlazaCentral();
        miPlazaCentral.RecibirDanio(60);

        MiAldeano.reparar(miPlazaCentral);
        MiAldeano.trabajar();
        MiAldeano.trabajar();
        MiAldeano.trabajar();
        int VidaFinal = miPlazaCentral.getVida();
        int VidaMaxima = miPlazaCentral.getVidaMaxima();
        assertTrue(VidaFinal == VidaMaxima);
    }

    @Test
    public void test14AldeanoRepararEdificioConVidaMaximaLanzaExcepcionVidaMaxima(){
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral miPlazaCentral = new PlazaCentral();

        boolean seLanzoError = false;
        try {
            MiAldeano.reparar(miPlazaCentral);
        } catch (EdificioVidaMaximaException e) {
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }

    public void test15AldeanoGeneraOroFinalizadaLaReparacion(){
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral miPlazaCentral = new PlazaCentral();
        miPlazaCentral.RecibirDanio(20);

        MiAldeano.reparar(miPlazaCentral);
        int oroRecaudado1 = MiAldeano.recaudarOro();

        MiAldeano.trabajar();
        int oroRecaudado2 = MiAldeano.recaudarOro();

        assertTrue(oroRecaudado1 == 0 & oroRecaudado2 == 20);
    }

    @Test
    public void test16AldeanoNoPuedeConstruirDosEdificiosALaVez(){
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(3,3);
        Posicion pos2 = new Posicion(7,7);

        MiAldeano.construirPlazaCentral(mapa, pos);

        boolean seLanzoError = false;

        try {
            MiAldeano.construirPlazaCentral(mapa, pos2);
        } catch (AldeanoOcupadoException e){
            seLanzoError = true;
        }
        assertTrue(seLanzoError);
    }
}