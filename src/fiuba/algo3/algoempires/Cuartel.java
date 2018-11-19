package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        dimension = 2;
        turnosRestantes = 3;
    }
    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 50, unAldeano);
    }

    public void crearEspadachin(){
        Espadachin espadachin = new Espadachin();
        Posicion posicionUnidad = new Posicion(this.dimension,this.dimension);
        posicionUnidad.add(PosicionEdificio);
        espadachin.actualizarUbicacion(posicionUnidad);
    }

    public void crearArquero(){
        Arquero arquero = new Arquero();
        Posicion posicionUnidad = new Posicion(this.dimension,this.dimension);
        posicionUnidad.add(PosicionEdificio);
        arquero.actualizarUbicacion(posicionUnidad);
    }

    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
