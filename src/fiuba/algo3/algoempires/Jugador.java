package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Direcciones.Direccion;
import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Entidades.Edificio;
import fiuba.algo3.algoempires.Entidades.Unidad;
import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import fiuba.algo3.algoempires.Excepciones.MovimientoFueraDelMapa;
import fiuba.algo3.algoempires.Excepciones.TopePoblacionException;

import java.util.*;

public class Jugador {

    private Boolean jugando;
    private int oro;
    private int poblacion;
    private String nombre;
    private Set<Unidad> unidadesJugador = new HashSet<Unidad>();
    private Set<Edificio> edificiosJugador = new HashSet<Edificio>();
    private boolean perdio = false;

    Jugador(String nombreJugador) {
        this.oro = 0;
        this.poblacion = 0;
        this.nombre = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarUnidad(Unidad unaUnidad){
        if(this.poblacion >= 50) throw new TopePoblacionException();
        this.unidadesJugador.add((unaUnidad));
        this.poblacion++;
    }

    public void agregarEdificio(Edificio unEdificio){this.edificiosJugador.add(unEdificio);}

    public void moverUnidad(Juego unJuego, Mapa unMapa, Movible unaUnidad, Direccion unaDireccion){
        Posicion posicionMover = unaDireccion.ObtenerPosicion(unaUnidad);
        unMapa.MoverUnidad(posicionMover,unaUnidad);
        if (unJuego.getNombreActual() != this.nombre ){
            throw new JugadaInvalidaException();
        }
        unJuego.cambiarTurno();
    }

    public boolean perteneceUnidad(Ubicable unUbicable){
        boolean seEncuentra=false;
        if(this.unidadesJugador.contains(unUbicable) || this.edificiosJugador.contains(unUbicable))
            seEncuentra=true;
        return seEncuentra;
    }

    public void agregarOro(int oroAAgregar) {
        this.oro=oroAAgregar;
    }

    public int getPoblacion() {
        return this.poblacion;
    }

    public int getOro() {
        return this.oro;
    }

    public void realizarAtaque(Atacante MiAtacante,Ubicable MiObjetivo){
        boolean EstaUnidadEsMia=this.perteneceUnidad(MiObjetivo);
        if(!EstaUnidadEsMia)
            MiAtacante.atacarA(MiObjetivo);
        else throw new JugadaInvalidaException();
    }


    public void CastilloRealizaAtaqueMasivo(Castillo miCastillo, Mapa miMapa) {
        Posicion posicionCastillo = miCastillo.getPosicion();
        boolean esDelJugador = false;
        boolean esValidaLaUbicacionDeAtaque = true;
        int rangoAtaque = miCastillo.getRango();
        for (int i = -rangoAtaque; i < (rangoAtaque + miCastillo.getDimension()); i++)
            for (int j = -rangoAtaque; j < (rangoAtaque + miCastillo.getDimension()); j++) {
                Posicion posicionAAtacar = posicionCastillo.PosicionCorridaA(i, j);
                esValidaLaUbicacionDeAtaque = true;
                try {
                    posicionAAtacar.ValidarPosicion(miMapa.getLargoHorizontal(), miMapa.getLargoVertical());
                } catch (MovimientoFueraDelMapa e) {
                    esValidaLaUbicacionDeAtaque = false;
                }
                if (esValidaLaUbicacionDeAtaque) {
                    Ubicable unidadEnemiga = miMapa.GetUbicableEn(posicionAAtacar);
                    esDelJugador = perteneceUnidad(unidadEnemiga);
                    if (esDelJugador == false) {
                        miCastillo.atacarA(unidadEnemiga);
                    }

                }
            }
    }

    public void removerUnidadesMuertas(){
        List<Unidad> unidadesMuertas = new ArrayList<Unidad>();
        for (Unidad unidad : unidadesJugador) {
            if (unidad.getVida() <= 0) {
                unidadesMuertas.add(unidad);
            }
        }
        unidadesJugador.removeAll(unidadesMuertas);
    }

    public void removerEdificiosDestruidos(){
        List<Edificio> edificiosDestruidos = new ArrayList<Edificio>();
        for (Edificio edificio: edificiosJugador){
            if (edificio.getVida() <= 0){
                edificiosDestruidos.add(edificio);
                if (edificio instanceof Castillo){
                    this.perdio = true;
                }
            }
        }
        edificiosJugador.removeAll(edificiosDestruidos);
    }

    public boolean perdio(){
        return this.perdio;
    }
}


