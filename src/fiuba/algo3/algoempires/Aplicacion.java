package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Controladores.ImportadorMapa;
import fiuba.algo3.algoempires.Vistas.RegistradorJugadores;
import fiuba.algo3.algoempires.Vistas.VistaPrincipal;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Aplicacion extends Application {

    Stage ventana;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {




        ventana = primaryStage;
        ventana.setTitle("AlgoEmpires");

        RegistradorJugadores registrador = new RegistradorJugadores(ventana);
        Scene inicioJuego = new Scene(registrador);

        ventana.setScene(inicioJuego);
        ventana.show();
    }
}
