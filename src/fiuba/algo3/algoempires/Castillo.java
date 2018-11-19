package fiuba.algo3.algoempires;

import java.util.HashMap;

public class Castillo extends Edificio {

    public Castillo() {
        vidaMaxima = 1000;
        vida = 1000;
        dimension = 4;
    }

    @Override
    public void reparar(Aldeano unAldeano) {
        estado.reparar(this, 15, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}