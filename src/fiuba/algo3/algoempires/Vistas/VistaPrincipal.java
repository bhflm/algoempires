package fiuba.algo3.algoempires.Vistas;

import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Mapa;
import fiuba.algo3.algoempires.Posicion;
import fiuba.algo3.algoempires.Ubicable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import fiuba.algo3.algoempires.Controladores.AgregarAldeano;
import fiuba.algo3.algoempires.Controladores.Casillero;
import fiuba.algo3.algoempires.Controladores.NodoLibre;
import fiuba.algo3.algoempires.EspacioLibre;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class VistaPrincipal extends BorderPane {

    public VistaPrincipal(Mapa miMapa){
        this.crearTablero(miMapa);
        this.setFondo();
        this.setAcciones();
    }

    public void setFondo() {
        this.setMinSize(500, 340);

        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/mapa.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

       // BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
       // this.setBackground(new Background(new BackgroundImage(imagenMapa,
       //         BackgroundRepeat.NO_REPEAT,
       //         BackgroundRepeat.NO_REPEAT,
       //         BackgroundPosition.CENTER,
       //         bSize)));
    }

    public void crearTablero(Mapa miMapa) {
        GridPane gridPane = new GridPane();
        gridPane.setMaxWidth(30);
        gridPane.setMaxHeight(40);
        this.setCenter(gridPane);
        gridPane.heightProperty();
        gridPane.setGridLinesVisible(true);
        int dimenRow=miMapa.getLargoHorizontal();
        int dimenCol=miMapa.getLargoVertical();
        for (int row = 0; row < dimenRow; row++)
            for (int col = 0; col <dimenCol; col++){
                Posicion posicionUbicable=new Posicion(row+1,col+1);
                Ubicable elUbicable=miMapa.GetUbicableEn(posicionUbicable);
                Casillero a=new Casillero(elUbicable,posicionUbicable);
                gridPane.add(a,row, col);
                gridPane.setHgrow(a, Priority.ALWAYS);
                gridPane.setVgrow(a, Priority.ALWAYS);
            }
    }

    private void setAcciones() {

        Boton botonMoverse = new Boton("Moverse A", null);
        Boton botonAtacar = new Boton("Atacar", null);
        Boton botonConstruirCuartel = new Boton("Construir Cuartel", null);
        Boton botonConstruirPC = new Boton("Construir Plaza Central", null);
        Boton botonReparar = new Boton("Reparar", null);

        Boton botonCrearAldeano = new Boton("Crear Aldeano", null);
        Boton botonCrearArquero = new Boton("Crear Arquero", null);
        Boton botonCrearEspadachin = new Boton("Crear Espadachin", null);
        Boton botonCrearArmaDeAsedio = new Boton("Crear Arma De Asedio", null);


        Pane separador = new Pane();
        separador.setPrefHeight(80);

        VBox contenedorVertical = new VBox(botonMoverse, botonAtacar, botonConstruirCuartel, botonConstruirPC, botonReparar, separador, botonCrearAldeano, botonCrearArquero, botonCrearEspadachin, botonCrearArmaDeAsedio);
        contenedorVertical.setPrefWidth(200);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setStyle("-fx-background-color: #8B4513;");
        contenedorVertical.setPadding(new Insets(20,20,20,20));
        this.setRight(contenedorVertical);
    }

}
