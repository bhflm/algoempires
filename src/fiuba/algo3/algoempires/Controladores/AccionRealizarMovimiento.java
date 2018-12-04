package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;

import javax.swing.*;

public class AccionRealizarMovimiento implements javafx.event.EventHandler<ActionEvent> {
    VistaPrincipal vistaPrincipal;

    public AccionRealizarMovimiento(VistaPrincipal vista){
        this.vistaPrincipal=vista;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.vistaPrincipal.borrarSetAcciones();
        this.vistaPrincipal.mostrarMenuDirecciones();
    }


}
