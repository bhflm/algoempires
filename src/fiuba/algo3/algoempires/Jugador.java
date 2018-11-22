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

    public boolean perteneceUnidad(Ubicable unUbicable){
        boolean seEncuentra=false;
        if(this.unidadesJugador.contains(unUbicable) || this.edificiosJugador.contains(unUbicable))
            seEncuentra=true;
        return seEncuentra;
    }


    public void agregarEdificio(Edificio unEdificio){this.edificiosJugador.add(unEdificio);}

    public void moverUnidad(Juego unJuego, Mapa unMapa,Movible unaUnidad, Direccion unaDireccion){
        Posicion posicionMover = unaDireccion.ObtenerPosicion(unaUnidad);
        unMapa.MoverUnidad(posicionMover,unaUnidad);
        if (unJuego.getNombreActual() != this.nombre ){
            throw new JugadaInvalidaException();
        }
        unJuego.cambiarTurno();
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


    public void CastilloRealizaAtaqueMasivo(Castillo miCastillo,Mapa miMapa){
        Posicion posicionCastillo=miCastillo.getPosicion();
        boolean esDelJugador=false;
        boolean esValidaLaUbicacionDeAtaque=false;
        for (int i=-3;i<(3+miCastillo.dimension);i++)
            for (int j=-3;j<(3+miCastillo.dimension);j++){
                Posicion posicionAAtacar=posicionCastillo.PosicionCorridaA(i,j);
                if(esValidaLaUbicacionDeAtaque=posicionAAtacar.ValidarPosicion(miMapa.getLargoHorizontal(),miMapa.getLargoVertical())){
                    Ubicable unidadEnemiga=miMapa.GetUbicableEn(posicionAAtacar);
                    esDelJugador=perteneceUnidad(unidadEnemiga);
                    if(esDelJugador==false)
                        miCastillo.atacarA(unidadEnemiga);
            }}
    }



}
