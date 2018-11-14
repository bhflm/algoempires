package fiuba.algo3.algoempires;

public abstract class Edificio {
    protected int vidaMaxima;
    protected int vida;
    protected int costo;
    protected EstadoEdificio estado = new EstadoEdificioNormal();


    public int getVida(){return this.vida;}
    public int getCosto(){return this.costo;}

    public abstract void reparar();

    public abstract void terminarReparacion(){
        this.estado = new EstadoEdificioNormal;
    }

    public abstract void sumarVida(int vidaReparada){
        this.vida += vidaReparada;
        if (this.vida == this.vidaMaxima){
            this.vida = this.vidaMaxima;
        }

    }

    public abstract boolean tieneVidaCompleta(){
        return vida == vidaMaxima;
    }

    public abstract void asignarReparacion(){
        estado = new EstadoEdificioReparandose();
    }
}
