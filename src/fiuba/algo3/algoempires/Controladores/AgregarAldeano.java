package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Entidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.algoempires.Jugador;

public class AgregarAldeano implements EventHandler<ActionEvent> {

    Jugador unJugador;
    Aldeano unAldeano;

    @Override
    public void handle(ActionEvent actionEvent) {
        unAldeano = new Aldeano();
        unJugador.agregarUnidad(unAldeano);
    }



}
