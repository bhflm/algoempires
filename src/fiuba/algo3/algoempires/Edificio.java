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


    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

    public int getDimension() {
        return this.dimension;
    }

    public abstract void reparar(Aldeano unAldeano);

    //public void UbicarEn(Posicion posicion, ){
    public void terminarReparacion() {
        this.estado = new EstadoEdificioNormal();
    }

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


    public void actualizarUbicacion(Posicion NuevaPosicion) {
        this.PosicionEdificio=NuevaPosicion;
    }

    public void Recibirdanio(int i) {
        this.vida = this.vida - i;
    }

    public int getDimensionEdificio(){
        return this.dimension;
    }

    public void empezarConstruccion(){ this.estado = new EstadoEdificioConstruyendose();}


}