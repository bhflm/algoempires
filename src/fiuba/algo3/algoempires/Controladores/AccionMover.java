package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Direcciones.Direccion;
import fiuba.algo3.algoempires.Direcciones.DireccionSuperiorVertical;
import fiuba.algo3.algoempires.Excepciones.MovimientoFueraDelMapa;
import fiuba.algo3.algoempires.Excepciones.UbicacionOcupadaPorOtraUnidad;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionMover implements EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    Direccion direccion;

    public AccionMover(VistaPrincipal vista, Direccion direccionMovimiento) {
        this.vistaPrincipal = vista;
        this.direccion = direccionMovimiento;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorMoviendo = vistaPrincipal.elJugadorActualEs();
        boolean elMovimientoEsValido = true;
        Juego elJuego = vistaPrincipal.elJuegoEs();
        Mapa unMapa = elJuego.getmapa();
        Movible elUbicable = vistaPrincipal.elMovible();
        Posicion posicionAnterior = elUbicable.getPosicion();
        try {
            jugadorMoviendo.moverUnidad(elJuego, unMapa, elUbicable, this.direccion);
        } catch (MovimientoFueraDelMapa | UbicacionOcupadaPorOtraUnidad e) {
            elMovimientoEsValido = false;
        }
        if (elMovimientoEsValido) {
            Posicion posicionNueva = elUbicable.getPosicion();
            // vistaPrincipal.actualizarTableroPorMovimiento(posicionAnterior, posicionNueva);
            vistaPrincipal.actualizarTableroV2(elJuego.getmapa()); /*Este actualiza todo el tablero es mas lento*/
              }
              vistaPrincipal.borrarSetAcciones();
            vistaPrincipal.setAcciones();



         }
}