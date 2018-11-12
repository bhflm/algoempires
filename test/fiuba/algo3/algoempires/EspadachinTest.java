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

}



