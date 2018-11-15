package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Espadachin extends Unidad implements Movible {

    public Espadachin() {
        vida = 100;
        costo = 50;
        origen = "Cuartel";
        this.PosicionUnidad=new Posicion(0,0);
    }

    public void UbicarEn(Posicion pos, HashMap<Posicion, Ubicable> Ubicaciones){
        this.PosicionUnidad=pos;
        Ubicaciones.put(pos,this);
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }

}
