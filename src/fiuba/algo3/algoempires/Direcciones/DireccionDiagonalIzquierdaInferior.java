package fiuba.algo3.algoempires.Direcciones;

import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Movible;

public class DireccionDiagonalIzquierdaInferior implements Direccion {
    public Posicion ObtenerPosicion(Movible UnidadAMover){
        Posicion posicionPrevia= UnidadAMover.getPosicion();
        int x= posicionPrevia.getCoordenadaHorizontal();
        int y= posicionPrevia.getCoordenadaVertical();
        Posicion posicionNueva = new Posicion(x-1,y-1);
        return posicionNueva;
    }
}
