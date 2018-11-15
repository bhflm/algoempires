package fiuba.algo3.algoempires;

import java.util.HashMap;

public class ArmaDeAsedio extends Unidad implements Movible{

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        origen = "Castillo";
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
