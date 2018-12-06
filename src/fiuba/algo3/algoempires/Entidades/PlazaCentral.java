package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionFueraDelMapaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;

import java.util.HashSet;
import java.util.Set;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        dimension = 2;
        turnosRestantes = 3;
        this.Nombre="PlazaCentral";

    }



    public Aldeano crearAldeano(Mapa mapa) {
        Aldeano unAldeano = estado.crearAldeano();

        Set<Posicion> posicionesAdyacentes = this.getPosicionesAdyacentes();
        for(Posicion pos: posicionesAdyacentes){
            try{
                mapa.UbicarUnidadEnMapa(pos, unAldeano);
                return unAldeano;
            } catch (UbicacionOcupadaPorOtraUnidad | UbicacionFueraDelMapaException e) {
                continue;
            }
        }
        throw new JugadaInvalidaException();
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
