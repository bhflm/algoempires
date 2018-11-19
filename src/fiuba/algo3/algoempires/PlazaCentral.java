package fiuba.algo3.algoempires;

public class PlazaCentral extends Edificio {

    public PlazaCentral(){
        vidaMaxima = 450;
        vida = 450;
        costo = 1000;
        dimension = 2;
        turnosRestantes = 3;
    }

    public Aldeano crearAldeano(){
        return new Aldeano();
    }

    @Override
    public void reparar(Aldeano unAldeano){
        estado.reparar(this, 25, unAldeano);
    }
    public void continuarRepararacion(Aldeano unAldeano){
        estado.continuarReparacion(this, 25, unAldeano);
    }
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

}
