package fiuba.algo3.algoempires.Controladores;


import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class AccionClickear implements javafx.event.EventHandler<MouseEvent> {

    public AccionClickear() {
    }

    @Override
    public void handle(MouseEvent actionEvent){
        System.out.println("DISPARO EVENTO MOUSE");

    }
}
