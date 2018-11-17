package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Arquero extends Unidad implements Movible{

    public Arquero() {
        vida = 75;
        costo = 75;
        origen = "Cuartel";
        this.estado=new EstadoArqueroDisponible();
        this.PosicionUnidad=new Posicion(0,0);
    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }

}
