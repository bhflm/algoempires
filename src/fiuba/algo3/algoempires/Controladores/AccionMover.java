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
        ImportadorMapa importadorMapa = new ImportadorMapa();
        Mapa elMapaParaLaPantalla = importadorMapa.GenerarMapa(elJuego.getmapa());
        vistaPrincipal.actualizarTablero(elMapaParaLaPantalla);
        vistaPrincipal.borrarSetAcciones();
        vistaPrincipal.setAcciones();
        vistaPrincipal.cambiarJugadorEnTurno(elJuego);

}



}
