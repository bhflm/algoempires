package fiuba.algo3.algoempires;

    public class Castillo extends Edificio {

        public Castillo() {
            vidaMaxima = 1000;
            vida = 1000;
            dimension = 4;
        }

    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Posicion posicion){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        //Chequeo que se cree en alrededor del castillo
        int posicionMinima = this.getPosicion().getCoordenadaHorizontal() - 1;
        int posicionMaxima = this.getPosicion().getCoordenadaHorizontal() + this.dimension;

        if (posicion.getCoordenadaHorizontal() < posicionMinima || posicion.getCoordenadaVertical() > posicionMaxima){
            throw new PosicionInvalidaException();
        }
        mapa.UbicarUnidadEnMapa(posicion, armaDeAsedio);
        return armaDeAsedio;
    }
    
    @Override
    public void reparar(Aldeano unAldeano) {
        estado.reparar(this, 15, unAldeano);
    }
    public void continuarRepararacion(Aldeano unAldeano){
            estado.continuarReparacion(this, 15, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;}

}