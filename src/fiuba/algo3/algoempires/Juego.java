package fiuba.algo3.algoempires;


public class Juego {
    protected Jugador primero;
    protected Jugador segundo;

    protected Jugador actual;

    protected Mapa mapa;


    public iniciarJuego() {
        this.primero = new Jugador('A');
        this.segundo = new Jugador('B');

        this.actual = this.primero;
    }

    public cambiarTurno() {
        Jugador aux = this.actual;
        this.actual = this.segundo;
        aux.NoJuega();
        this.actual.Juega();
    }



}
