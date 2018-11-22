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
    protected int rangoDeAtaque = 0;
    protected int puntosDeAtaqueUnidad = 0;
    protected int puntosDeAtaqueEdificio = 0;

    public int getVida(){ return this.vida; }
    public int getCosto(){
        return this.costo;
    }
    public String getOrigen() {return this.origen; }
    public Posicion getPosicion(){return this.PosicionUnidad;}
    public int getDimension() {return this.dimension;}
    public int getRangoDeAtaque(){return this.rangoDeAtaque;}
    public int recaudarOro(){
        int oroRecaudado=this.estado.generarOro();
        return oroRecaudado;}

    public void recibirDanio(int danioRecibido){
        this.vida = this.vida - danioRecibido;
        if (this.vida <= 0) {this.vida = 0;}
    }

    public boolean estaMuerto(){
        return (this.vida == 0 );
    }

    public void modificarPosicion(Posicion posicionUnidad){
        this.PosicionUnidad=posicionUnidad;
    }


    public int getPuntosDeAtaqueUnidad(){
        return this.puntosDeAtaqueUnidad;
    }

    public int getPuntosDeAtaqueEdificio(){
        return this.puntosDeAtaqueEdificio;
    }



}
