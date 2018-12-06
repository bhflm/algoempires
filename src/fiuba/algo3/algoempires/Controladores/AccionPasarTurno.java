package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Excepciones.MovimientoFueraDelMapa;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionPasarTurno implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    public AccionPasarTurno(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal=vistaPrincipal;
        }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego elJuego=this.vistaPrincipal.elJuegoEs();
        elJuego.cambiarTurno();
        vistaPrincipal.actualizarTableroV2(elJuego.getmapa());
        vistaPrincipal.borrarSetAcciones();
        vistaPrincipal.setAcciones();
    }

}
