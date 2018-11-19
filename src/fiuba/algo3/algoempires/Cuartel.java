package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Cuartel extends Edificio {

    public Cuartel(){
        vidaMaxima = 250;
        vida = 250;
        costo = 50;
        dimension = 2;
        //TurnosRestantes = ... ??;
    }
    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 50, unAldeano);
    }

    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};


}
