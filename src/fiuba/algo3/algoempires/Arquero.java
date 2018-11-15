package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Arquero extends Unidad implements Movible{

    public Arquero() {
        vida = 75;
        costo = 75;
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
