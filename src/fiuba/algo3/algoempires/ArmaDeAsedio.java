package fiuba.algo3.algoempires;

import java.util.HashMap;

public class ArmaDeAsedio extends Unidad implements Movible{

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        origen = "Castillo";
    }

    public void UbicarEn(Posicion pos, HashMap<Posicion, Ubicable> Ubicaciones){
        Ubicaciones.put(pos,this);
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
}
