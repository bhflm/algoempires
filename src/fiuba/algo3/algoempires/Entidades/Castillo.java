package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoempires.Ubicable;

public class Castillo extends Edificio {

        public Castillo() {
            vidaMaxima = 1000;
            vida = 1000;
            dimension = 4;
            this.rangoDeAtaque=3;
            this.Nombre="Castillo";


        }

    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Posicion posicion){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        //Chequeo que se cree en alrededor del castillo
        int posicionMinima = this.getPosicion().getCoordenadaHorizontal() - 1;
        int posicionMaxima = this.getPosicion().getCoordenadaHorizontal() + this.dimension;

        if (posicion.getCoordenadaHorizontal() < posicionMinima || posicion.getCoordenadaVertical() > posicionMaxima){
            throw new PosicionInvalidaException();
        }
        mapa.UbicarUnidadEnMapa(posicion, armaDeAsedio);
        return armaDeAsedio;
    }
    
    @Override
    public void reparar(Aldeano unAldeano) {
        estado.reparar(this, 15, unAldeano);
    }
    public void continuarRepararacion(Aldeano unAldeano){
            estado.continuarReparacion(this, 15, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;}


    public void atacarA(Ubicable unidadAtacada){ unidadAtacada.recibirDanio(this); }

    }
