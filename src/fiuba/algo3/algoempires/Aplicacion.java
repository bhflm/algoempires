package fiuba.algo3.algoempires;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class Aplicacion extends Application {

    Stage ventana;
    Scene scene1, scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ventana = primaryStage;
        ventana.setTitle("AlgoEmpires");
        Label label1 = new Label("Welcome to algoempires");

        Button button1 = new Button("EMPEZAR"); // Va al mapa principal.
        button1.setOnAction( e -> ventana.setScene(scene2));

        //Layout 1 -
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Layout 2 -
        BorderPane layout2 = new BorderPane();
        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/mapa.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout2.setBackground(new Background(imagenDeFondo));



        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        layout2.setBackground(new Background(new BackgroundImage(imagenMapa,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
        layout2.getChildren().addAll(label1);

        scene2 = new Scene(layout2,600,400);

        ventana.setScene(scene1);
        ventana.show();
    }


}
