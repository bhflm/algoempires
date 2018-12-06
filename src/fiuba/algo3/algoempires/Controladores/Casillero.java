package fiuba.algo3.algoempires.Controladores;


import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {
    Ubicable miUbicable;
    Posicion miPosicion;

    public Casillero() {
        Ubicable ubicable=new EspacioLibre();
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.RED);
    }

    public void printNombre(){
        System.out.println("Daaaaaaa");
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

    public void seleccionarCasillero(VistaPrincipal vista) {
        vista.asignarCasilleroActual(this);
        this.setStroke(Color.BLACK);
    }

    public void seleccionarCasilleroOfrecido(VistaPrincipal vista) {
        vista.asignarCasilleroOfrecido(this);
        this.setStroke(Color.YELLOWGREEN);
    }

    public void desSeleccionarCasillero(VistaPrincipal vista) {
        this.setStroke(Color.RED);
    }

    public void mostrarPosiblesAcciones(VistaPrincipal vistaPrincipal) {
        vistaPrincipal.desactivarBotones();
        Ubicable elUbicableDelCasillero = this.miUbicable;
        Jugador JugadorActual=vistaPrincipal.elJugadorActualEs();
        if(JugadorActual.perteneceUnidad(elUbicableDelCasillero)) {
            if (elUbicableDelCasillero instanceof Movible){
                vistaPrincipal.activarBotonMoverse();
                vistaPrincipal.asignarMovible(elUbicableDelCasillero);
            }
            if (elUbicableDelCasillero instanceof Atacante)
                vistaPrincipal.activarBotonAtacar();
            if (elUbicableDelCasillero instanceof Aldeano) {
                vistaPrincipal.activarBotonReparar();
                vistaPrincipal.activarBotonConstruirCuartel();
                vistaPrincipal.activarBotonConstruirPC();
            }
            if (elUbicableDelCasillero instanceof PlazaCentral)
                vistaPrincipal.activarBotonCrearAldeano();
            if (elUbicableDelCasillero instanceof Castillo) {
                vistaPrincipal.activarBotonCrearArmaDeAsedio();
                vistaPrincipal.desactivarBotonAtacar();
            }
            if (elUbicableDelCasillero instanceof Cuartel) {
                vistaPrincipal.activarBotonCrearEspadachin();
                vistaPrincipal.activarBotonCrearArquero();
            }
        }
    }

    public Ubicable ObtenerUbicable() {
        return this.miUbicable;
    }

    public Ubicable getUbicable() {
    return this.miUbicable;    }
}




