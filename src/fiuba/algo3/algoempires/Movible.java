package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Ubicable;

import java.util.HashMap;

public interface Movible extends Ubicable {
    Posicion getPosicion();

    void RealizarMovimiento(Posicion nuevaPosicion);
}
