package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SeleccionarCasillero implements EventHandler<Event> {
    VistaPrincipal vistaTableroJuegoActual;
    Casillero casilleroASeleccionar;
    GridPane gridpane;

    public SeleccionarCasillero(VistaPrincipal vistaPrincipal, GridPane tablero,Casillero casillero) {
        this.vistaTableroJuegoActual=vistaPrincipal;
        this.casilleroASeleccionar=casillero;
        this.gridpane=tablero;
    }

    @Override
    public void handle(Event actionEvent) {
        casilleroASeleccionar.seleccionarCasillero();
        vistaTableroJuegoActual.getChildren().remove(gridpane);
        Posicion pos=casilleroASeleccionar.miPosicion;
        //gridpane.add(casilleroASeleccionar,pos.getCoordenadaHorizontal(),pos.getCoordenadaVertical());

    }
}
