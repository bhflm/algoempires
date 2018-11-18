package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Espadachin extends Unidad implements Movible {

    public Espadachin() {
        vida = 100;
        costo = 50;
        origen = "Cuartel";
        this.estado=new EstadoEspadachinDisponible();
        this.PosicionUnidad=new Posicion(0,0);
    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }

}
