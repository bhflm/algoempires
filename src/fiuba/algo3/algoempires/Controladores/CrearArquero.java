package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Entidades.Cuartel;
import fiuba.algo3.algoempires.Entidades.PlazaCentral;
import fiuba.algo3.algoempires.Juego;
import fiuba.algo3.algoempires.Jugador;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearArquero implements EventHandler<ActionEvent> {
    VistaPrincipal vistaTableroJuegoActual;

    public CrearArquero(VistaPrincipal vistaPrincipal) {
        this.vistaTableroJuegoActual=vistaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego elJuego=vistaTableroJuegoActual.elJuegoEs();
        Jugador jugador=elJuego.getActual();
        jugador.crearArquero(elJuego, (Cuartel) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), elJuego.getmapa());
        vistaTableroJuegoActual.actualizarTableroV2(elJuego.getmapa());
        vistaTableroJuegoActual.borrarSetAcciones();
        vistaTableroJuegoActual.setAcciones();
    }
}
