package fiuba.algo3.algoempires;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArqueroTest {
    @Test
    public void test01ArqueroRecienCreadoTienePuntosDeVidaOk() {
        Arquero unArquero = new Arquero();
        assertEquals(75, unArquero.getVida());
    }

    @Test
    public void test02ArqueroRecienCostoOk() {
        Arquero unArquero = new Arquero();
        assertEquals(75, unArquero.getCosto());
    }

    @Test
    public void test03ArqueroRecienCreadoOrigenOk() {
        Arquero unArquero = new Arquero();
        assertEquals("Cuartel", unArquero.getOrigen());
    }




}



