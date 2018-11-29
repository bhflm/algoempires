package fiuba.algo3.algoempires.Vistas;

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

    public VistaPrincipal(){
        this.crearTablero();
        this.setFondo();
        this.setAcciones();
    }

    public void setFondo() {
        this.setMinSize(500, 340);

        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/mapa.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.setBackground(new Background(new BackgroundImage(imagenMapa,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }

    public void crearTablero() {
        GridPane gridPane = new GridPane();
        this.setCenter(gridPane);

        int counter = 0;
        for (int row = 3; row > 0; row--)
            for (int col = 0; col < 3; col++) {
                Casillero a = new Casillero();
                a.setStyle("-fx-background-image: url('file:src/fiuba/algo3/algoempires/Vistas/Img/arquero.png')");
                gridPane.add(a, col, row);
                GridPane.setHgrow(a, Priority.ALWAYS);
                GridPane.setVgrow(a, Priority.ALWAYS);
            }
    }


    public void setAcciones() {
        Boton agregarAldeano = new Boton("Crear Aldeano", new AgregarAldeano());

        VBox vb = new VBox();

        vb.getChildren().addAll(agregarAldeano);
        this.setRight(vb);
    }

}
