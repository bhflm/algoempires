package fiuba.algo3.algoempires;


import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Entidades.PlazaCentral;

public class Juego {
    protected Jugador actual;
    protected Jugador esperando;
    boolean finalizado = false;
    int numeroDeTurno=0;

    protected Mapa mapa;


    public void iniciarJuego(Jugador unJugador, Jugador otroJugador) {
        this.esperando = otroJugador;
        this.actual = unJugador;
    }

    public void comenzarJuego(Jugador unJugador,Jugador otroJugador,int dimensionMapa){
        iniciarJuego(unJugador,otroJugador);
        Mapa miMapa=new Mapa(dimensionMapa,dimensionMapa);
        this.mapa=miMapa;
        this.agregarOroInicial(unJugador,otroJugador);
        this.agregarPlazasCentralesIniciales(unJugador,otroJugador,miMapa,dimensionMapa);
        this.agregarAldeanosIniciales(unJugador,otroJugador,miMapa,dimensionMapa);
        this.agregarCastillosIniciales(unJugador,otroJugador,miMapa,dimensionMapa);
    }

    private void agregarCastillosIniciales(Jugador unJugador, Jugador otroJugador, Mapa miMapa, int dimensionMapa) {
        Posicion posicionCastilloUnJugador=new Posicion((dimensionMapa/2+3),1);
        Castillo castilloUnJugador=new Castillo();
        unJugador.agregarEdificio(castilloUnJugador);
        miMapa.UbicarUnidadEnMapa(posicionCastilloUnJugador,castilloUnJugador);
        Castillo castilloOtroJugador=new Castillo();
        Posicion posicionCastilloOtroJugador=new Posicion((dimensionMapa/2+3),dimensionMapa-3);
        otroJugador.agregarEdificio(castilloOtroJugador);
        miMapa.UbicarUnidadEnMapa(posicionCastilloOtroJugador,castilloOtroJugador);


    }

    private void agregarAldeanosIniciales(Jugador unJugador,Jugador otroJugador ,Mapa miMapa, int dimensionMapa) {
        Posicion posicionAldeano1UnJugador=new Posicion((dimensionMapa/2)-1,1);
        agregarAldeano(unJugador, miMapa, dimensionMapa,posicionAldeano1UnJugador);
        Posicion posicionAldeano2UnJugador=new Posicion((dimensionMapa/2)+2,1);
        agregarAldeano(unJugador, miMapa, dimensionMapa,posicionAldeano2UnJugador);
        Posicion posicionAldeano3UnJugador=new Posicion((dimensionMapa/2),3);
        agregarAldeano(unJugador, miMapa, dimensionMapa,posicionAldeano3UnJugador);
        Posicion posicionAldeano1OtroJugador=new Posicion((dimensionMapa/2)-1,dimensionMapa);
        agregarAldeano(otroJugador, miMapa, dimensionMapa,posicionAldeano1OtroJugador);
        Posicion posicionAldeano2OtroJugador=new Posicion((dimensionMapa/2)+2,dimensionMapa);
        agregarAldeano(otroJugador, miMapa, dimensionMapa,posicionAldeano2OtroJugador);
        Posicion posicionAldeano3OtroJugador=new Posicion((dimensionMapa/2),dimensionMapa-2);
        agregarAldeano(otroJugador, miMapa, dimensionMapa,posicionAldeano3OtroJugador);
    }

    private void agregarAldeano(Jugador unJugador, Mapa miMapa, int dimensionMapa,Posicion posicionAldeano) {
        Aldeano aldeanoUnJugador=new Aldeano();
        unJugador.agregarUnidad(aldeanoUnJugador);
        miMapa.UbicarUnidadEnMapa(posicionAldeano,aldeanoUnJugador);
    }

    private void agregarPlazasCentralesIniciales(Jugador unJugador, Jugador otroJugador, Mapa miMapa,int dimensionMapa) {
        PlazaCentral plazaCentralunJugador=new PlazaCentral();
        Posicion posicionPlazaCentralunJugador=new Posicion((dimensionMapa/2),1);
        unJugador.agregarEdificio(plazaCentralunJugador);
        miMapa.UbicarUnidadEnMapa(posicionPlazaCentralunJugador,plazaCentralunJugador);
        PlazaCentral plazaCentralotroJugador=new PlazaCentral();
        Posicion posicionPlazaCentralOtroJugador=new Posicion((dimensionMapa/2),dimensionMapa-1);
        otroJugador.agregarEdificio(plazaCentralotroJugador);
        miMapa.UbicarUnidadEnMapa(posicionPlazaCentralOtroJugador,plazaCentralotroJugador);
    }

    private void agregarOroInicial(Jugador unJugador, Jugador otroJugador) {
        unJugador.agregarOro(100);
        otroJugador.agregarOro(100);
    }

    public String getNombreActual() {
        return this.actual.getNombre();
    }

    public Jugador getActual() { return this.actual; }

    public void cambiarTurno() {
        if (!finalizoJuego()) {
            this.cambiarJugadorActual();
            this.actual.aldeanosTrabajar();
            this.actual.CastilloRealizaAtaqueMasivo(this.actual.elCastilloDelJugador(),this.mapa);
            this.actual.removerUnidadesMuertas(mapa);
            this.actual.removerEdificiosDestruidos();
            this.numeroDeTurno=this.numeroDeTurno+1;
        }
    }

    public void cambiarJugadorActual(){
        Jugador aux = this.actual;
        this.actual = this.esperando;
        this.esperando = aux;
    }

    public boolean finalizoJuego(){
        return this.actual.perdio();
    }

    public Mapa getmapa() {
        return this.mapa;
    }

    public int numeroDeTurno() {
        return this.numeroDeTurno;
    }
}
