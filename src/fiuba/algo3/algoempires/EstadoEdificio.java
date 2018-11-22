package fiuba.algo3.algoempires;

public interface EstadoEdificio {

    void reparar(Edificio unEdificio, int vida, Aldeano unAldeano);
    void continuarReparacion(Edificio unEdificio, int vida, Aldeano unAldeano);

    void recibirDanio(Edificio edificio, int danioRecibido);
}