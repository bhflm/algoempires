package fiuba.algo3.algoempires;

import java.util.Set;
import java.util.HashSet;

public class Jugador {

    private Boolean jugando;
    private int oro;
    private int poblacion;
    private String nombre;
    private Set<Unidad> unidadesJugador = new HashSet<Unidad>();
    private Set<Edificio> edificiosJugador = new HashSet<Edificio>();

    Jugador(String nombreJugador) {
        this.oro = 50;
        this.poblacion = 3;
        this.nombre = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }


    public void agregarUnidad(Unidad unaUnidad){
        this.unidadesJugador.add((unaUnidad));
    }

    public boolean perteneceUnidad(Unidad unaUnidad){
        return (this.unidadesJugador.contains(unaUnidad));
    }

    public void moverUnidad(Juego unJuego, Mapa unMapa,Movible unaUnidad, Direccion unaDireccion){
        Posicion posicionMover = unaDireccion.ObtenerPosicion(unaUnidad);
        unMapa.MoverUnidad(posicionMover,unaUnidad);
        unJuego.cambiarTurno();
    }
}
