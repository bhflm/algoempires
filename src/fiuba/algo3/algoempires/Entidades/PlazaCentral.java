package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        dimension = 2;
        turnosRestantes = 3;
        this.Nombre="PlazaCentral";

    }



    public Aldeano crearAldeano(Mapa mapa, Posicion posicion) {
        Aldeano unAldeano = estado.crearAldeano();
        //Chequeo que se cree en alrededor de la plaza central
        int posicionMinima = this.getPosicion().getCoordenadaHorizontal() - 1;
        int posicionMaxima = this.getPosicion().getCoordenadaHorizontal() + this.dimension;

        if (posicion.getCoordenadaHorizontal() < posicionMinima || posicion.getCoordenadaVertical() > posicionMaxima){
            throw new PosicionInvalidaException();
        }
        mapa.UbicarUnidadEnMapa(posicion, unAldeano);
        return unAldeano;
    }



    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 25, unAldeano);
    }
    public void continuarRepararacion(Aldeano unAldeano){
        estado.continuarReparacion(this, 25, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
