package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Excepciones.AldeanoOcupadoException;

public abstract class EstadoUnidad {
    void reparar(Edificio unEdificio, Aldeano aldeano){throw new AldeanoOcupadoException();}
    PlazaCentral construirPlazaCentral (Aldeano unAldeano, Mapa mapa, Posicion posicion){throw new AldeanoOcupadoException();}
    Cuartel construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){throw new AldeanoOcupadoException();}
    int generarOro(){return 0;}
    void trabajar(Edificio unEdificio, Aldeano unAldeano){};
}
