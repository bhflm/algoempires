package fiuba.algo3.algoempires;

public interface EstadoUnidad {

    void reparar(Edificio unEdificio, Aldeano aldeano);
    void construirPlazaCentral (Aldeano unAldeano, Mapa mapa, Posicion posicion);
    void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion);
}
