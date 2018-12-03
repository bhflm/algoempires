package fiuba.algo3.algoempires.Controladores;

import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpezarJuego implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    VistaPrincipal vistap;

    public EmpezarJuego(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);

    }

}
