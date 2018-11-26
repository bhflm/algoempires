package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.PosicionInvalidaException;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        dimension = 2;
        turnosRestantes = 3;
    }

    public void continuarRepararacion(Aldeano unAldeano){
        estado.continuarReparacion(this, 50, unAldeano);
    }

    public Arquero crearArquero(Mapa mapa, Posicion posicion) {
        Arquero unArquero = estado.crearArquero();
        //Chequeo que se cree en alrededor del cuartel
        int posicionMinima = this.getPosicion().getCoordenadaHorizontal() - 1;
        int posicionMaxima = this.getPosicion().getCoordenadaHorizontal() + this.dimension;

        if (posicion.getCoordenadaHorizontal() < posicionMinima || posicion.getCoordenadaVertical() > posicionMaxima){
                throw new PosicionInvalidaException();
        }
        mapa.UbicarUnidadEnMapa(posicion, unArquero);
        return unArquero;
    }

    public Espadachin crearEspadachin(Mapa mapa, Posicion posicion) {
        Espadachin unEspadachin = estado.crearEspadachin();

        //Chequeo que se cree en alrededor del cuartel
        this.chequearPosicion(posicion, this.getPosicion(), this.dimension);

        mapa.UbicarUnidadEnMapa(posicion, unEspadachin);
        return unEspadachin;
    }

    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 50, unAldeano);
    }


    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
