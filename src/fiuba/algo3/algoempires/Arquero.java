package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Arquero extends Unidad implements Ubicable{

    public Arquero() {
        vida = 75;
        costo = 75;
        origen = "Cuartel";
    }

    public void UbicarEn(Posicion pos, HashMap<Posicion, Ubicable> Ubicaciones){
        Ubicaciones.put(pos,this);
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }


}
