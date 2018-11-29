package fiuba.algo3.algoempires.Controladores;


import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class InputUsuario {
    HBox hb;
    TextField tx;
    ColorPicker cp;

    public InputUsuario(String preview) {
        TextField texto = new TextField(preview);
        texto.setPrefColumnCount(30);
        HBox hbox = new HBox(texto);
        hbox.setSpacing(10);
        hb = hbox;
        tx = texto;
    }

    public HBox getHb() {
        return hb;
    }

    public String getNombre() {
        return tx.getText();
    }

}