package fiuba.algo3.algoempires.Vistas;


import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Controladores.*;
import fiuba.algo3.algoempires.Direcciones.*;
import fiuba.algo3.algoempires.Entidades.Aldeano;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaPrincipal extends BorderPane {
    Mapa elMapa;
    Casillero casilleroSeleccionado;
    Movible unidadAmover;
    ImportadorMapa importadorMapa;
    Jugador unJugador;
    Jugador otroJugador;
    Jugador jugadorEnTurno;
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
    boolean seRealizoJugada;
    GridPane gridPane;
    VBox contenedorVertical;

    public VistaPrincipal() {
        this.casilleroSeleccionado = null;
        this.juegoAlgoEmpires = new Juego();
        this.unJugador = new Jugador("Foo");
        this.otroJugador = new Jugador("Bar");
        int dimensionMapa = 15;
        this.juegoAlgoEmpires.comenzarJuego(unJugador, otroJugador, dimensionMapa);
        this.jugadorEnTurno=this.juegoAlgoEmpires.getActual();
        this.importadorMapa=new ImportadorMapa();
        this.elMapa = importadorMapa.GenerarMapa(this.juegoAlgoEmpires.getmapa());
        this.crearTablero(elMapa);
        this.setFondo();
        this.setAcciones();
        this.seRealizoJugada=false;

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
                int rowt=(-row)+dimenRow;
                int colt=col+1;
                Posicion posicionUbicable = new Posicion(colt , rowt);
                Ubicable elUbicable = miMapa.GetUbicableEn(posicionUbicable);
                Casillero casillero = new Casillero(elUbicable, posicionUbicable);
                casillero.setOnMouseClicked(new SeleccionarCasillero(this, gridPane, casillero,this.importadorMapa,dimenRow));
                gridPane.add(casillero,col, row);
                gridPane.setHgrow(casillero, Priority.ALWAYS);
                gridPane.setVgrow(casillero, Priority.ALWAYS);
            }


    }


    public void setAcciones() {

        this.botonMoverse = new Boton("Moverse A", new AccionRealizarMovimiento(this));
        this.botonAtacar = new Boton("Atacar", null);
        this.botonConstruirCuartel = new Boton("Construir Cuartel", null);
        this.botonConstruirPC = new Boton("Construir Plaza Central", null);
        this.botonReparar = new Boton("Reparar", null);
        this.botonCrearAldeano = new Boton("Crear Aldeano", null);
        this.botonCrearArquero = new Boton("Crear Arquero", null);
        this.botonCrearEspadachin = new Boton("Crear Espadachin", null);
        this.botonCrearArmaDeAsedio = new Boton("Crear Arma De Asedio", null);
        this.botonPasarTurno = new Boton("Terminar Turno", null);

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
        this.botonPasarTurno.setDisable(true);

    }


    public void desactivarBotonAtacar() {
        this.botonAtacar.setDisable(true);
    }

    public Jugador elJugadorActualEs() {
    return this.jugadorEnTurno;
    }

    public void borrarSetAcciones(){
        this.getChildren().remove(this.contenedorVertical);
    }

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
    public void actualizarTablero(Posicion posActual,Posicion posSiguiente){
        int dimenRow = this.elMapa.getLargoHorizontal();
        int posActualCoordenadaVertical=importadorMapa.obtenerCoordenadaFila(posActual,dimenRow);

        int posActualCoordenadaHorizontal=importadorMapa.obtenerCoordenadaColumna(posActual);
        Casillero casilleroLibre=new Casillero(new EspacioLibre(),posActual);
        this.gridPane.getChildren().remove(posActualCoordenadaHorizontal,posActualCoordenadaVertical);
        this.gridPane.add(casilleroLibre,posActualCoordenadaHorizontal,posActualCoordenadaVertical);
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

    public void cambiarJugadorEnTurno(Juego elJuego) {
        this.jugadorEnTurno=elJuego.getActual();
    }
}