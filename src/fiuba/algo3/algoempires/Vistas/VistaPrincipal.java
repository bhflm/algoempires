package fiuba.algo3.algoempires.Vistas;

import fiuba.algo3.algoempires.Controladores.AgregarAldeano;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaPrincipal extends BorderPane {

    public VistaPrincipal(){
        this.setFondo();
        this.setAcciones();
    }

    public void setFondo() {
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


    public void setAcciones() {
        Boton agregarAldeano = new Boton("Crear Aldeano", new AgregarAldeano());

        VBox vb = new VBox();

        vb.getChildren().addAll(agregarAldeano);
        this.setRight(vb);
    }

}