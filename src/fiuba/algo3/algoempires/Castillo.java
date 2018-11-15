package fiuba.algo3.algoempires;

public class Castillo extends Edificio {

    public Castillo(){
        vidaMaxima = 1000;
        vida = 1000;
        dimension = 4;
    }
    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 15, unAldeano);
    }
}