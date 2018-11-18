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
        HashMap<Posicion,Ubicable> Ubicaciones = mapa.getUbicaciones();
        plazaCentral.actualizarUbicacion(posicion);
    }

    public void construirCuartel (Aldeano unAldeano, Mapa mapa, Posicion posicion){
        unAldeano.empezarConstruccion();
        Cuartel cuartel = new Cuartel();
        HashMap<Posicion,Ubicable> Ubicaciones = mapa.getUbicaciones();
        cuartel.actualizarUbicacion(posicion);
    }
    public int generarOro(){
        return 20;
    };

}
