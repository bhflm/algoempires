package fiuba.algo3.algoempires;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        dimension = 2;
        //TurnosRestantes = ... ??;
        //RestarOro..
    }
    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 50, unAldeano);
    }

    //Metodo tipo estado en pikachu pero que se vaya restando turnos.
}
