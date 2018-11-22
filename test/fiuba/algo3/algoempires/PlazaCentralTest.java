package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlazaCentralTest {
    @Test
    public void test01PlazaCentralRecienCreadoPuntosDeVidaOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(450, unaPlazaCentral.getVida());
    }

    @Test
    public void test02PlazaCentralRecienCreadaCostoOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(1000, unaPlazaCentral.getCosto());
    }

    @Test
    public void test03PlazaCentralRecienCreadaDimensionOk() {
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        assertEquals(2, unaPlazaCentral.getDimension());
    }

    @Test
    public void test04PlazaCentralCreaAldeanoOk(){
        PlazaCentral unaPlazaCentral = new PlazaCentral();
        Aldeano unAldeano = unaPlazaCentral.crearAldeano();
        assert(unAldeano instanceof Aldeano);
    }

    @Test
    public void test05PlazaCentralConstruyendoseEstaEnEstadoConstruyendose() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos);

        assertTrue(plazaCentral.estado instanceof EstadoEdificioConstruyendose);
    }

    @Test
    public void test06PlazaCentralConstruyendoseEstaEnEstadoNormalUnaVezConstruida() {
        Aldeano MiAldeano = new Aldeano();
        Mapa mapa = new Mapa(20,20);
        Posicion pos = new Posicion(1, 2);
        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos);

        MiAldeano.trabajar();
        MiAldeano.trabajar(); //Pasan 3 turnos

        assertTrue(plazaCentral.estado instanceof EstadoEdificioNormal);
    }

    @Test
    public void test07PlazaCentralConstruyendoseNoPuedeSerAtacado() {
        Aldeano MiAldeano = new Aldeano();
        Espadachin unEspadachin = new Espadachin();

        Mapa mapa = new Mapa(20,20);
        Posicion pos1 = new Posicion(1, 2);
        Posicion pos2 = new Posicion(2,2);

        PlazaCentral plazaCentral = MiAldeano.construirPlazaCentral(mapa, pos1);
        unEspadachin.modificarPosicion(pos2);

        boolean seLanzoError = false;

        try{
            unEspadachin.atacarA(plazaCentral);
        }
        catch(EdificioConstruyendoseException e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }


}



