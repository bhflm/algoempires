package fiuba.algo3.algoempires.Controladores;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class EmpezarJuego {

    private String nombreUno;
    private String nombreDos;

    public EmpezarJuego() {
        Stage window = new Stage();

        window.setMinWidth(250);
        Label label = new Label();
        label.setText("Empezar Juego");


        TextField jugadorUnoInput = new TextField("Jugador Uno");
        TextField jugadorDosInput = new TextField("Jugador Dos");


        Button empezarJuego = new Button("Empezar");
        empezarJuego.setOnAction(e -> {
            parsearJugadores(jugadorUnoInput,jugadorDosInput);
            window.close();
        });

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(jugadorUnoInput,jugadorDosInput, empezarJuego);

        Scene pantalla = new Scene(layout, 300,250);


        window.setScene(pantalla);
        window.showAndWait();
    }

    private void parsearJugadores(TextField uno, TextField dos){
        nombreUno = uno.getText();
        nombreDos = dos.getText();
    }

    private String getNombreUno(){
        return this.nombreUno;
    }


    private String getNombreDos(){
        return this.nombreDos;
    }


}