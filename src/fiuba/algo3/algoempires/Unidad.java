package fiuba.algo3.algoempires;


public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected String origen;
    protected EstadoUnidad estado;
    protected Posicion PosicionUnidad;
    protected Edificio edificioActual;
    protected int dimension = 1;
    protected boolean PisableEnElMapa=false;

    public int getVida(){ return this.vida; }
    public int getCosto(){
        return this.costo;
    }
    public String getOrigen() {return this.origen; }
    public Posicion getPosicion(){return this.PosicionUnidad;};
    public int getDimension() {return this.dimension;}
    public int recaudarOro(){
        int oroRecaudado=this.estado.generarOro();
        return oroRecaudado;}


}
