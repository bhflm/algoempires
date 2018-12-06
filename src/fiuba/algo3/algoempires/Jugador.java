package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Direcciones.Direccion;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.*;

import java.util.*;

public class Jugador {

    private Boolean jugando;
    private int oro;
    private int poblacion;
    private String nombre;
    private Set<Unidad> unidadesJugador = new HashSet<Unidad>();
    private Set<Edificio> edificiosJugador = new HashSet<Edificio>();
    private boolean perdio = false;

    public Jugador(String nombreJugador) {
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
        try{unMapa.MoverUnidad(posicionMover,unaUnidad);}
        catch(UbicacionOcupadaPorOtraUnidad e) {
            throw new UbicacionOcupadaPorOtraUnidad();
        }
        catch(MovimientoFueraDelMapa e){
            throw new MovimientoFueraDelMapa();
        }
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

    public void realizarAtaque(Atacante MiAtacante, Ubicable MiObjetivo){
        boolean EstaUnidadEsMia=this.perteneceUnidad(MiObjetivo);
        if(!EstaUnidadEsMia)
            MiAtacante.atacarA(MiObjetivo);
        else throw new JugadaInvalidaException();
    }

    public void construirCuartel(Juego unJuego, Mapa unMapa, Aldeano unAldeano, Posicion unaPosicion){
        if (this.oro < 50){
            throw new OroInsuficienteError();
        }
        Cuartel unCuartel = unAldeano.construirCuartel(unMapa, unaPosicion);
        this.edificiosJugador.add(unCuartel);
        this.oro -= 50;
        unJuego.cambiarTurno();
    }

    public void construirPlazaCentral(Juego unJuego, Mapa unMapa, Aldeano unAldeano, Posicion unaPosicion){
        if (this.oro < 100){
            throw new OroInsuficienteError();
        }
        PlazaCentral unaPlazaCentral = unAldeano.construirPlazaCentral(unMapa, unaPosicion);
        this.edificiosJugador.add(unaPlazaCentral);
        this.oro-=100;
        unJuego.cambiarTurno();
    }

    public void crearAldeano(Juego unJuego, PlazaCentral unaPlazaCentral, Mapa mapa, Posicion unaPosicion){
        if (this.oro < 25){
            throw new OroInsuficienteError();
        }
        Aldeano unAldeano = unaPlazaCentral.crearAldeano(mapa, unaPosicion);
        this.agregarUnidad(unAldeano);
        this.oro -= 25;
        unJuego.cambiarTurno();
    }

    public void crearArquero(Juego unJuego, Cuartel unCuartel, Mapa mapa, Posicion unaPosicion){
        if (this.oro < 75){
            throw new OroInsuficienteError();
        }
        Arquero unArquero = unCuartel.crearArquero(mapa, unaPosicion);
        this.agregarUnidad(unArquero);
        this.oro -= 75;
        unJuego.cambiarTurno();
    }

    public void crearEspadachin(Juego unJuego, Cuartel unCuartel, Mapa mapa, Posicion unaPosicion){
        if (this.oro < 50){
            throw new OroInsuficienteError();
        }
        Espadachin unEspadachin = unCuartel.crearEspadachin(mapa, unaPosicion);
        this.agregarUnidad(unEspadachin);
        this.oro -= 50;
        unJuego.cambiarTurno();
    }

    public void crearArmaDeAsedio(Juego unJuego, Castillo unCastillo, Mapa mapa, Posicion unaPosicion){
        if (this.oro < 200){
            throw new OroInsuficienteError();
        }
        ArmaDeAsedio unArmaDeAsedio = unCastillo.crearArmaDeAsedio(mapa, unaPosicion);
        this.agregarUnidad(unArmaDeAsedio);
        this.oro -= 200;
        unJuego.cambiarTurno();
    }

    public void reparar(Juego unJuego, Mapa unMapa, Aldeano unAldeano, Edificio unEdificio){
        boolean EsteEdificioEsMio=this.perteneceUnidad(unEdificio);
        if(EsteEdificioEsMio){unAldeano.reparar(unEdificio);}
        else throw new JugadaInvalidaException();
        unJuego.cambiarTurno();
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

        public void recaudarOro() {
            for (Unidad unidad : unidadesJugador) {
                this.oro=this.oro+unidad.recaudarOro();
            }

    }
}


