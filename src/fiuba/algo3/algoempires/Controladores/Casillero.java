package fiuba.algo3.algoempires.Controladores;


import fiuba.algo3.algoempires.Entidades.Arquero;
import fiuba.algo3.algoempires.EspacioLibre;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Ubicable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {
    Ubicable miUbicable;
    Posicion miPosicion;

    public Casillero() {
        Ubicable ubicable=new EspacioLibre();
        //this.setWidth(20);
        //this.setHeight(20);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.BLACK);
    }
    public void setUbicable(Ubicable ubicable) {
        this.miUbicable = ubicable;
        Image img = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/" + this.miUbicable.getNombre() + ".png");
        this.setFill(new ImagePattern(img));
    }
    public Casillero(Ubicable unUbicable,Posicion posicionDelUbicable){
        this.setWidth(30);
        this.setHeight(40);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.RED);
        this.setUbicable(unUbicable);
        this.miPosicion=posicionDelUbicable;
    }

    public int ObtenerCoorderanadaHorizontal(){
        return this.miPosicion.getCoordenadaHorizontal();
    }
    public int ObtenerCoordenadaVertical(){
        return this.miPosicion.getCoordenadaVertical();}
}
