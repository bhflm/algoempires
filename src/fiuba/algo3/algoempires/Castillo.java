package fiuba.algo3.algoempires;

public class Castillo extends Edificio {

    public Castillo(){
            vidaMaxima = 1000;
            vida = 1000;
    }
    public void reparar(){
        estado.reparar(this, 15);
    }
}