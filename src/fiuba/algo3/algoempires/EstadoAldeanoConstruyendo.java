package fiuba.algo3.algoempires;

public class EstadoAldeanoConstruyendo implements EstadoUnidad {

    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        throw new AldeanoOcupadoException();
    }

    public void construirPlazaCentral(Aldeano unAldeano, Posicion posicion){
        throw new AldeanoOcupadoException();
    }

    public void construirCuartel (Aldeano unAldeano, Posicion posicion){
        throw new AldeanoOcupadoException();
    }
}
