package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RealizarAtaque implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;

    public RealizarAtaque(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal=vistaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        vistaPrincipal.nombreAccion="RealizarAtaque";
        vistaPrincipal.ofrecerCasilleros(vistaPrincipal.elJuegoEs().getmapa());
    }


}
