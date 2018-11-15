package fiuba.algo3.algoempires;


public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected String origen;
    protected EstadoUnidad estado;
    protected Posicion PosicionUnidad;
    protected int dimension = 1;

    public int getVida(){ return this.vida; }
    public int getCosto(){
        return this.costo;
    }
    public String getOrigen() {return this.origen; }
    public Posicion getPosicion(){return this.PosicionUnidad;};
    public int getDimension() {return this.dimension;}
}
