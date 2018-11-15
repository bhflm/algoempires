package fiuba.algo3.algoempires;

public class EstadoAldeanoReparando implements EstadoUnidad {
    @Override
    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        throw new AldeanoOcupadoException();
    }

    @Override
    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        throw new AldeanoOcupadoException();
    }

    @Override
    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        throw new AldeanoOcupadoException();
    }
}
