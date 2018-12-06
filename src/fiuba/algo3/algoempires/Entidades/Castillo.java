package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionFueraDelMapaException;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;
import fiuba.algo3.algoempires.Ubicable;

import java.util.HashSet;
import java.util.Set;

public class Castillo extends Edificio {

    public Castillo() {
        vidaMaxima = 1000;
        vida = 1000;
        dimension = 4;
        this.rangoDeAtaque = 3;
        this.Nombre = "Castillo";


    }

    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa) {
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Set<Posicion> posicionesAdyacentes = this.getPosicionesAdyacentes();
        for (Posicion pos : posicionesAdyacentes) {
            try {
                mapa.UbicarUnidadEnMapa(pos, armaDeAsedio);
                return armaDeAsedio;
            } catch (UbicacionOcupadaPorOtraUnidad | UbicacionFueraDelMapaException e) {
                continue;
            }
        }
        throw new JugadaInvalidaException();
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
