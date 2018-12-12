package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Excepciones.*;
import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;

import java.util.Set;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        dimension = 2;
        turnosRestantes = 3;
        this.Nombre="Cuartel";

    }

    public void continuarRepararacion(Aldeano unAldeano){
        estado.continuarReparacion(this, 50, unAldeano);
    }

    public Arquero crearArquero(Mapa mapa) {
        Arquero unArquero;
        try{unArquero = estado.crearArquero();}
        catch(EdificioConstruyendoseException e){
            throw new EdificioConstruyendoseException();
        }

        Set<Posicion> posicionesAdyacentes = this.getPosicionesAdyacentes();
        for (Posicion pos : posicionesAdyacentes) {
            try {
                mapa.UbicarUnidadEnMapa(pos, unArquero);
                return unArquero;
            } catch (UbicacionOcupadaPorOtraUnidad | UbicacionFueraDelMapaException e) {
                continue;
            }
        }
        throw new JugadaInvalidaException();
    }

    public Espadachin crearEspadachin(Mapa mapa) {
        Espadachin unEspadachin;
        try{unEspadachin= estado.crearEspadachin();}
        catch(EdificioConstruyendoseException e){
            throw new EdificioConstruyendoseException();
        }

        Set<Posicion> posicionesAdyacentes = this.getPosicionesAdyacentes();
        for (Posicion pos : posicionesAdyacentes) {
            try {
                mapa.UbicarUnidadEnMapa(pos, unEspadachin);
                return unEspadachin;
            } catch (UbicacionOcupadaPorOtraUnidad | UbicacionFueraDelMapaException e) {
                continue;
            }
        }
        throw new JugadaInvalidaException();
    }

    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 50, unAldeano);
    }


    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
