package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Excepciones.AtaqueFueraDeRango;
import fiuba.algo3.algoempires.Movible;

public class Arquero extends Unidad implements Movible, Atacante {

    public Arquero() {
        vida = 75;
        costo = 75;
        origen = "Cuartel";
        this.estado = new EstadoArqueroDisponible();
        this.PosicionUnidad = new Posicion(0, 0);
        this.rangoDeAtaque = 3;
        this.Nombre = "Arquero";

    }

    public void actualizarUbicacion(Posicion pos) {
        this.PosicionUnidad = pos;
    }

    public void RealizarMovimiento(Posicion nuevaPosicion) {
        this.PosicionUnidad = nuevaPosicion;
    }

    public boolean esPisableEnElMapa() {
        return this.PisableEnElMapa;
    }

    ;

    public void atacarA(Ubicable unidadAtacada) {
        try {
            unidadAtacada.recibirDanio(this);
        } catch (AtaqueFueraDeRango e) {
            throw new AtaqueFueraDeRango();
        }

    }
}