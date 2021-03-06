package fiuba.algo3.algoempires.Controladores;


import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Juego;
import fiuba.algo3.algoempires.Jugador;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class AccionClickear implements javafx.event.EventHandler<MouseEvent> {

    int dimension;
    ImportadorMapa transformadorCoordernadas;
    VistaPrincipal vistaTableroJuegoActual;
    Casillero casilleroOfrecido;
    GridPane gridpane;


    public AccionClickear(VistaPrincipal vistaPrincipal, GridPane tablero,Casillero casillero,ImportadorMapa importadorMapa,int dimenRow) {
        this.vistaTableroJuegoActual=vistaPrincipal;
        this.casilleroOfrecido=casillero;
        this.gridpane=tablero;
        this.transformadorCoordernadas=importadorMapa;
        this.dimension=dimenRow;
    }

    @Override
    public void handle(MouseEvent actionEvent){
        Casillero ofrecidoPrevio = vistaTableroJuegoActual.getCasilleroOfrecido();
        if(ofrecidoPrevio != null){
            ofrecidoPrevio.desSeleccionarCasillero(vistaTableroJuegoActual);
        }
        casilleroOfrecido.seleccionarCasilleroOfrecido(vistaTableroJuegoActual);
        casilleroOfrecido.confirmarCasillero(this.vistaTableroJuegoActual);
    }

}
