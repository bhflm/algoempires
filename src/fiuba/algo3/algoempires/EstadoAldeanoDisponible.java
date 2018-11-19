package fiuba.algo3.algoempires;

import java.util.HashMap;

public class EstadoAldeanoDisponible extends EstadoUnidad {


    public void trabajar(Edificio unEdificio, Aldeano unAldeano){};
    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        unAldeano.empezarReparacion(unEdificio);
        unEdificio.reparar(unAldeano);
    }

    public void construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        PlazaCentral plazaCentral = new PlazaCentral();
        unAldeano.empezarConstruccion(plazaCentral);
        plazaCentral.empezarConstruccion();
        mapa.UbicarUnidadEnMapa(posicion,plazaCentral);
        plazaCentral.actualizarUbicacion(posicion);
    }

    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        Cuartel cuartel = new Cuartel();
        unAldeano.empezarConstruccion(cuartel);
        cuartel.empezarConstruccion();
        mapa.UbicarUnidadEnMapa(posicion,cuartel);
        cuartel.actualizarUbicacion(posicion);
    }
    public int generarOro(){
        return 20;
    };

}
