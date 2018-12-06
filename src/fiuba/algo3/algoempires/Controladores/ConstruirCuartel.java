package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Juego;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;

import javax.swing.*;

public class ConstruirCuartel implements javafx.event.EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;
    Casillero ofrecido;

    public ConstruirCuartel(VistaPrincipal vista){
        this.vistaPrincipal=vista;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego elJuego=vistaPrincipal.elJuegoEs();

        vistaPrincipal.ofrecerCasilleros(vistaPrincipal.getElMapa());

    }


}