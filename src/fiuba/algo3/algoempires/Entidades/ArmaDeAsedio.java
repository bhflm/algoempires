package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Movible;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Ubicable;

public class ArmaDeAsedio extends Unidad implements Movible {

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        origen = "Castillo";
        this.estado=new EstadoArmaDeAsedioDisponible();
        this.PosicionUnidad=new Posicion(0,0);
        this.rangoDeAtaque = 5;

    }

    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

    public void atacarA(Ubicable unidadAtacada){
        unidadAtacada.recibirDanio(this);

    }
}
