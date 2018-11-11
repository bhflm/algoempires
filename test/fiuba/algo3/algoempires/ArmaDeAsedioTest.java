import fiuba.algo3.algoempires.ArmaDeAsedio;
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


}



