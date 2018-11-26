package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.*;

public class Arquero extends Unidad implements Movible, Atacante {

    public Arquero() {
        vida = 75;
        costo = 75;
        origen = "Cuartel";
        this.estado=new EstadoArqueroDisponible();
        this.PosicionUnidad=new Posicion(0,0);
        this.rangoDeAtaque = 3;
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
