package fiuba.algo3.algoempires;

import java.util.HashMap;

public class ArmaDeAsedio extends Unidad implements Movible{

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        origen = "Castillo";
        this.estado=new EstadoArmaDeAsedioDisponible();
        this.PosicionUnidad=new Posicion(0,0);
    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
}
