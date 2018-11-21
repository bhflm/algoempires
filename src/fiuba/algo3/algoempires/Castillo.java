package fiuba.algo3.algoempires;

    public class Castillo extends Edificio {

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

}