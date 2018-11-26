package fiuba.algo3.algoempires.Entidades;


public abstract class EstadoEdificio {

    void reparar(Edificio unEdificio, int vida, Aldeano unAldeano){};
    void continuarReparacion(Edificio unEdificio, int vida, Aldeano unAldeano){};

    public void recibirDanio(Edificio edificio, int danioRecibido){
        edificio.vida = edificio.vida - danioRecibido;
    }

    Arquero crearArquero(){ return new Arquero();}

    Espadachin crearEspadachin(){return new Espadachin();}

    Aldeano crearAldeano(){return new Aldeano();}
}

















