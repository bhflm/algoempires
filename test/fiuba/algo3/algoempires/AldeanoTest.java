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
        MiCuartel.recibirDanio(60);
        MiAldeano.reparar(MiCuartel);
        int vidaPosRecuperacion= MiCuartel.getVida();
        assertEquals(vidaPosRecuperacion,240);
    }

    @Test
    public void test09AldeanoReparaDosVecesLanzaExcepcionDeAldeanoOcupado(){
        Aldeano MiAldeano = new Aldeano();
        Cuartel MiCuartel = new Cuartel();
        MiCuartel.recibirDanio(60);
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
        MiCuartel.recibirDanio(60);

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
        miPlazaCentral.recibirDanio(60);

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
        miPlazaCentral.recibirDanio(60);

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

    @Test
    public void test15AldeanoGeneraOroFinalizadaLaReparacion(){
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral miPlazaCentral = new PlazaCentral();
        miPlazaCentral.recibirDanio(30);

        MiAldeano.reparar(miPlazaCentral);
        int oroRecaudado1 = MiAldeano.recaudarOro();

        MiAldeano.trabajar();
        int oroRecaudado2 = MiAldeano.recaudarOro();

        assertTrue(oroRecaudado1 == 0 & oroRecaudado2 == 20);
    }

    @Test
    public void test16AldeanoConstruyendoEstaEnEstadoConstruyendo() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        MiAldeano.construirCuartel(mapa, pos);

        assertTrue(MiAldeano.estado instanceof EstadoAldeanoConstruyendo);
    }

    @Test
    public void test17AldeanoConstruyendoNoPuedeConstruirOtroEdificio() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos1 = new Posicion(1, 2);
        Posicion pos2 = new Posicion(5,5);
        MiAldeano.construirCuartel(mapa, pos1);
        boolean seLanzoError=false;

        try{
            MiAldeano.construirCuartel(mapa, pos1);
        }
        catch(AldeanoOcupadoException e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test17AldeanoConstruyendoNoPuedeRepararOtroEdificio() {
        Aldeano MiAldeano = new Aldeano();
        PlazaCentral MiPlaza = new PlazaCentral();
        Mapa mapa = new Mapa(20,20);
        Posicion pos1 = new Posicion(1, 2);
        MiAldeano.construirCuartel(mapa, pos1);
        MiPlaza.recibirDanio(40);
        boolean seLanzoError=false;

        try{
            MiAldeano.reparar(MiPlaza);
        }
        catch(AldeanoOcupadoException e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test18AldeanoConstruyendoSeLiberaUnaVezConstruidoElEdificio() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        MiAldeano.construirCuartel(mapa, pos);
        MiAldeano.trabajar();
        MiAldeano.trabajar();
        MiAldeano.trabajar(); //Pasan 3 turnos

        assertTrue(MiAldeano.estado instanceof EstadoAldeanoDisponible);
    }
}