package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Movible;

public class Aldeano extends Unidad implements Movible {

    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.edificioActual = null;
        this.estado = new EstadoAldeanoDisponible();
        this.PosicionUnidad = new Posicion(0,0);
        this.Nombre="Aldeano";
    }

    public void setEstado(EstadoUnidad nuevoEstado) { this.estado = nuevoEstado;}

    public void desocupar() {
        this.estado = new EstadoAldeanoDisponible();
    }

    public void reparar(Edificio unEdificio){
        this.estado.reparar(unEdificio, this);
    }

    public void empezarReparacion(Edificio unEdificio){
        this.estado = new EstadoAldeanoReparando();
        this.edificioActual = unEdificio;
    }

    public Cuartel construirCuartel(Mapa mapa, Posicion posicion) {
        Cuartel cuartel = this.estado.construirCuartel(this, mapa, posicion);
        return cuartel;
    }

    public PlazaCentral construirPlazaCentral(Mapa mapa, Posicion posicion) {
        PlazaCentral plazaCentral = this.estado.construirPlazaCentral(this, mapa, posicion);
        return plazaCentral;
    }

    public void empezarConstruccion(Edificio unEdificio){
        this.estado = new EstadoAldeanoConstruyendo();
        this.edificioActual = unEdificio;
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
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;}
    public void trabajar(){estado.trabajar(edificioActual,this);}
}
