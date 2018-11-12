package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class AldeanoTest {
    @Test
    public void test01AldeanoRecienCreadoPuntosDeVidaOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(50, MiAldeano.getVida());
    }
    @Test
    public void test03AldeanoRecienCreadoOrigenOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals("Plaza central", MiAldeano.getOrigen());
    }
    @Test
    public void test02AldeanoRecienCreadoCostoOk() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(25, MiAldeano.getCosto());
    }



}
