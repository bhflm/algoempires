package fiuba.algo3.algoempires;

public class EstadoAldeanoDisponible implements EstadoUnidad {
    @Override
    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        unAldeano.empezarReparacion();
        unEdificio.reparar(unAldeano);
    }

    @Override
    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        //Construir
    }

    @Override
    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        //Construir
    }
}
