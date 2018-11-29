package fiuba.algo3.algoempires.Vistas;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Boton extends Button {

    public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
    }

    public void setTexto(String texto){
        setText(texto);
    }
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
}