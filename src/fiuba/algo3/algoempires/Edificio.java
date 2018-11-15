package fiuba.algo3.algoempires;

public abstract class Edificio implements Ubicable {
    protected int vidaMaxima;
    protected int vida;
    protected int costo;
    protected int dimension;
    protected EstadoEdificio estado = new EstadoEdificioNormal();


    public int getVida(){return this.vida;}
    public int getCosto(){return this.costo;}
    public int getDimension(){return this.dimension;}

    public abstract void reparar(Aldeano unAldeano);
    //public void UbicarEn(Posicion posicion, ){
    public void terminarReparacion(){
        this.estado = new EstadoEdificioNormal();
    }

    public void sumarVida(int vidaReparada){
        this.vida += vidaReparada;
        if (this.vida == this.vidaMaxima){
            this.vida = this.vidaMaxima;
        }
    }

    public boolean tieneVidaCompleta(){
        return vida == vidaMaxima;
    }

    public void asignarReparacion(){
        estado = new EstadoEdificioReparandose();
    }
}
