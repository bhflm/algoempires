package fiuba.algo3.algoempires;

import java.util.HashMap;

public class EstadoAldeanoDisponible implements EstadoUnidad {

    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        unAldeano.empezarReparacion();
        unEdificio.reparar(unAldeano);
    }

    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        PlazaCentral plazaCentral = new PlazaCentral();
        HashMap<Posicion,Ubicable> Ubicaciones = mapa.getUbicaciones();
        plazaCentral.UbicarEn(posicion, Ubicaciones);
    }

    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        Cuartel cuartel = new Cuartel();
        HashMap<Posicion,Ubicable> Ubicaciones = mapa.getUbicaciones();
        cuartel.UbicarEn(posicion, Ubicaciones);
    }
}
