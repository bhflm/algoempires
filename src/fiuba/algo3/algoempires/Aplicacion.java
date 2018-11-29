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


        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        int dimensionMapa=15;
        unJuego.comenzarJuego(unJugador,otroJugador,dimensionMapa);
        ImportadorMapa importadorMapa=new ImportadorMapa();
        Mapa elMapa =importadorMapa.GenerarMapa(unJuego.mapa);

        ventana = primaryStage;
        ventana.setTitle("AlgoEmpires");

        RegistradorJugadores registrador = new RegistradorJugadores();
        VistaPrincipal vistaPrincipal = new VistaPrincipal(elMapa);

        Scene inicioJuego = new Scene(registrador);
        Scene algoEmpires = new Scene(vistaPrincipal);

        registrador.pasarEscena(ventana,algoEmpires);

        ventana.setScene(inicioJuego);
        ventana.show();
    }
}
