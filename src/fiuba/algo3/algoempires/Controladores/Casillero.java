package fiuba.algo3.algoempires.Controladores;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {
    public Casillero() {
        this.setX(50);
        this.setY(50);
        this.setWidth(20);
        this.setHeight(20);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.RED);
    }
}
