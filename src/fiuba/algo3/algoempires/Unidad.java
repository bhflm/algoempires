package fiuba.algo3.algoempires;


public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected String origen;
    protected EstadoUnidad estado;
    protected Posicion PosicionUnidad;
    protected int dimension = 1;
    protected boolean PisableEnElMapa=false;
    protected int rangoDeAtaque=0;
    protected int puntosDeAtaque=0;

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
