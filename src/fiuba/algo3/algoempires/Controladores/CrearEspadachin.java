package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearEspadachin implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    public CrearEspadachin(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal=vistaPrincipal;
    }

    public void handle(ActionEvent actionEvent){
        vistaPrincipal.nombreAccion="CrearEspadachin";
        vistaPrincipal.ofrecerCasilleros(vistaPrincipal.elJuegoEs().getmapa());
    }

}
