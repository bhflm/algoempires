package fiuba.algo3.algoempires;


public class Juego {
    protected Jugador actual;
    protected Jugador esperando;

    protected Mapa mapa;


    public void iniciarJuego(Jugador unJugador, Jugador otroJugador) {
        this.esperando = otroJugador;
        this.actual = unJugador;
    }


    public String getNombreActual() {
        return this.actual.getNombre();
    }

    public Jugador getActual() { return this.actual; }

    public void cambiarTurno(){
        Jugador aux = this.actual;
        this.actual = this.esperando;
        this.esperando = aux;
    }


}
