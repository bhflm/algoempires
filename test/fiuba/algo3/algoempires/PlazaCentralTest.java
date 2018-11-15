import fiuba.algo3.algoempires.PlazaCentral;
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
}



