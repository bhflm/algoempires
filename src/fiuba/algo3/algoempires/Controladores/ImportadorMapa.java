package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;

import java.util.HashMap;

public class ImportadorMapa {


    public int obtenerCoordenadaVertical(Posicion posActual) {
        return posActual.getCoordenadaVertical()+1;
    }

    public int obtenerCoordenadaHorizontal(Posicion posActual, int dimenRow) {
        return posActual.getCoordenadaHorizontal()*(-1)+(dimenRow);

    }

    //La idea es que el ImportadorMapa, le pase a la parte visual la informacion del mapa, si cambia la forma de representar el mapa, cambiaria el modelo y el controlador pero la vista se mantendria
    public Mapa GenerarMapa(Mapa miMapa){
        return miMapa;
    }


}
