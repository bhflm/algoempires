package fiuba.algo3.algoempires.Entidades;

public class EstadoAldeanoConstruyendo extends EstadoUnidad {

    public void trabajar(Edificio unEdificio, Aldeano unAldeano){
        unEdificio.construir(unAldeano);
    }

}
