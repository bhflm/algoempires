package fiuba.algo3.algoempires;

import java.util.HashMap;

public class EstadoAldeanoDisponible extends EstadoUnidad {


    public void trabajar(Edificio unEdificio, Aldeano unAldeano){};
    public void reparar(Edificio unEdificio, Aldeano unAldeano){
        unAldeano.empezarReparacion(unEdificio);
        unEdificio.reparar(unAldeano);
    }

    public PlazaCentral construirPlazaCentral(Aldeano unAldeano, Mapa mapa, Posicion posicion){
        PlazaCentral plazaCentral = new PlazaCentral();
        unAldeano.empezarConstruccion(plazaCentral);
        plazaCentral.empezarConstruccion();
        plazaCentral.construir(unAldeano);
        mapa.UbicarUnidadEnMapa(posicion,plazaCentral);
        plazaCentral.actualizarUbicacion(posicion);
        return plazaCentral;
    }

    public Cuartel construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        Cuartel cuartel = new Cuartel();
        unAldeano.empezarConstruccion(cuartel);
        cuartel.empezarConstruccion();
        cuartel.construir(unAldeano);
        mapa.UbicarUnidadEnMapa(posicion,cuartel);
        cuartel.actualizarUbicacion(posicion);
        return cuartel;
    }
    public int generarOro(){
        return 20;
    };

}
