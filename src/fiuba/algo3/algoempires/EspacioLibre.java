package fiuba.algo3.algoempires;

import fiuba.algo3.algoempires.Entidades.ArmaDeAsedio;
import fiuba.algo3.algoempires.Entidades.Arquero;
import fiuba.algo3.algoempires.Entidades.Castillo;
import fiuba.algo3.algoempires.Entidades.Espadachin;

public class EspacioLibre implements Ubicable{
    protected int dimension = 0;
    protected boolean PisableEnElMapa=true;

    public int getDimension() {return this.dimension;}
    public void actualizarUbicacion(Posicion posicion){}
    public boolean esPisableEnElMapa(){return this.PisableEnElMapa;};

    public void recibirDanio(Arquero arquero){};
    public void recibirDanio(Castillo castillo){};
    public void recibirDanio(Espadachin espadachin){};
    public void recibirDanio(ArmaDeAsedio armaDeAsedio) {};


}
