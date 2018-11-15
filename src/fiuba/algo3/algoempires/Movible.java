package fiuba.algo3.algoempires;

import java.util.HashMap;

public interface Movible extends Ubicable {
    Posicion getPosicion();

    void RealizarMovimiento(Posicion nuevaPosicion);
}
