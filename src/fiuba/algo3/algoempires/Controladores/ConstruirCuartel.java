package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;

import javax.swing.*;

public class ConstruirCuartel implements javafx.event.EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;

    public ConstruirCuartel(VistaPrincipal vista){
        this.vistaPrincipal=vista;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        vistaPrincipal.ofrecerCasilleros(vistaPrincipal.getElMapa());

    }


}