package fiuba.algo3.algoempires;

import java.util.HashMap;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        dimension = 2;
        turnosRestantes = 3;
    }

    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 25, unAldeano);
    }

    public void crearAldeano(){
        Aldeano aldeano = new Aldeano();
        Posicion posicionUnidad = new Posicion(this.dimension,this.dimension);
        posicionUnidad.add(PosicionEdificio);
        aldeano.actualizarUbicacion(posicionUnidad);
    }
}
