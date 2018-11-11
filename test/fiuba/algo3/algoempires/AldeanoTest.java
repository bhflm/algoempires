package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class AldeanoTest {
    @Test
    public void test01AldeanoRecienCreadoTiene150PuntosDeVida() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(100, MiAldeano.getVida());
    }
    @Test
    public void test02AldeanoRecienCreadoTiene200DeCosto() {
        Aldeano MiAldeano = new Aldeano();
        assertEquals(50, MiAldeano.getCosto());
    }
}



