package fiuba.algo3.algoempires;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        dimension = 2;
        //TurnosRestantes = ... ??;
    }
    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 25, unAldeano);
    }
    //Metodo tipo estado en pikachu pero que se vaya restando turnos.
}
