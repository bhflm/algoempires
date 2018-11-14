package fiuba.algo3.algoempires;

public class Jugador {
    private Boolean jugando;
    private int oro;
    private int poblacion;
    private String nombre;





    Jugador(String nombreJugador) {
        this.oro = 50;
        this.poblacion = 3;
        this.nombre = nombreJugador;
    }


    public void Juega(){
        this.jugando = Boolean.TRUE;
    }

    public void NoJuega(){
        this.jugando = Boolean.FALSE;
    }

    public boolean estaJugando(){
        return this.jugando;
    }


    public void termino(Juego unJuego){
        unJuego.cambiarTurno();
    }


    public void moverUnidad(Unidad unaUnidad, )



}
