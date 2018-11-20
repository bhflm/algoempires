package fiuba.algo3.algoempires;

import java.util.HashMap;

public abstract class Edificio implements Ubicable {
    protected int vidaMaxima;
    protected int vida;
    protected int costo;
    protected int dimension;
    protected int turnosRestantes;
    protected Posicion PosicionEdificio;
    protected EstadoEdificio estado = new EstadoEdificioNormal();
    protected boolean PisableEnElMapa=false;
    protected int danioProducidoPorArquero=10;

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

    public void Recibirdanio(int i) {
        this.vida = this.vida - i;
    }

    public void empezarConstruccion(){ this.estado = new EstadoEdificioConstruyendose();}

    public void construir(Aldeano unAldeano){
        turnosRestantes -= 1;
        if (turnosRestantes == 0){
            unAldeano.desocupar();
            this.estado = new EstadoEdificioNormal();
        }
    }

    public void continuarRepararacion(Aldeano unAldeano){}
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

    public void modificarPosicion(Posicion posicionEd){
        this.PosicionEdificio=posicionEd;

    }
}