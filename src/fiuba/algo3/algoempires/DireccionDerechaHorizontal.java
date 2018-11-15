package fiuba.algo3.algoempires;

public class DireccionDerechaHorizontal implements Direccion{
    public Posicion ObtenerPosicion(Movible UnidadAMover){
        Posicion posicionPrevia= UnidadAMover.getPosicion();
        int x= posicionPrevia.getCoordenadaHorizontal();
        int y= posicionPrevia.getCoordenadaVertical();
        Posicion posicionNueva = new Posicion(x+1,y);
        return posicionNueva;
    }


}
