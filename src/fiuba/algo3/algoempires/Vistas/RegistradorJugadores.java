package fiuba.algo3.algoempires.Vistas;

import fiuba.algo3.algoempires.Controladores.EmpezarJuego;
import fiuba.algo3.algoempires.Controladores.InputUsuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class RegistradorJugadores extends VBox {

    public RegistradorJugadores(){
        InputUsuario jugadorUno = new InputUsuario("Primer Jugador");
        InputUsuario jugadorDos = new InputUsuario("Segundo Jugador");

        VBox vb = new VBox(jugadorUno.getHb(), jugadorDos.getHb());
        vb.setPadding(new Insets(100,100,180,100));

        Image inicio = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/inicio.jpeg",500,300,true,true);
        BackgroundImage imagenDeFondo = new BackgroundImage(inicio, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        vb.setBackground(new Background(imagenDeFondo));

        vb.setBackground(new Background(new BackgroundImage(inicio,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));


        this.getChildren().addAll(vb);
    }

    public void pasarEscena(Stage stage, Scene escena){
        EmpezarJuego empezar = new EmpezarJuego(stage, escena);
        Boton boton = new Boton("EMPEZAR", empezar);
        this.getChildren().add(boton);
    }

}
