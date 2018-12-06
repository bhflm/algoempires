package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Direcciones.*;
import fiuba.algo3.algoempires.Entidades.*;
import fiuba.algo3.algoempires.Excepciones.JugadaInvalidaException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class JuegoTest {

    @Test
    public void test01CreoJuegoConDosJugadoresDevuelveJugadorOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");

        unJuego.comenzarJuego(unJugador,otroJugador,15);
        assertEquals(unJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test02CreoJuegoConDosJugadoresCambiaTurnoOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);
        unJuego.cambiarJugadorActual();
        assertEquals(otroJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test03CreoJuegoConDosJugadoresCambiaTurnoDosVecesOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);
        unJuego.cambiarTurno();
        unJuego.cambiarTurno();
        assertEquals(unJugador.getNombre(),unJuego.getNombreActual());
    }

    @Test
    public void test04CreoJuegoConDosJugadoresMueveAldeanoMismoTurnoOk() {
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Aldeano unAldeano = new Aldeano();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJuego.getActual().agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unAldeano);

        Direccion moverDerecha = new DireccionDerechaHorizontal();
        Posicion nuevaPos = new Posicion(3,2);

        unJugador.moverUnidad(unJuego,unMapa,unAldeano,moverDerecha);

        assertEquals(nuevaPos,unAldeano.getPosicion());
    }

    @Test
    public void test05CreoJuegoConDosJugadoresMueveArqueroMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Arquero unArquero = new Arquero();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unArquero);
        unMapa.UbicarUnidadEnMapa(unaPos,unArquero);

        Direccion moverDerecha = new DireccionIzquierdaHorizontal();
        Posicion nuevaPos = new Posicion(1,2);

        unJugador.moverUnidad(unJuego,unMapa,unArquero,moverDerecha);

        assertEquals(nuevaPos,unArquero.getPosicion());
    }


    @Test
    public void test06CreoJuegoConDosJugadoresMueveArmaDeAsedioMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        ArmaDeAsedio unArmaAsedio = new ArmaDeAsedio();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unArmaAsedio);
        unMapa.UbicarUnidadEnMapa(unaPos,unArmaAsedio);

        Direccion moverDerecha = new DireccionInferiorVertical();
        Posicion nuevaPos = new Posicion(2,1);
        unJugador.moverUnidad(unJuego,unMapa,unArmaAsedio,moverDerecha);

        assertEquals(nuevaPos,unArmaAsedio.getPosicion());
    }

    @Test
    public void test07CreoJuegoConDosJugadoresMueveEspadachinMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionSuperiorVertical();
        Posicion nuevaPos = new Posicion(2,3);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test08CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaInferiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaInferior();
        Posicion nuevaPos = new Posicion(1,1);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test09CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaInferiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaInferior();
        Posicion nuevaPos = new Posicion(3,1);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }


    @Test
    public void test10CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalDerechaSuperiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);

        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalDerechaSuperior();
        Posicion nuevaPos = new Posicion(3,3);

        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        assertEquals(nuevaPos,unEspadachin.getPosicion());
    }

    @Test
    public void test11CreoJuegoConDosJugadoresMueveEspadachinEnDireccionDiagonalIzquierdaSuperiorEnELMismoTurnoOk() {

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaSuperior();
        Posicion nuevaPos = new Posicion(1,3);
        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);
    }


    @Test
    public void test12JugadorNoPuedeJugarEnTurnoQueNoCorresponde(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.comenzarJuego(unJugador,otroJugador,15);

        boolean seLanzoError = false;

        Espadachin unEspadachin = new Espadachin();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        unJugador.agregarUnidad(unEspadachin);
        unMapa.UbicarUnidadEnMapa(unaPos,unEspadachin);

        Direccion moverDerecha = new DireccionDiagonalIzquierdaSuperior();
        Direccion moverAbajoDerecha = new DireccionDiagonalDerechaInferior();
        Posicion nuevaPos = new Posicion(1,3);
        unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverDerecha);

        try {
            unJugador.moverUnidad(unJuego,unMapa,unEspadachin,moverAbajoDerecha);
        }
        catch(JugadaInvalidaException e){
            seLanzoError = true;
        }
        assertTrue(seLanzoError);

    }

    @Test
    public void test13AsignoLasUnidadesInicialesALosJugadoresYVerificoQueLaPoblacionSea3EnUnJugador(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        int dimensionMapa=25;
        unJuego.comenzarJuego(unJugador,otroJugador,dimensionMapa);
        assertEquals(3,unJugador.getPoblacion());
    }

    @Test
    public void test14AsignoLasUnidadesInicialesALosJugadoresYVerificoQueLaPoblacionSea3EnOtroJugador(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        int dimensionMapa=25;
        unJuego.comenzarJuego(unJugador,otroJugador,dimensionMapa);
        assertEquals(3,otroJugador.getPoblacion());
    }

    @Test
    public void test15AsignoLasUnidadesInicialesALosJugadoresYVerificoQueTengaElOroCorrecto(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        int dimensionMapa=25;
        unJuego.comenzarJuego(unJugador,otroJugador,dimensionMapa);
        assertEquals(100,otroJugador.getOro());
    }

    @Test
    public void test16InicioJuegoVerificoQueJugadorInicieCon3UnidadesTipoAldeanos(){
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        int dimensionMapa=25;
        unJuego.comenzarJuego(unJugador,otroJugador,dimensionMapa);
        assertEquals(100,otroJugador.getOro());
    }

    @Test
    public void test17CreoJuegoConDosJugadoresConUnArqueroAtancandoUnAldeano() {

        int DanioProducidoPorArquero = 15;

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        Posicion otraPos= new Posicion(2,3);
        unJugador.agregarUnidad(unArquero);
        otroJugador.agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unArquero);
        unMapa.UbicarUnidadEnMapa(otraPos,unAldeano);
        int vidaPrevia=unAldeano.getVida();
        unJugador.realizarAtaque(unArquero,unAldeano);
        assertEquals(vidaPrevia-DanioProducidoPorArquero,unAldeano.getVida());
    }

    @Test
    public void test18CreoJuegoConDosJugadoresConUnArqueroAtancandoUnAldeanoDelMismoJugador() {
        boolean seLanzoError=false;
        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);
        Arquero unArquero = new Arquero();
        Aldeano unAldeano = new Aldeano();
        Mapa unMapa = new Mapa(4,4);
        Posicion unaPos = new Posicion(2,2);
        Posicion otraPos= new Posicion(2,3);
        unJugador.agregarUnidad(unArquero);
        unJugador.agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unArquero);
        unMapa.UbicarUnidadEnMapa(otraPos,unAldeano);
        try {
            unJugador.realizarAtaque(unArquero, unAldeano);
        }
        catch(JugadaInvalidaException e){
            seLanzoError=true;
        }
        assertTrue(seLanzoError);
    }

    @Test
    public void test19CreoJuegoConDosJugadoresConUnCastilloAtancandoDosAldeanos() {

        int danioProducidoPorCastillo = 20;

        Juego unJuego = new Juego();
        Jugador unJugador = new Jugador("Foo");
        Jugador otroJugador = new Jugador("Bar");
        unJuego.iniciarJuego(unJugador,otroJugador);
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();
        Castillo unCastillo=new Castillo();
        Mapa unMapa = new Mapa(25,25);
        Posicion unaPos = new Posicion(2,2);
        Posicion otraPos= new Posicion(2,3);
        Posicion posicionCastillo=new Posicion(4,1);
        unJugador.agregarUnidad(otroAldeano);
        unJugador.agregarUnidad(unAldeano);
        unMapa.UbicarUnidadEnMapa(unaPos,unAldeano);
        unMapa.UbicarUnidadEnMapa(otraPos,otroAldeano);
        unMapa.UbicarUnidadEnMapa(posicionCastillo,unCastillo);
        int vidaPreviaUnAldeano=unAldeano.getVida();
        otroJugador.CastilloRealizaAtaqueMasivo(unCastillo,unMapa);
        assertEquals(unAldeano.getVida(),vidaPreviaUnAldeano-danioProducidoPorCastillo);
        assertEquals(otroAldeano.getVida(),vidaPreviaUnAldeano-danioProducidoPorCastillo);

    }

}