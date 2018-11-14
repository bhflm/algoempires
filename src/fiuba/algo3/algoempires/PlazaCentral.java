package fiuba.algo3.algoempires;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        //TurnosRestantes = ... ??;
    }
    public void reparar(){
        estado.reparar(this, 25);
    }
    //Metodo tipo estado en pikachu pero que se vaya restando turnos.
}
