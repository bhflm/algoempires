package fiuba.algo3.algoempires.Controladores;

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
             gridpane.getChildren().remove(casilleroMarcadoPreviamente);
             casilleroMarcadoPreviamente.desSeleccionarCasillero(vistaTableroJuegoActual);
             Posicion posicionPrevia=casilleroMarcadoPreviamente.miPosicion;
             int viejaY=this.transformadorCoordernadas.obtenerCoordenadaFila(posicionPrevia,this.dimension);
             int viejaX=this.transformadorCoordernadas.obtenerCoordenadaColumna(posicionPrevia);
             gridpane.add(casilleroMarcadoPreviamente,viejaX,viejaY);
        }
        gridpane.getChildren().remove(casilleroASeleccionar);
        casilleroASeleccionar.seleccionarCasillero(vistaTableroJuegoActual);
        Posicion posicionActual=casilleroASeleccionar.miPosicion;
        int nuevaY=this.transformadorCoordernadas.obtenerCoordenadaFila(posicionActual,this.dimension);
        int nuevaX=this.transformadorCoordernadas.obtenerCoordenadaColumna(posicionActual);
        gridpane.add(casilleroASeleccionar,nuevaX,nuevaY);
        casilleroASeleccionar.mostrarPosiblesAcciones(this.vistaTableroJuegoActual);
   }
}
