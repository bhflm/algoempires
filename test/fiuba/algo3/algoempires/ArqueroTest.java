package fiuba.algo3.algoempires;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArqueroTest {
    @Test
    public void test01ArquerooRecienCreadoTiene75PuntosDeVida() {
        Arquero MiArquero = new Arquero();
        assertEquals(75, MiArquero.getVida());
    }
    @Test
    public void test02ArqueroRecienCreadoTiene200DeCosto() {
        Arquero MiArquero = new Arquero();
        assertEquals(75, MiArquero.getCosto());
    }
}