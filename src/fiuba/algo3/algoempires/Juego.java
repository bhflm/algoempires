package fiuba.algo3.algoempires;


public class Juego {
    protected Jugador primero;
    protected Jugador segundo;

    protected Jugador actual;
    protected Jugador esperando;

    protected Mapa mapa;


    public void iniciarJuego(String unJugador, String otroJugador) {
        this.primero = new Jugador(unJugador);
        this.segundo = new Jugador(otroJugador);

        this.esperando = this.segundo;
        this.actual = this.primero;
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