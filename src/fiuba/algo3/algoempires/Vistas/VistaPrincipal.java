package fiuba.algo3.algoempires.Vistas;


import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Controladores.*;
import fiuba.algo3.algoempires.Direcciones.*;
import fiuba.algo3.algoempires.Entidades.Aldeano;
import fiuba.algo3.algoempires.Entidades.Arquero;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class VistaPrincipal extends BorderPane {
    public String nombreAccion;
    Mapa elMapa;
    Casillero casilleroSeleccionado;
    Casillero casilleroOfrecido;
    Movible unidadAmover;
    ImportadorMapa importadorMapa;
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
    Boton botonPasarTurno;
    Boton botonArriba;
    Boton botonArribaIzquierda;
    Boton botonArribaDerecha;
    Boton botonIzquierda;
    Boton botonDerecha;
    Boton botonAbajo;
    Boton botonAbajoIzquierda;
    Boton botonAbajoDerecha;
    GridPane gridPane;
    VBox contenedorVertical;
    HBox contenedorInferior;
    private HashMap<Posicion, Casillero> tableroDelMapa;
    String textoVida;
    Label labelVida;
    Label labelOro;
    Boton botonConfirmar;

    public VistaPrincipal() {
        this.casilleroSeleccionado = null;
        this.juegoAlgoEmpires = new Juego();
        this.unJugador = new Jugador("Foo");
        this.otroJugador = new Jugador("Bar");
        int dimensionMapa = 15;
        this.juegoAlgoEmpires.comenzarJuego(unJugador, otroJugador, dimensionMapa);
        this.importadorMapa=new ImportadorMapa();
        this.elMapa = importadorMapa.GenerarMapa(this.juegoAlgoEmpires.getmapa());
        this.crearTablero(elMapa);
        this.setFondo();
        this.setAcciones();
        this.setMenuInferior();
    }

    private void setMenuInferior() {
        this.contenedorInferior=new HBox();
        this.contenedorInferior.setPrefWidth(1);
        this.contenedorInferior.setPrefHeight(1);
        this.contenedorInferior.setSpacing(10);
        this.contenedorInferior.setStyle("-fx-background-color: #8B4513;");
        this.setBottom(this.contenedorInferior);
        this.labelVida=new Label("Vida del Ubicable");
        this.labelOro=new Label("Oro del jugador");
        this.contenedorInferior.getChildren().addAll(new Label("Vida"),this.labelVida,new Label("Oro Disponible"),labelOro);



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
        // gridPane.setGridLinesVisible(true);
        int dimenRow = this.elJuegoEs().getmapa().getLargoHorizontal();
        int dimenCol = this.elJuegoEs().getmapa().getLargoVertical();
        this.tableroDelMapa=new HashMap<Posicion, Casillero>();

        for (int row = 0; row < dimenRow; row++)
            for (int col = 0; col < dimenCol; col++) {
                int rowt=(-row)+dimenRow;
                int colt=col+1;
                Posicion posicionUbicable = new Posicion(colt , rowt);
                Ubicable elUbicable = this.elJuegoEs().getmapa().GetUbicableEn(posicionUbicable);
                Casillero casillero = new Casillero(elUbicable, posicionUbicable);
                this.tableroDelMapa.put(posicionUbicable,casillero);
                casillero.setOnMouseClicked(new SeleccionarCasillero(this, gridPane, casillero,this.importadorMapa,dimenRow));
                gridPane.add(casillero,col, row);
                gridPane.setHgrow(casillero, Priority.ALWAYS);
                gridPane.setVgrow(casillero, Priority.ALWAYS);
            }
    }




    public void ofrecerCasilleros(Mapa miMapa) {
        int dimenRow = miMapa.getLargoHorizontal();
        int dimenCol = miMapa.getLargoVertical();

        for (int row = 0; row < dimenRow; row++)
            for (int col = 0; col < dimenCol; col++) {
                Casillero casillero = (Casillero) (gridPane.getChildren().get(row*(15)+col));
                casillero.setOnMouseClicked(new AccionClickear(this, gridPane, casillero,this.importadorMapa,dimenRow));
            }

    }


    public void setAcciones() {

        this.botonMoverse = new Boton("Moverse A", new AccionRealizarMovimiento(this));
        this.botonAtacar = new Boton("Atacar", new RealizarAtaque(this));
        this.botonConstruirCuartel = new Boton("Construir Cuartel", new ConstruirCuartel(this));
        this.botonConstruirPC = new Boton("Construir Plaza Central", new ConstruirPlazaCentral(this));
        this.botonReparar = new Boton("Reparar", new Reparar(this));
        this.botonCrearAldeano = new Boton("Crear Aldeano", new CrearAldeano(this));
        this.botonCrearArquero = new Boton("Crear Arquero", new CrearArquero(this));
        this.botonCrearEspadachin = new Boton("Crear Espadachin", new CrearEspadachin(this));
        this.botonCrearArmaDeAsedio = new Boton("Crear Arma De Asedio",new CrearArmaDeAsedio(this));
        this.botonPasarTurno = new Boton("Terminar Turno", new AccionPasarTurno(this));

        Pane separador = new Pane();
        separador.setPrefHeight(80);

        this.contenedorVertical = new VBox(botonMoverse, botonAtacar, botonConstruirCuartel, botonConstruirPC, botonReparar, separador, botonCrearAldeano, botonCrearArquero, botonCrearEspadachin, botonCrearArmaDeAsedio,botonPasarTurno);
        this.desactivarBotones();
        contenedorVertical.setPrefWidth(200);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setStyle("-fx-background-color: #8B4513;");
        contenedorVertical.setPadding(new Insets(20, 20, 20, 20));
        this.setRight(contenedorVertical);
    }


    public Mapa getElMapa() {
        return this.elMapa;
    }

    public Casillero getCasilleroSeleccionado() {
        return this.casilleroSeleccionado;
    }


    public Casillero getCasilleroOfrecido() {
        return this.casilleroOfrecido;
    }

    public void asignarCasilleroActual(Casillero casillero) {
        this.casilleroSeleccionado = casillero;
    }

    public void asignarCasilleroOfrecido(Casillero casillero) {
        this.casilleroOfrecido = casillero;
        casillero.printNombre();
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
        this.botonPasarTurno.setDisable(false);

    }


    public void desactivarBotonAtacar() {
        this.botonAtacar.setDisable(true);
    }

    public Jugador elJugadorActualEs() {
    return this.elJuegoEs().getActual();
    }

    public void borrarSetAcciones(){
        this.getChildren().remove(this.contenedorVertical);
    }

    public void mostrarConfirmacion() {
        this.botonConfirmar = new Boton("Confirmar", null);
        this.contenedorVertical.getChildren().add(this.botonConfirmar);
        this.botonConfirmar.setOnAction(new ejecutarAccion(this,gridPane));
        contenedorVertical.setPrefWidth(200);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setStyle("-fx-background-color: #8B4513;");
        contenedorVertical.setPadding(new Insets(20, 20, 20, 20));
        this.setRight(contenedorVertical);
    };

    public void mostrarMenuDirecciones() {
        this.botonArriba = new Boton("Arriba ", new AccionMover(this,new DireccionSuperiorVertical()));
        this.botonArribaIzquierda = new Boton("Arriba Izquierda", new AccionMover(this,new DireccionDiagonalIzquierdaSuperior()));
        this.botonArribaDerecha = new Boton("Arriba Derecha", new AccionMover(this,new DireccionDiagonalDerechaSuperior()));
        this.botonIzquierda = new Boton("Izquierda", new AccionMover(this,new DireccionIzquierdaHorizontal()));
        this.botonDerecha= new Boton("Derecha",  new AccionMover(this,new DireccionDerechaHorizontal()));
        this.botonAbajo = new Boton("Abajo", new AccionMover(this,new DireccionInferiorVertical()));
        this.botonAbajoIzquierda = new Boton("Abajo Izquierda", new AccionMover(this,new DireccionDiagonalIzquierdaInferior()));
        this.botonAbajoDerecha = new Boton("Abajo Derecha",new AccionMover(this,new DireccionDiagonalDerechaInferior()));
        Pane separador = new Pane();
        separador.setPrefHeight(80);
        this.contenedorVertical = new VBox(botonArriba, botonArribaIzquierda, botonArribaDerecha, botonIzquierda, botonDerecha,botonAbajoIzquierda, botonAbajo, botonAbajoDerecha);
        contenedorVertical.setPrefWidth(200);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setStyle("-fx-background-color: #8B4513;");
        contenedorVertical.setPadding(new Insets(20, 20, 20, 20));
        this.setRight(contenedorVertical);

    }
    public void actualizarTablero(){
        this.crearTablero(this.elMapa);
    }




    public Juego elJuegoEs() {
        return this.juegoAlgoEmpires;
    }

    public void asignarMovible(Ubicable elUbicableDelCasillero) {
        Movible elMovibleDelCasillero=(Movible) elUbicableDelCasillero;
        this.unidadAmover= elMovibleDelCasillero;
    }

    public Movible elMovible() {
        return this.unidadAmover;
    }


    public void actualizarTableroPorMovimiento(Posicion posActual, Posicion posSiguiente) {
        int dimenRow = this.elJuegoEs().getmapa().getLargoHorizontal();
        int dimenCol = this.elJuegoEs().getmapa().getLargoVertical();
        Ubicable elUbicableDondeEstoy = this.elJuegoEs().getmapa().getUbicaciones().get(posActual);
        Ubicable elUbicableDondeQuieroEstar=this.elJuegoEs().getmapa().getUbicaciones().get(posSiguiente);
        Casillero casilleroDondeEstoy=this.tableroDelMapa.get(posActual);
        Casillero casilleroDondeQuieroEstar=this.tableroDelMapa.get(posSiguiente);
        casilleroDondeEstoy.setUbicable(elUbicableDondeQuieroEstar);
        casilleroDondeQuieroEstar.setUbicable(elUbicableDondeEstoy);
        }

    public void mostrarInformacionCasillero(Casillero casilleroASeleccionar) {

        Ubicable ubicableDelCasillero=casilleroASeleccionar.getUbicable();
        int vidaDelUbicable=ubicableDelCasillero.vidaActual();
        String textoVida=Integer.toString(vidaDelUbicable);
        this.labelVida.setText(textoVida);
        Jugador jugadorActual=this.elJugadorActualEs();
        String textoOro=Integer.toString(jugadorActual.getOro());
        this.labelOro.setText(textoOro);
    }


    public void actualizarTableroV2(Mapa unMapa) {
        int dimenRow = unMapa.getLargoHorizontal();
        int dimenCol = unMapa.getLargoVertical();
        for (int row = 0; row < dimenRow; row++)
            for (int col = 0; col < dimenCol; col++) {
                int rowt = (-row) + dimenRow;
                int colt = col + 1;
                Posicion posicionUbicable = new Posicion(colt, rowt);
                Ubicable elUbicable = unMapa.getUbicaciones().get(posicionUbicable);
                Casillero casillero = this.tableroDelMapa.get(posicionUbicable);
                if (elUbicable != this.tableroDelMapa.get(posicionUbicable).getUbicable()){
                    casillero.setUbicable(elUbicable);
                }
                this.tableroDelMapa.get(posicionUbicable).setOnMouseClicked(new SeleccionarCasillero(this, gridPane, casillero,this.importadorMapa,dimenRow));

                System.gc();
            }


    }



}