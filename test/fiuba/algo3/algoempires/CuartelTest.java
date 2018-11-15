import fiuba.algo3.algoempires.Cuartel;
import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {
    @Test
    public void test01CuartelRecienCreadoPuntosDeVidaOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(250, unCuartel.getVida());
    }

    @Test
    public void test02CuartelRecienCreadoCostoOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(50, unCuartel.getCosto());
    }

    @Test
    public void test03CuartelRecienCreadoDimensionOk() {
        Cuartel unCuartel = new Cuartel();
        assertEquals(2, unCuartel.getDimension());
    }
}



