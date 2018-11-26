package fiuba.algo3.algoempires.Entidades;

public class EstadoAldeanoReparando extends EstadoUnidad {

    public void trabajar(Edificio unEdificio, Aldeano unAldeano){
        unEdificio.continuarRepararacion(unAldeano);
    }
}

