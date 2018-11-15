package fiuba.algo3.algoempires;


public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected String origen;
    protected  Posicion PosicionUnidad;

    public int getVida(){ return this.vida; }
    public int getCosto(){
        return this.costo;
    }
    public Posicion getPosicion(){return this.PosicionUnidad;};
    public String getOrigen() {return this.origen; }

}
