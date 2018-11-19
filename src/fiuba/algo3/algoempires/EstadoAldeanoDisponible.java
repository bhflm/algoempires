package fiuba.algo3.algoempires;

import java.util.HashMap;

public class EstadoAldeanoDisponible extends EstadoUnidad {

    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        unAldeano.empezarReparacion();
        unEdificio.reparar(unAldeano);
    }

    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        PlazaCentral plazaCentral = new PlazaCentral();
        mapa.UbicarUnidadEnMapa(posicion,plazaCentral);
        plazaCentral.actualizarUbicacion(posicion);
    }

    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        Cuartel cuartel = new Cuartel();
        mapa.UbicarUnidadEnMapa(posicion,cuartel);
        cuartel.actualizarUbicacion(posicion);
    }
    public int generarOro(){
        return 20;
    };

}
