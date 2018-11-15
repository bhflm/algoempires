package fiuba.algo3.algoempires;

public abstract class EstadoUnidad {
    void reparar(Edificio unEdificio, Aldeano aldeano){};
    void construirPlazaCentral (Aldeano unAldeano, Mapa mapa, Posicion posicion){};
    void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){};
    int generarOro(){return 0;};
}
