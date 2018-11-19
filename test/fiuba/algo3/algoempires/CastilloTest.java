package fiuba.algo3.algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastilloTest {

    @Test
    public void test01CastilloCreadoPuntosDeVidaOk() {
        Castillo unCastillo = new Castillo();
        assertEquals(1000,unCastillo.getVida());
    }

    @Test
    public void test02CastilloCreaArmaDeAsedioOk(){
        Castillo unCastillo = new Castillo();
        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio();
        assert(unArmaDeAsedio instanceof ArmaDeAsedio);
    }
    
}
