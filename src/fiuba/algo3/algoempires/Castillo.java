package fiuba.algo3.algoempires;

    public class Castillo extends Edificio implements Atacante {

        private int puntosDeAtaqueUnidad=20;
        private int puntosDeAtaqueEdificio=20;
        private int rangoDeAtaque=3;
        public Castillo() {
            vidaMaxima = 1000;
            vida = 1000;
            dimension = 4;
        }

    public ArmaDeAsedio crearArmaDeAsedio(){
        return new ArmaDeAsedio();
    }
    
    @Override
    public void reparar(Aldeano unAldeano) {
        estado.reparar(this, 15, unAldeano);
    }
    public void continuarRepararacion(Aldeano unAldeano){
            estado.continuarReparacion(this, 15, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;}
    public int getPuntosDeAtaqueUnidad(){
            return this.puntosDeAtaqueUnidad;
        }
    public int getPuntosDeAtaqueEdificio(){return this.puntosDeAtaqueEdificio;}
    public int getRangoDeAtaque(){return this.rangoDeAtaque;}

        public void atacarA(Unidad unidadAtacada){
            Posicion posicionAtacable = unidadAtacada.getPosicion();
            Posicion posicionAtacante = this.PosicionEdificio;
            int dimensionAtacante=this.dimension;
            int dimensionAtacable=unidadAtacada.getDimension();
            boolean esAtacableDesde=false;
            boolean esAtacable=false;

            for(int i=0;i<dimensionAtacante;i++){
                for (int j=0;j<dimensionAtacante;j++){
                            Posicion posicionDelAtacante=posicionAtacante.PosicionCorridaA(i,j);
                            esAtacableDesde=posicionAtacable.estaAlAlcance(posicionDelAtacante,this.rangoDeAtaque);
                            if(esAtacableDesde){
                                esAtacable=true;}}}
            if(esAtacable)
                unidadAtacada.recibirDanio(this.puntosDeAtaqueUnidad);
            else throw new AtaqueFueraDeRango();
        }

        public void atacarA(Edificio edificioAtacado){
            Posicion posicionAtacable = edificioAtacado.getPosicion();
            Posicion posicionAtacante = this.PosicionEdificio;
            int dimensionAtacante=this.dimension;
            int dimensionAtacable=edificioAtacado.getDimension();
            boolean esAtacableDesde=false;
            boolean esAtacable=false;

            for(int i=0;i<dimensionAtacante;i++){
                for (int j=0;j<dimensionAtacante;j++){
                    for(int k=0;k<dimensionAtacable;k++){
                        for(int f=0;f<dimensionAtacable;f++){
                            Posicion posicionDelAtacante=posicionAtacante.PosicionCorridaA(i,j);
                            Posicion posicionDelAtacable=posicionAtacable.PosicionCorridaA(k,f);
                            esAtacableDesde=posicionDelAtacable.estaAlAlcance(posicionDelAtacante,this.rangoDeAtaque);
                                if(esAtacableDesde){
                            esAtacable=true;}}}}}
        if(esAtacable)
            edificioAtacado.recibirDanio(this.puntosDeAtaqueEdificio);
        else throw new AtaqueFueraDeRango();
    }

    }