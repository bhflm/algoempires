package fiuba.algo3.algoempires.Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpezarJuego implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public EmpezarJuego(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);

    }

}
