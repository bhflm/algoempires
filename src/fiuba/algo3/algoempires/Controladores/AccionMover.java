package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Direcciones.Direccion;
import fiuba.algo3.algoempires.Direcciones.DireccionSuperiorVertical;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMover implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    Direccion direccion;
    public AccionMover(VistaPrincipal vista,Direccion direccionMovimiento ) {
        this.vistaPrincipal=vista;
        this.direccion=direccionMovimiento;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Jugador jugadorMoviendo=vistaPrincipal.elJugadorActualEs();
        Juego elJuego=vistaPrincipal.elJuegoEs();
        Mapa unMapa=elJuego.getmapa();
        Movible elUbicable =vistaPrincipal.elMovible();
        jugadorMoviendo.moverUnidad(elJuego, unMapa,elUbicable,this.direccion);
        Posicion posicionAMover = this.direccion.ObtenerPosicion(elUbicable);
        Posicion posicionActual =elUbicable.getPosicion();
        vistaPrincipal.actualizarTablero(posicionActual,posicionAMover);
        vistaPrincipal.borrarSetAcciones();
        vistaPrincipal.setAcciones();
        vistaPrincipal.cambiarJugadorEnTurno(elJuego);

}



}
