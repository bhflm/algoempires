package fiuba.algo3.algoempires;

public class EstadoAldeanoReparando extends EstadoUnidad {

    public void trabajar(Edificio unEdificio, Aldeano unAldeano){
        unEdificio.continuarRepararacion(unAldeano);
    }
}

