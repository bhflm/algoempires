package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Aldeano extends Unidad implements Movible{

    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.origen = "Plaza central";
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
