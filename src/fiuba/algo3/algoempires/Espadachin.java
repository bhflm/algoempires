package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Espadachin extends Unidad implements Ubicable {

    public Espadachin() {
        vida = 100;
        costo = 50;
        origen = "Cuartel";
    }

    public void UbicarEn(Posicion pos, HashMap<Posicion, Ubicable> Ubicaciones){
        Ubicaciones.put(pos,this);
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }


}
