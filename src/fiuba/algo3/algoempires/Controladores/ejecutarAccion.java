package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.AtaqueFueraDeRango;
import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import fiuba.algo3.algoempires.Excepciones.OroInsuficienteError;
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
            try {
                jugador.construirCuartel(elJuego, elJuego.getmapa(), (Aldeano) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getPosicion());
            }
            catch(OroInsuficienteError e){elMovimientoEsValido=false;}
        }
        else if (vistaTableroJuegoActual.nombreAccion.equals("ConstruirPlazaCentral")) {
            try {
                jugador.construirPlazaCentral(elJuego, elJuego.getmapa(), (Aldeano) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getPosicion());
            }
            catch(OroInsuficienteError e){elMovimientoEsValido=false;}
            }

        else if(vistaTableroJuegoActual.nombreAccion.equals("RealizarAtaque")){

            try{
                elJuego.getActual().realizarAtaque(elJuego, (Atacante) vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(), vistaTableroJuegoActual.getCasilleroOfrecido().getUbicable());
            }
            catch (JugadaInvalidaException | AtaqueFueraDeRango e){
                elMovimientoEsValido=false;
                }

            }
        else if(vistaTableroJuegoActual.nombreAccion.equals("Reparar")) {
            jugador.reparar(elJuego,elJuego.getmapa(),(Aldeano)vistaTableroJuegoActual.getCasilleroSeleccionado().getUbicable(),(Edificio) vistaTableroJuegoActual.getCasilleroOfrecido().getUbicable());
        }


            if(elMovimientoEsValido){
        vistaTableroJuegoActual.actualizarTableroV2(elJuego.getmapa());
        vistaTableroJuegoActual.borrarSetAcciones();
        vistaTableroJuegoActual.setAcciones();
    }}
}