package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Entidades.PlazaCentral;
import fiuba.algo3.algoempires.Excepciones.OroInsuficienteError;
import fiuba.algo3.algoempires.Juego;
import fiuba.algo3.algoempires.Jugador;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearArmaDeAsedio implements EventHandler<ActionEvent> {
    VistaPrincipal vistaTableroJuegoActual;

    public CrearArmaDeAsedio(VistaPrincipal vistaPrincipal) {
        this.vistaTableroJuegoActual=vistaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        boolean elMovimientoEsValido = true;
        Juego elJuego=vistaTableroJuegoActual.elJuegoEs();
        Jugador jugador=elJuego.getActual();
        try {
            jugador.crearArmaDeAsedio(elJuego, (Castillo) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), elJuego.getmapa());
        }
        catch(OroInsuficienteError e){elMovimientoEsValido=false;}
        if(elMovimientoEsValido) {
            vistaTableroJuegoActual.actualizarTableroV2(elJuego.getmapa());
        }
        vistaTableroJuegoActual.borrarSetAcciones();
        vistaTableroJuegoActual.setAcciones();
    }
}
