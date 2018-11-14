package fiuba.algo3.algoempires;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        //TurnosRestantes = ... ??;
        //RestarOro..
    }

    public void reparar(){
        estado.reparar(this, 50);
    }

    //Metodo tipo estado en pikachu pero que se vaya restando turnos.
}
