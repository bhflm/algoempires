package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Aldeano extends Unidad implements Movible{

    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.origen = "Plaza central";
        this.estado = new EstadoAldeanoDisponible();
        this.PosicionUnidad = new Posicion(0,0);
    }

    public void desocupar() {
        this.estado = new EstadoAldeanoDisponible();
    }

    public void reparar(Edificio unEdificio){
        this.estado.reparar(unEdificio, this);
    }

    public void empezarReparacion(){
        this.estado = new EstadoAldeanoReparando();
    }

    public void construirCuartel(Mapa mapa, Posicion posicion) {
        this.estado.construirCuartel(this, mapa, posicion);
    }

    public void construirPlazaCentral(Mapa mapa, Posicion posicion) {
        this.estado.construirPlazaCentral(this, mapa, posicion);
    }

    public void empezarConstruccion(){
        this.estado = new EstadoAldeanoConstruyendo();
    }


    public void actualizarUbicacion(Posicion pos){
        this.PosicionUnidad=pos;
    }
    public void RealizarMovimiento(Posicion nuevaPosicion){
        this.PosicionUnidad=nuevaPosicion;
    }

    public int recaudarOro(){
        return this.estado.generarOro();
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
