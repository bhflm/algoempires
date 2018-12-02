package fiuba.algo3.algoempires.Vistas;


import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Controladores.EmpezarJuego;
import fiuba.algo3.algoempires.Controladores.ImportadorMapa;
import fiuba.algo3.algoempires.Controladores.SeleccionarCasillero;
import javafx.geometry.Insets;
import fiuba.algo3.algoempires.Controladores.Casillero;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaPrincipal extends BorderPane {
    Casillero casilleroSeleccionado;
    Jugador unJugador;
    Jugador otroJugador;
    Juego juegoAlgoEmpires;
    Boton botonMoverse;
    Boton botonAtacar;
    Boton botonConstruirCuartel;
    Boton botonConstruirPC;
    Boton botonReparar;
    Boton botonCrearAldeano;
    Boton botonCrearArquero;
    Boton botonCrearEspadachin;
    Boton botonCrearArmaDeAsedio;
    GridPane gridPane;

    public VistaPrincipal() {
        this.casilleroSeleccionado = null;
        this.juegoAlgoEmpires = new Juego();
        this.unJugador = new Jugador("Foo");
        this.otroJugador = new Jugador("Bar");
        int dimensionMapa = 15;
        this.juegoAlgoEmpires.comenzarJuego(unJugador, otroJugador, dimensionMapa);
        ImportadorMapa importadorMapa = new ImportadorMapa();
        Mapa elMapa = importadorMapa.GenerarMapa(this.juegoAlgoEmpires.getmapa());
        this.crearTablero(elMapa);
        this.setFondo();
        this.setAcciones();

    }

    public void setFondo() {
        this.setMinSize(500, 340);

        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vistas/Img/mapa.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public void crearTablero(Mapa miMapa) {
        this.gridPane = new GridPane();
        gridPane.setMaxWidth(30);
        gridPane.setMaxHeight(40);
        this.setCenter(gridPane);
        gridPane.setGridLinesVisible(true);
        int dimenRow = miMapa.getLargoHorizontal();
        int dimenCol = miMapa.getLargoVertical();
        for (int row = 0; row < dimenRow; row++)
            for (int col = 0; col < dimenCol; col++) {
                Posicion posicionUbicable = new Posicion(row + 1, col + 1);
                Ubicable elUbicable = miMapa.GetUbicableEn(posicionUbicable);
                Casillero casillero = new Casillero(elUbicable, posicionUbicable);
                casillero.setOnMouseClicked(new SeleccionarCasillero(this, gridPane, casillero));
                gridPane.add(casillero, row, col);
                gridPane.setHgrow(casillero, Priority.ALWAYS);
                gridPane.setVgrow(casillero, Priority.ALWAYS);
            }


    }


    private void setAcciones() {

        this.botonMoverse = new Boton("Moverse A", null);
        this.botonAtacar = new Boton("Atacar", null);
        this.botonConstruirCuartel = new Boton("Construir Cuartel", null);
        this.botonConstruirPC = new Boton("Construir Plaza Central", null);
        this.botonReparar = new Boton("Reparar", null);
        this.botonCrearAldeano = new Boton("Crear Aldeano", null);
        this.botonCrearArquero = new Boton("Crear Arquero", null);
        this.botonCrearEspadachin = new Boton("Crear Espadachin", null);
        this.botonCrearArmaDeAsedio = new Boton("Crear Arma De Asedio", null);


        Pane separador = new Pane();
        separador.setPrefHeight(80);

        VBox contenedorVertical = new VBox(botonMoverse, botonAtacar, botonConstruirCuartel, botonConstruirPC, botonReparar, separador, botonCrearAldeano, botonCrearArquero, botonCrearEspadachin, botonCrearArmaDeAsedio);
        contenedorVertical.setPrefWidth(200);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setStyle("-fx-background-color: #8B4513;");
        contenedorVertical.setPadding(new Insets(20, 20, 20, 20));
        this.setRight(contenedorVertical);
    }

    public Casillero getCasilleroSeleccionado() {
        return this.casilleroSeleccionado;
    }

    public void asignarCasilleroActual(Casillero casillero) {
        this.casilleroSeleccionado = casillero;
    }

    public void activarBotonMoverse() {
        this.botonMoverse.setDisable(false);
    }
    public void activarBotonAtacar() {
        this.botonAtacar.setDisable(false);
    }
    public void activarBotonConstruirCuartel() {
        this.botonConstruirCuartel.setDisable(false);
    }
    public void activarBotonConstruirPC() {
        this.botonConstruirPC.setDisable(false);
    }
    public void activarBotonReparar() {
        this.botonReparar.setDisable(false);
    }
    public void activarBotonCrearAldeano() {
        this.botonCrearAldeano.setDisable(false);
    }
    public void activarBotonCrearArquero() {
        this.botonCrearArquero.setDisable(false);
    }
    public void activarBotonCrearEspadachin() {
        this.botonCrearEspadachin.setDisable(false);
    }
    public void activarBotonCrearArmaDeAsedio() {
        this.botonCrearArmaDeAsedio.setDisable(false);
    }

    public void desactivarBotones(){
        this.botonMoverse.setDisable(true);
        this.botonAtacar.setDisable(true);
        this.botonConstruirCuartel.setDisable(true);
        this.botonConstruirPC.setDisable(true);
        this.botonReparar.setDisable(true);
        this.botonCrearAldeano.setDisable(true);
        this.botonCrearArquero.setDisable(true);
        this.botonCrearEspadachin.setDisable(true);
        this.botonCrearArmaDeAsedio.setDisable(true);
    }


    public void desactivarBotonAtacar() {
        this.botonAtacar.setDisable(true);
    }
}