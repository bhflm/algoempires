package fiuba.algo3.algoempires.Controladores;


import fiuba.algo3.algoempires.Entidades.Arquero;
import fiuba.algo3.algoempires.EspacioLibre;
import fiuba.algo3.algoempires.Ubicable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {
    Ubicable miUbicable;
    public Casillero() {
        Ubicable ubicable=new EspacioLibre();
        this.setWidth(30);
        this.setHeight(50);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.RED);
     //   Image img = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/ricky.jpeg");
     //   this.setFill(new ImagePattern(img));
    }
    public void setUbicable(Ubicable ubicable) {
        this.miUbicable = ubicable;
       // AgImagen img = new Img(ubicable.id);
       // img.aplicar(this);
        Image img = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/" + this.miUbicable.getNombre() + ".png");
        this.setFill(new ImagePattern(img));
    }

}
