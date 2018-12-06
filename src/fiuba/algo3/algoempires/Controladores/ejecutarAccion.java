package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Atacante;
import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import fiuba.algo3.algoempires.Juego;
import fiuba.algo3.algoempires.Jugador;
import fiuba.algo3.algoempires.Ubicable;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ejecutarAccion implements EventHandler<ActionEvent> {
    int dimension;
    ImportadorMapa transformadorCoordernadas;
    VistaPrincipal vistaTableroJuegoActual;
    Casillero casilleroOfrecido;
    GridPane gridpane;

    public ejecutarAccion(VistaPrincipal vistaPrincipal, GridPane tablero) {
        this.vistaTableroJuegoActual = vistaPrincipal;
        this.casilleroOfrecido = vistaPrincipal.getCasilleroOfrecido();
        this.gridpane = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego elJuego = vistaTableroJuegoActual.elJuegoEs();
        Jugador jugador = elJuego.getActual();
        boolean elMovimientoEsValido=true;

        if (vistaTableroJuegoActual.nombreAccion.equals("ConstruirCuartel")) {
            jugador.construirCuartel(elJuego, elJuego.getmapa(), (Aldeano) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getPosicion());

        }
        else if (vistaTableroJuegoActual.nombreAccion.equals("ConstruirPlazaCentral")) {
            jugador.construirPlazaCentral(elJuego, elJuego.getmapa(), (Aldeano) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getPosicion());
        }

        else if(vistaTableroJuegoActual.nombreAccion.equals("RealizarAtaque")){

            try{
                elJuego.getActual().realizarAtaque( (Atacante) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getUbicable());
            }
            catch (JugadaInvalidaException e){
                elMovimientoEsValido=false;
                }

            }
        if(elMovimientoEsValido){
        vistaTableroJuegoActual.cambiarJugadorEnTurno(elJuego);
        vistaTableroJuegoActual.actualizarTableroV2(elJuego.getmapa());
        vistaTableroJuegoActual.borrarSetAcciones();
        vistaTableroJuegoActual.setAcciones();
    }}
}