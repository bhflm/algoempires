package fiuba.algo3.algoempires;

public class EstadoAldeanoReparando extends EstadoUnidad {

    public void trabajar(Edificio unEdificio, Aldeano unAldeano){
        unEdificio.continuarRepararacion(unAldeano);
    }

    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        throw new AldeanoOcupadoException();
    }

    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        throw new AldeanoOcupadoException();
    }

    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        throw new AldeanoOcupadoException();
    }
}

