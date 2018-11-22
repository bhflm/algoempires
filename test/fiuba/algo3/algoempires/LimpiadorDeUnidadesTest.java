package fiuba.algo3.algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LimpiadorDeUnidadesTest {
    @Test
    public void Test01LimpiaUnidadMuertaOk(){
        Mapa unMapa = new Mapa(4,4);
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Posicion posicionArquero =new Posicion(1,1);
        Posicion posicionAldeano= new Posicion(1,2);

        unArquero.modificarPosicion(posicionArquero);
        unAldeano.modificarPosicion(posicionAldeano);

        unMapa.UbicarUnidadEnMapa(posicionAldeano,unAldeano);
        unMapa.UbicarUnidadEnMapa(posicionArquero,unArquero);

        for (int i =0 ; i <=4; i++){
            unArquero.atacarA(unAldeano);
        }

        LimpiadorDeUnidadesMapa unLimpiador = new LimpiadorDeUnidadesMapa();
        unLimpiador.limpiarCelda(unMapa, unAldeano);

        Ubicable celdaLibre = unMapa.GetUbicableEn(posicionAldeano);

        assert(celdaLibre instanceof EspacioLibre);
    }
}


