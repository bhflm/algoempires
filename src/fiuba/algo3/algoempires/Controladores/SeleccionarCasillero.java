package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.EspacioLibre;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SeleccionarCasillero implements EventHandler<Event> {
    int dimension;
    ImportadorMapa transformadorCoordernadas;
    VistaPrincipal vistaTableroJuegoActual;
    Casillero casilleroASeleccionar;
    GridPane gridpane;

    public SeleccionarCasillero(VistaPrincipal vistaPrincipal, GridPane tablero,Casillero casillero,ImportadorMapa importadorMapa,int dimenRow) {
        this.vistaTableroJuegoActual=vistaPrincipal;
        this.casilleroASeleccionar=casillero;
        this.gridpane=tablero;
        this.transformadorCoordernadas=importadorMapa;
        this.dimension=dimenRow;
    }

    @Override
    public void handle(Event actionEvent) {
        Casillero casilleroMarcadoPreviamente=vistaTableroJuegoActual.getCasilleroSeleccionado();
        if(casilleroMarcadoPreviamente!=null){
             casilleroMarcadoPreviamente.desSeleccionarCasillero(vistaTableroJuegoActual);
        }
        casilleroASeleccionar.seleccionarCasillero(vistaTableroJuegoActual);
        vistaTableroJuegoActual.mostrarInformacionCasillero(casilleroASeleccionar);
        casilleroASeleccionar.mostrarPosiblesAcciones(this.vistaTableroJuegoActual);
   }
}
