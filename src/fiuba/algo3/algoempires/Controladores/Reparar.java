package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Reparar implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    public Reparar(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal=vistaPrincipal;
    }

    public void handle(ActionEvent actionEvent){
        vistaPrincipal.nombreAccion="Reparar";
        vistaPrincipal.ofrecerCasilleros(vistaPrincipal.elJuegoEs().getmapa());
    }

}
