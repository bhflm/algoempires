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

    protected int puntosDeAtaque=0;
    protected int danioProducidoPorArquero=15;
    protected int danioProducidoPorCastillo=20;
    protected int getDanioProducidoPorEspadachin=25;
    protected int getDanioProducidoPorArmaDeAsedio=0;


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

    public void recibirDanio(Arquero arquero){
        Posicion posicionAtacable=this.PosicionUnidad;
        Posicion posicionAtacante=arquero.PosicionUnidad;
        boolean esAtacable=posicionAtacante.estaAlAlcance(posicionAtacable,arquero.rangoDeAtaque);
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorArquero;
        else throw new AtaqueFueraDeRango();
    }
    public void recibirDanio(Espadachin espadachin){
        Posicion posicionAtacable=this.PosicionUnidad;
        Posicion posicionAtacante=espadachin.PosicionUnidad;
        boolean esAtacable=posicionAtacante.estaAlAlcance(posicionAtacable,espadachin.rangoDeAtaque);
        if(esAtacable)
            this.vida=this.vida-getDanioProducidoPorEspadachin;
        else throw new AtaqueFueraDeRango();
    }

    public void recibirDanio(ArmaDeAsedio armaDeAsedio){
        Posicion posicionAtacable=this.PosicionUnidad;
        Posicion posicionAtacante=armaDeAsedio.PosicionUnidad;
        boolean esAtacable=posicionAtacante.estaAlAlcance(posicionAtacable,armaDeAsedio.rangoDeAtaque);
        if(esAtacable)
            this.vida=this.vida-getDanioProducidoPorArmaDeAsedio;
        else throw new AtaqueFueraDeRango();
    }

    public void recibirDanio(Castillo castillo){
        Posicion posicionAtacable=this.PosicionUnidad;
        Posicion posicionAtacante=castillo.PosicionEdificio;
        int dimensionAtacante=castillo.getDimension();
        boolean esAtacableDesde=false;
        boolean esAtacable=false;
        for(int i=0;i<dimensionAtacante;i++){
            for (int j=0;j<dimensionAtacante;j++){
                Posicion posicionDelAtacante=posicionAtacante.PosicionCorridaA(i,j);
                esAtacableDesde=posicionAtacable.estaAlAlcance(posicionDelAtacante,castillo.rangoDeAtaque);
                if(esAtacableDesde){
                    esAtacable=true;}}}
        if(esAtacable)
            this.vida=this.vida-danioProducidoPorCastillo;
        else throw new AtaqueFueraDeRango();
    }

    public void modificarPosicion(Posicion posicionUnidad){
        this.PosicionUnidad=posicionUnidad;
    }


}
