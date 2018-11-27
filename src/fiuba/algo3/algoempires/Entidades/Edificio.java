package fiuba.algo3.algoempires.Entidades;

import fiuba.algo3.algoempires.*;
import fiuba.algo3.algoempires.Excepciones.AtaqueFueraDeRango;
import fiuba.algo3.algoempires.Excepciones.PosicionInvalidaException;

public abstract class Edificio implements Ubicable {
    protected int vidaMaxima;
    protected int vida;
    protected int costo;
    protected int dimension;
    protected int turnosRestantes;
    protected Posicion PosicionEdificio;
    protected EstadoEdificio estado = new EstadoEdificioNormal();
    protected boolean PisableEnElMapa=false;
    protected int rangoDeAtaque = 0;


    protected int danioProducidoPorArquero=10;
    protected int danioProducidoPorCastillo=20;
    protected int danioProducidoPorEspadachin=15;
    protected int danioProducidoPorArmaDeAsedio=75;



    public EstadoEdificio getEstado() { return this.estado ;}

    public int getVida() {
        return this.vida;
    }
    public void setVida(int vidaNueva) {this.vida = vidaNueva;}
    public int getCosto() {
        return this.costo;
    }
    public int getDimension() {
        return this.dimension;
    }
    public int getVidaMaxima() {return this.vidaMaxima;}
    public Posicion getPosicion(){return this.PosicionEdificio;}

    public abstract void reparar(Aldeano unAldeano);


    public void sumarVida(int vidaReparada) {
        this.vida += vidaReparada;
        if (this.vida >= this.vidaMaxima) {
            this.vida = this.vidaMaxima;
        }
    }

    public boolean tieneVidaCompleta() {
        return vida == vidaMaxima;
    }

    public void asignarReparacion() {
        estado = new EstadoEdificioReparandose();
    }
    public void terminarReparacion() {
        this.estado = new EstadoEdificioNormal();
    }

    public void actualizarUbicacion(Posicion NuevaPosicion) {
        this.PosicionEdificio=NuevaPosicion;
    }

    public void empezarConstruccion(){ this.estado = new EstadoEdificioConstruyendose();}

    public void construir(Aldeano unAldeano){
        turnosRestantes -= 1;
        if (turnosRestantes == 0){
            this.estado = new EstadoEdificioNormal();
        }
        if (turnosRestantes == -1){
            unAldeano.desocupar();
        }
    }

    public void continuarRepararacion(Aldeano unAldeano){}

    public void modificarPosicion(Posicion posicionEd){
        this.PosicionEdificio=posicionEd;
    }

    public void chequearPosicion(Posicion posicionUbicable, Posicion posicionEdificio, int dimension){
        int posicionMinima = posicionEdificio.getCoordenadaHorizontal() - 1;
        int posicionMaxima = posicionEdificio.getCoordenadaHorizontal() + dimension;

        if (posicionUbicable.getCoordenadaHorizontal() < posicionMinima || posicionUbicable.getCoordenadaVertical() > posicionMaxima){
            throw new PosicionInvalidaException();
        }
    }

    public void RecibirDanio(int danio){
        this.vida = this.vida - danio;
    }

    public void recibirDanio(Arquero arquero){
        Posicion posicionAtacable=this.PosicionEdificio;
        Posicion posicionAtacante=arquero.PosicionUnidad;
        boolean esAtacable=false;
        boolean esAtacableDesde=false;

        for(int i=0;i<this.dimension;i++){
            for (int j=0;j<this.dimension;j++){
                Posicion posicionDelAtacable=posicionAtacable.PosicionCorridaA(i,j);
                esAtacableDesde=posicionAtacante.estaAlAlcance(posicionDelAtacable,arquero.rangoDeAtaque);
                if(esAtacableDesde){
                    esAtacable=true;}}}
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorArquero;
        else throw new AtaqueFueraDeRango();
    }

    public void recibirDanio(Castillo castillo){
        Posicion posicionAtacable=this.PosicionEdificio;
        Posicion posicionAtacante=castillo.PosicionEdificio;
        int dimensionAtacante=castillo.getDimension();
        boolean esAtacableDesde=false;
        boolean esAtacable=false;
        for(int i=0;i<dimensionAtacante;i++){
            for (int j=0;j<dimensionAtacante;j++){
                for(int k=0;k<this.dimension;k++){
                    for(int f=0;f<this.dimension;f++){
                        Posicion posicionDelAtacante=posicionAtacante.PosicionCorridaA(i,j);
                        Posicion posicionDelAtacable=posicionAtacable.PosicionCorridaA(k,f);
                        esAtacableDesde=posicionDelAtacable.estaAlAlcance(posicionDelAtacante,castillo.rangoDeAtaque);
                        if(esAtacableDesde){
                            esAtacable=true;}}}}}
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorCastillo;
        else throw new AtaqueFueraDeRango();
    }

    public void recibirDanio(Espadachin espadachin){
        Posicion posicionAtacable=this.PosicionEdificio;
        Posicion posicionAtacante=espadachin.PosicionUnidad;
        boolean esAtacable=false;
        boolean esAtacableDesde=false;

        for(int i=0;i<this.dimension;i++){
            for (int j=0;j<this.dimension;j++){
                Posicion posicionDelAtacable=posicionAtacable.PosicionCorridaA(i,j);
                esAtacableDesde=posicionAtacante.estaAlAlcance(posicionDelAtacable,espadachin.rangoDeAtaque);
                if(esAtacableDesde){
                    esAtacable=true;}}}
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorEspadachin;
        else throw new AtaqueFueraDeRango();
    }

    public void recibirDanio(ArmaDeAsedio armaDeAsedio){
        Posicion posicionAtacable=this.PosicionEdificio;
        Posicion posicionAtacante=armaDeAsedio.PosicionUnidad;
        boolean esAtacable=false;
        boolean esAtacableDesde=false;

        for(int i=0;i<this.dimension;i++){
            for (int j=0;j<this.dimension;j++){
                Posicion posicionDelAtacable=posicionAtacable.PosicionCorridaA(i,j);
                esAtacableDesde=posicionAtacante.estaAlAlcance(posicionDelAtacable,armaDeAsedio.rangoDeAtaque);
                if(esAtacableDesde){
                    esAtacable=true;}}}
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorArmaDeAsedio;
        else throw new AtaqueFueraDeRango();
    }






}